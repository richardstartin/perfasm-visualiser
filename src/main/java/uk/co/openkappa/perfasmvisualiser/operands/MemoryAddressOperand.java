package uk.co.openkappa.perfasmvisualiser.operands;

import uk.co.openkappa.perfasmvisualiser.Operand;

import java.util.List;

public class MemoryAddressOperand extends Operand {

  private final List<Operand> operands;

  public MemoryAddressOperand(int registerWidth, int usedWidth, String location, List<Operand> operands) {
    super(registerWidth, usedWidth, location, location);
    this.operands = operands;
  }

  @Override
  public boolean dependsOn(Operand operand) {
    for (Operand op : operands) {
      if (operand.getName().equals(op.getName())) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean propagateWidth() {
    return false;
  }

  @Override
  public Operand adjustWidth(int newWidth) {
    return this;
  }

  @Override
  public Operand adjustWidth(int newMaxWith, int newWidth) {
    return new MemoryAddressOperand(newMaxWith, newWidth, inputName, operands);
  }
}
