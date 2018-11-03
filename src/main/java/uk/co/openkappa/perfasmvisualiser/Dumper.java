package uk.co.openkappa.perfasmvisualiser;

import java.io.IOException;

public class Dumper {

  public static void main(String[] args) throws IOException {
    PerfasmVisualiser visualiser = new PerfasmVisualiser();
    for (String filename : args) {
      System.out.println(visualiser.traceDependencies(filename));
    }
  }
}
