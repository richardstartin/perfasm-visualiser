package uk.co.openkappa.perfasmvisualiser.operands;

import uk.co.openkappa.perfasmvisualiser.Operand;

public class ByteOperand extends Operand {
  public ByteOperand(String name) {
    super(1, 1, name, name);
  }

  @Override
  public Operand adjustWidth(int newWidth) {
    throw new IllegalStateException("Byte is indivisible");
  }
}
