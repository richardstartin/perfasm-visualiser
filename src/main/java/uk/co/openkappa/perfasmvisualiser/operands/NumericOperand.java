package uk.co.openkappa.perfasmvisualiser.operands;

import uk.co.openkappa.perfasmvisualiser.Operand;

public class NumericOperand extends Operand {

  public NumericOperand(int registerWidth, long value) {
    super(registerWidth, registerWidth, Long.toHexString(value), "0x" + Long.toHexString(value));
  }

  @Override
  public boolean isRoot() {
    return true;
  }

  @Override
  public Operand adjustWidth(int newWidth) {
    return new NumericOperand(maxWidth, newWidth);
  }

  @Override
  public Operand adjustWidth(int newMaxWidth, int newWidth) {
    return new NumericOperand(newMaxWidth, newWidth);
  }
}
