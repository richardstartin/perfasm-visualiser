package uk.co.openkappa.perfasmvisualiser.operands;

import uk.co.openkappa.perfasmvisualiser.Operand;

public class QWordOperand extends Operand {
  public QWordOperand(String registerName, String name, int usedWidth) {
    super(8, usedWidth, name, registerName);
  }

  @Override
  public Operand adjustWidth(int newWidth) {
    return new QWordOperand(registerName, name, newWidth);
  }
}
