package uk.co.openkappa.perfasmvisualiser;

import java.util.regex.Pattern;

public class Regexes {

  public static final Pattern NUMERIC_OPERAND = Pattern.compile("\\$0x[0-9a-fA-F]+");

  public static final Pattern DECIMAL = Pattern.compile("\\d+");

  public static final Pattern LABEL = Pattern.compile("0x[0-9a-fA-F]{16}");

  public static final Pattern IS_CONDITIONAL = Pattern.compile("(test)|(cmp.*)");

  public static final Pattern OFFSET_EXPR = Pattern.compile("(^0x[0-9a-fA-F]+)\\((.*)");
}
