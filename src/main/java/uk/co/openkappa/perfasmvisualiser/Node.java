package uk.co.openkappa.perfasmvisualiser;

import uk.co.openkappa.perfasmvisualiser.operands.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

import static uk.co.openkappa.perfasmvisualiser.Regexes.*;

public class Node {

  public static Node modifyOutput(Node node, List<Operand> dependencies, Operand output) {
    return new Node(node.profiledWeight, node.label, node.instructionName, node.isConditional, dependencies, output);
  }

  public static Node modifyOutput(Node node, Operand output) {
    return new Node(node.profiledWeight, node.label, node.instructionName, node.isConditional, node.dependencies, output);
  }

  public static Node parse(NodeStream nodes, String label, String instructionName, String args, double profiledWeight) {
    // assume at&t syntax
    String iname = instructionName.toLowerCase().trim();
    if (iname.startsWith("j")) { // treat jumps specially
      if (!LABEL.matcher(args).matches()) {
        throw new IllegalStateException(args + " should be a control flow node");
      }
      if (iname.equals("jmp")) { // unconditional jump
        return new Node(profiledWeight, label, iname, false, List.of(), new ControlFlowOperand(label, args));
      }
      // then it's a conditional jump and we need to look up the last instruction in the stream
      Node predecessor = nodes.getHead();
      return new Node(profiledWeight, label, iname, false,
              null == predecessor ? List.of() : List.of(predecessor.getOutput()), new ControlFlowOperand(label, args));
    }
    if (iname.startsWith("call")) { // treat calls specially
      if (LABEL.matcher(args).matches()) {
        return new Node(profiledWeight, label, iname, false, List.of(), new ControlFlowOperand(label, args));
      } else if (args.charAt(0) == '*') {
        IndirectReferenceOperand operand = (IndirectReferenceOperand) parse(iname, args);
        return new Node(profiledWeight, label, iname, false, List.of(operand), operand.getOperand());
      }
    }
    List<String> tokens = tokenise(args);
    List<Operand> input = tokens.stream().limit(tokens.size() - 1).map(token -> parse(iname, token)).collect(Collectors.toList());
    Operand output = parse(iname, tokens.get(tokens.size() - 1));
    return new Node(profiledWeight, label, iname, IS_CONDITIONAL.matcher(iname).matches(), input, output);
  }

  private static List<String> tokenise(String args) {
    if (LABEL.matcher(args).matches()) {
      return List.of(args);
    }
    List<String> tokens = new ArrayList<>();
    String remaining = args;
    while (!remaining.isEmpty()) {
      while (remaining.charAt(0) == ',') {
        remaining = remaining.substring(1);
      }
      Matcher isMemoryAddress = OFFSET_EXPR.matcher(remaining);
      if (isMemoryAddress.matches() || remaining.charAt(0) == '(') {
        int index = remaining.indexOf(')') + 1;
        tokens.add(remaining.substring(0, index));
        remaining = remaining.substring(index);
      } else {
        int index = remaining.indexOf(',');
        if (index == -1) {
          tokens.add(remaining);
          remaining = "";
        } else {
          tokens.add(remaining.substring(0, index));
          remaining = remaining.substring(index, remaining.length());
        }
      }
    }
    return tokens;
  }

  private static Operand parse(String instruction, String token) {
    if (!token.isEmpty()) {
      if (token.charAt(0) == '(' && token.charAt(token.length() - 1) == ')') {
        return new IndirectReferenceOperand(parse(instruction, token.substring(1, token.length() - 1)));
      }
      if (token.charAt(0) == '*') {
        return new IndirectReferenceOperand(parse(instruction, token.substring(1)));
      }
      if (OFFSET_EXPR.matcher(token).matches()) {
        int width = instructionDefinedWidth(instruction);
        return new MemoryAddressOperand(Math.max(width, 4), width, token);
      }
      if (DECIMAL.matcher(token).matches()) {
        return new NumericOperand(4, Integer.parseInt(token));
      }
      if (NUMERIC_OPERAND.matcher(token).matches()) {
        String hex = token.substring(1);
        if (hex.length() > 10) {
          return new NumericOperand(8, Long.decode(hex));
        }
        return new NumericOperand(4, Long.decode(hex));
      }
      if (token.contains("xmm")) {
        return new XMMWordOperand(token, Math.min(instructionDefinedWidth(instruction), 16));
      }
      if (token.contains("ymm")) {
        return new YMMWordOperand(token, Math.min(instructionDefinedWidth(instruction), 32));
      }
      if (token.contains("zmm")) {
        return new ZMMWordOperand("zmm", Math.min(instructionDefinedWidth(instruction), 64));
      }
      String registerName = token.startsWith("%") ? token.substring(1) : token;
      if (registerName.startsWith("r")) {
        if (registerName.endsWith("d")) {
          return new QWordOperand(token, registerName.substring(0, registerName.length() - 1), Math.min(instructionDefinedWidth(instruction), 4));
        }
        if (registerName.endsWith("w")) {
          return new QWordOperand(token, registerName.substring(0, registerName.length() - 1), Math.min(instructionDefinedWidth(instruction), 2));
        }
        if (registerName.endsWith("b")) {
          return new QWordOperand(token, registerName.substring(0, registerName.length() - 1), 1);
        }
        return new QWordOperand(token, registerName, Math.min(instructionDefinedWidth(instruction), 8));
      }
      if (registerName.startsWith("e")) {
        return new DWordOperand(token, registerName, 4);
      }
      if (registerName.length() == 2 && registerName.charAt(1) == 'x') {
        return new WordOperand(token, registerName, 2);
      }
      if (registerName.length() == 2) {
        return new ByteOperand(token, registerName);
      }
    }
    throw new IllegalStateException(token);
  }

  private static int instructionDefinedWidth(String instruction) {
    switch (instruction) {
      case "vmovdqu":
      case "vmovdq":
        return 32;
      case "vmovd":
        return 16;
      case "mov":
        return 4;
      case "movzbl":
        return 1;
      case "movq":
        return 8;
      default:
        return Integer.MAX_VALUE;
    }
  }

  private final double profiledWeight;
  private final String label;
  private final String instructionName;
  private final boolean isConditional;
  private final List<? extends Operand> dependencies;
  private final Operand output;

  public Node(double profiledWeight, String label, String instructionName, boolean isConditional,
              List<? extends Operand> dependencies, Operand output) {
    this.profiledWeight = profiledWeight;
    this.label = label;
    this.instructionName = instructionName;
    this.isConditional = isConditional;
    this.dependencies = dependencies.stream()
            .map(op -> op.hasUnknownWidth() ? op.adjustWidth(output.maxWidth, output.usedWidth) : op)
            .collect(Collectors.toList());
    this.output = output;
  }

  public String getInstructionName() {
    return instructionName;
  }

  public String getLabel() {
    return label;
  }

  public List<? extends Operand> getDependencies() {
    return dependencies;
  }

  public Operand getOutput() {
    return output;
  }

  public double getProfiledWeight() {
    return profiledWeight;
  }

  public boolean isConditional() {
    return isConditional;
  }

  @Override
  public String toString() {
    return label + ": " + instructionName + " " + dependencies  + " -> " + output + " (" + profiledWeight + ")";
  }
}
