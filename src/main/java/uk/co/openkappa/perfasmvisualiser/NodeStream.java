package uk.co.openkappa.perfasmvisualiser;

import java.util.*;

public class NodeStream {

  private final List<Node> nodes = new ArrayList<>();
  private final Map<String, Node> labeled = new HashMap<>();

  public DataFlow toDataFlow() {
    BitSet visited = new BitSet(nodes.size());
    DataFlow dataFlow = new DataFlow(labeled);
    Map<String, Link<String>> links = new HashMap<>();
    int position;
    while (visited.cardinality() < visited.size() && (position = visited.nextClearBit(0)) < nodes.size()) {
      Node node = nodes.get(position);
      visited.set(position);
      Link<String> chain = new Link<>(node.getLabel());
      traceDependencies(position, chain, node, visited, links);
      dataFlow.add(chain);
    }
    return dataFlow.postProcess();
  }

  public Node append(Node node) {
    nodes.add(0, node);
    labeled.put(node.getLabel(), node);
    return node;
  }

  public Node getHead() {
    return nodes.isEmpty() ? null : nodes.get(0);
  }

  private void traceDependencies(int mark, Link<String> chain, Node node, BitSet visited, Map<String, Link<String>> links) {
    for (Operand operand : node.getDependencies()) {
      if (!operand.isRoot()) {
        for (int i = mark + 1; i < nodes.size(); ++i) {
          Node candidate = nodes.get(i);
          if (operand.dependsOn(candidate.getOutput())) {
            visited.set(i);
            Link<String> cached = links.get(candidate.getLabel());
            if (null == cached) {
              Link<String> head = chain.link(candidate.getLabel());
              links.put(candidate.getLabel(), head);
              traceDependencies(i, head, candidate, visited, links);
            } else {
              chain.link(cached);
            }
            break;
          }
        }
      }
    }
  }
}
