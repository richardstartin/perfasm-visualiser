package uk.co.openkappa.perfasmvisualiser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.*;
import java.util.stream.Collectors;

import static uk.co.openkappa.perfasmvisualiser.Node.modifyOutput;

public class DataFlow {

  private final List<Link<String>> chains;
  private final Map<String, Node> nodes;

  DataFlow(Map<String, Node> nodes) {
    this(nodes, new ArrayList<>());
  }

  DataFlow(Map<String, Node> nodes, List<Link<String>> chains) {
    this.nodes = nodes;
    this.chains = chains;
  }

  public void add(Link<String> chain) {
    chains.add(chain);
  }

  public DataFlow postProcess() {
    Map<String, Node> transformedNodes = new HashMap<>();
    for (var chain : chains) {
      propagateWidthUsage(transformedNodes, chain);
    }
    return new DataFlow(transformedNodes, chains);
  }

  private void propagateWidthUsage(Map<String, Node> accumulation, Link<String> chain) {
    String label = chain.getValue();
    Node node = nodes.get(label);
    int usedWidth = node.getOutput().getUsedWidth();
    int width = usedWidth;
    if (chain.isLeaf()) {
      width = node.getDependencies().stream().filter(Operand::propagateWidth).mapToInt(Operand::getUsedWidth).max().orElse(usedWidth);
    } else {
      for (Link<String> child : chain.getLinks()) {
        String l = child.getValue();
        propagateWidthUsage(accumulation, child);
        Node n = accumulation.get(l);
        if (n.getOutput().propagateWidth()) {
          width = Math.min(width, accumulation.get(l).getOutput().getUsedWidth());
        }
      }
    }
    int newWidth = Math.min(node.getOutput().getMaxWidth(), width);
    Operand ouput = node.getOutput();
    List<Operand> dependencies = node.getDependencies()
            .stream()
            .map(op -> op.hasUnknownWidth() ? op.adjustWidth(ouput.maxWidth, ouput.maxWidth) : op)
            .collect(Collectors.toList());
    boolean modifyOutput = node.getDependencies().stream().allMatch(Operand::propagateWidth);
    accumulation.put(label, modifyOutput(node, dependencies, modifyOutput ? ouput.adjustWidth(newWidth) : ouput));
  }

  public String toJson() {
    Gson gson = new GsonBuilder().create();
    return gson.toJson(Map.of("nodes", nodes, "chains", chains));
  }

  @Override
  public String toString() {
    return chains.stream().map(chain -> {
      Link<Node> expanded = chain.map(nodes::get);
      return new Object() {
        double weight = expanded.reduce(Node::getProfiledWeight);
        String toString = expanded.toString();
      };
    }).sorted(Comparator.comparingDouble(pair -> -pair.weight))
    .map(pair -> pair.weight + "\n" + pair.toString + "\n")
    .reduce("", String::concat);
  }
}
