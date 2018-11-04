package uk.co.openkappa.perfasmvisualiser;

public abstract class Operand {
  protected final int maxWidth;
  protected final int usedWidth;
  protected final String inputName;
  protected final String name;

  public Operand(int maxWidth, int usedWidth, String name, String inputName) {
    if (usedWidth > maxWidth)
      throw new IllegalStateException("Can't use " + usedWidth  + " > " + maxWidth);
    this.maxWidth = maxWidth;
    this.usedWidth = usedWidth;
    this.name = name;
    this.inputName = inputName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (!(o instanceof Operand)) return false;

    Operand operand = (Operand) o;

    return operand.name.equals(name);
  }

  public boolean dependsOn(Operand operand) {
    return operand.name.equals(name);
  }

  public boolean propagateWidth() {
    return true;
  }

  public boolean isRoot() {
    return false;
  }

  public int getMaxWidth() {
    return maxWidth;
  }

  public int getUsedWidth() {
    return usedWidth;
  }

  public String getName() {
    return name;
  }

  public String getInputName() {
    return inputName;
  }

  public abstract Operand adjustWidth(int newWidth);

  public Operand adjustWidth(int newMaxWith, int newWidth) {
    return adjustWidth(newWidth);
  }

  public boolean isData() {
    return getMaxWidth() > 0;
  }

  public boolean hasUnknownWidth() {
    return usedWidth == Integer.MAX_VALUE;
  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }

  @Override
  public String toString() {
    return inputName + (isData() ? "[" + getUsedWidth() + "/" + getMaxWidth()  + "]" : "");
  }
}
