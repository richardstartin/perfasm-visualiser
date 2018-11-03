package uk.co.openkappa.perfasmvisualiser.operands;

import uk.co.openkappa.perfasmvisualiser.Operand;

public class ControlFlowOperand extends Operand {

  private final String address;

  public ControlFlowOperand(String name, String address) {
    super(0, 0, name, name);
    this.address = address;
  }

  public String getAddress() {
    return address;
  }

  @Override
  public Operand adjustWidth(int newWidth) {
    return this;
  }
}
