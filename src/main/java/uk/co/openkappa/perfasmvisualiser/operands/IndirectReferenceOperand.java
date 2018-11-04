package uk.co.openkappa.perfasmvisualiser.operands;

import uk.co.openkappa.perfasmvisualiser.Operand;

public class IndirectReferenceOperand extends Operand {

  private final Operand operand;

  public IndirectReferenceOperand(Operand operand) {
    super(operand.getMaxWidth(), operand.getUsedWidth(), operand.getName(), "(" + operand.getInputName() + ")");
    this.operand = operand;
  }

  @Override
  public boolean isRoot() {
    return operand.isRoot();
  }

  @Override
  public boolean dependsOn(Operand operand) {
    return this.operand.getName().equals(operand.getName());
  }

  @Override
  public Operand adjustWidth(int newWidth) {
    return new IndirectReferenceOperand(operand.adjustWidth(newWidth));
  }

  @Override
  public Operand adjustWidth(int newMaxWidth, int newWidth) {
    return new IndirectReferenceOperand(operand.adjustWidth(newMaxWidth, newWidth));
  }

  public Operand getOperand() {
    return operand;
  }
}
