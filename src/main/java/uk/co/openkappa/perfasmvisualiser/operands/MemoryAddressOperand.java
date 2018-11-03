package uk.co.openkappa.perfasmvisualiser.operands;

import uk.co.openkappa.perfasmvisualiser.Operand;

public class MemoryAddressOperand extends Operand {


  public MemoryAddressOperand(int registerWidth, int usedWidth, String location) {
    super(registerWidth, usedWidth, location, location);
  }

  @Override
  public boolean isRoot() {
    return true;
  }

  @Override
  public Operand adjustWidth(int newWidth) {
    return new MemoryAddressOperand(getMaxWidth(), newWidth, registerName);
  }

  @Override
  public Operand adjustWidth(int newMaxWith, int newWidth) {
    return new MemoryAddressOperand(newMaxWith, newWidth, registerName);
  }
}
