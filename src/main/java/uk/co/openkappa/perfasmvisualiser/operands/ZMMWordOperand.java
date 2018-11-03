package uk.co.openkappa.perfasmvisualiser.operands;

import uk.co.openkappa.perfasmvisualiser.Operand;

public class ZMMWordOperand extends Operand {
  public ZMMWordOperand(String name, int usedWidth) {
    super(64, usedWidth, name, name);
  }

  @Override
  public Operand adjustWidth(int newWidth) {
    return new ZMMWordOperand(name, newWidth);
  }
}
