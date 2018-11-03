package uk.co.openkappa.perfasmvisualiser;

public class RawNode {

  private final double weight;
  private final String label;
  private final String instruction;
  private final String args;

  public RawNode(double weight, String label, String instruction, String args) {
    this.weight = weight;
    this.label = label;
    this.instruction = instruction;
    this.args = args;
  }

  public double getWeight() {
    return weight;
  }

  public String getLabel() {
    return label;
  }

  public String getInstruction() {
    return instruction;
  }

  public String getArgs() {
    return args;
  }

  @Override
  public String toString() {
    return label + ": " + instruction + " [" + args + "]" + " (" + weight + ")";
  }
}
