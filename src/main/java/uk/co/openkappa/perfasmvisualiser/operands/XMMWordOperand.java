package uk.co.openkappa.perfasmvisualiser.operands;

import uk.co.openkappa.perfasmvisualiser.Operand;

public class XMMWordOperand extends Operand {
  public XMMWordOperand(String name, int usedWidth) {
    super(16, usedWidth, name, name);
  }

  @Override
  public Operand adjustWidth(int newWidth) {
    return new XMMWordOperand(name, newWidth);
  }
}
