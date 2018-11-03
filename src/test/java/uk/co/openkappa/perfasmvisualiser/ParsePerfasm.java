package uk.co.openkappa.perfasmvisualiser;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ParsePerfasm {

  @Test
  public void parseScalar() throws IOException {
    System.out.println(new PerfasmVisualiser().traceDependencies("src/test/resources/perfasm_scalar_sample.txt"));
  }

  @Test
  public void parse() throws IOException {
    System.out.println(new PerfasmVisualiser().traceDependencies("src/test/resources/perfasm_vector_sample.txt"));
  }

  @Test
  public void parse2() throws IOException {
    System.out.println(new PerfasmVisualiser().traceDependencies("src/test/resources/perfasm_vector_sample2.txt"));
  }


  @Test
  public void parseSingleChain() throws IOException {
    System.out.println(new PerfasmVisualiser().traceDependencies("src/test/resources/single_chain.txt"));
  }



}
