package uk.co.openkappa.perfasmvisualiser.operands;

import uk.co.openkappa.perfasmvisualiser.Operand;

public class WordOperand extends Operand {
  public WordOperand(String registerName, String name, int usedWidth) {
    super(2, usedWidth, name, registerName);
  }

  @Override
  public Operand adjustWidth(int newWidth) {
    return new WordOperand(registerName, name, newWidth);
  }
}
