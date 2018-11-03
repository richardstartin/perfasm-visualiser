package uk.co.openkappa.perfasmvisualiser.operands;

import uk.co.openkappa.perfasmvisualiser.Operand;

public class YMMWordOperand extends Operand {
  public YMMWordOperand(String name, int usedWidth) {
    super(32, usedWidth, name, name);
  }

  @Override
  public Operand adjustWidth(int newWidth) {
    return new YMMWordOperand(name, newWidth);
  }
}
