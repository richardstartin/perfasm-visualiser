package uk.co.openkappa.perfasmvisualiser.operands;

import uk.co.openkappa.perfasmvisualiser.Operand;

public class WordOperand extends Operand {
  public WordOperand(String inputName, String name, int usedWidth) {
    super(2, usedWidth, name, inputName);
  }

  @Override
  public Operand adjustWidth(int newWidth) {
    return new WordOperand(inputName, name, newWidth);
  }
}
