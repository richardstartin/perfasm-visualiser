package uk.co.openkappa.perfasmvisualiser.operands;

import uk.co.openkappa.perfasmvisualiser.Operand;

public class ByteOperand extends Operand {
  public ByteOperand(String inputName, String name) {
    super(1, 1, name, inputName);
  }

  @Override
  public Operand adjustWidth(int newWidth) {
    return this;
  }
}
