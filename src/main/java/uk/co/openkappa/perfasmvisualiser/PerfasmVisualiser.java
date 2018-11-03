package uk.co.openkappa.perfasmvisualiser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class PerfasmVisualiser {

  private static final Pattern NODE = Pattern.compile("((\\d+.\\d+)%)?(.*)(0x[0-9a-f]{16}):\\s([a-z0-9]+)\\s(.*)");

  Stream<RawNode> clean(String file) throws IOException {
    Path perfasm = Paths.get(file);
    return Files.readAllLines(perfasm)
            .stream()
            .map(str -> str.replaceAll(";.*", "").trim())
            .map(str -> {
              Matcher nodeMatcher = NODE.matcher(str);
              if (nodeMatcher.matches()) {
                String profile = nodeMatcher.group(1);
                double weight = null == profile ? 0D : Double.parseDouble(nodeMatcher.group(2));
                String identity = nodeMatcher.group(4).trim();
                String instruction = nodeMatcher.group(5).trim();
                String args = nodeMatcher.group(6).trim();
                return new RawNode(weight, identity, instruction, args);
              }
              return null;
            })
            .filter(Objects::nonNull);
  }

  NodeStream toNodeStream(String file) throws IOException {
    NodeStream nodes = new NodeStream();
    clean(file).forEach(rn -> nodes.append(Node.parse(nodes, rn.getLabel(), rn.getInstruction(), rn.getArgs(), rn.getWeight())));
    return nodes;
  }

  public DataFlow traceDependencies(String file) throws IOException {
    return toNodeStream(file).toDataFlow();
  }

}
