package uk.co.openkappa.perfasmvisualiser;

public abstract class Operand {
  protected final int maxWidth;
  protected final int usedWidth;
  protected final String registerName;
  protected final String name;

  public Operand(int maxWidth, int usedWidth, String name, String registerName) {
    if (usedWidth > maxWidth)
      throw new IllegalStateException("Can't use " + usedWidth  + " > " + maxWidth);
    this.maxWidth = maxWidth;
    this.usedWidth = usedWidth;
    this.name = name;
    this.registerName = registerName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    Operand operand = (Operand) o;

    return operand.name.equals(name);
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
    return registerName + (isData() ? "[" + getUsedWidth() + "/" + getMaxWidth()  + "]" : "");
  }
}
