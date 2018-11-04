package uk.co.openkappa.perfasmvisualiser.operands;

import uk.co.openkappa.perfasmvisualiser.Operand;

public class DWordOperand extends Operand {
  public DWordOperand(String registerName, String name, int usedWidth) {
    super(4, usedWidth, name, registerName);
  }

  @Override
  public Operand adjustWidth(int newWidth) {
    return new DWordOperand(registerName, name, newWidth);
  }
}
