package uk.co.openkappa.perfasmvisualiser;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;

public class Link<T> {

  private final List<Link<T>> links = new ArrayList<>();
  private final T value;

  public Link(T value) {
    this.value = value;
  }

  public Link<T> link(Link<T> link) {
    links.add(link);
    return link;
  }

  public Link<T> link(T link) {
    return link(new Link<>(link));
  }

  public double reduce(ToDoubleFunction<T> map) {
    double sum = map.applyAsDouble(value);
    for (Link<T> link : links) {
      sum += link.reduce(map);
    }
    return sum;
  }

  public <U> Link<U> map(Function<T, U> map) {
    Link<U> link = new Link<>(map.apply(value));
    for (Link<T> l : links) {
      link.link(l.map(map));
    }
    return link;
  }

  public <U> Link<U> map(BiFunction<List<Link<T>>, T, U> func) {
    Link<U> link = new Link<>(func.apply(links, value));
    for (Link<T> l : links) {
      link.link(l.map(func));
    }
    return link;
  }

  public boolean isLeaf() {
    return links.isEmpty();
  }

  public List<Link<T>> getLinks() {
    return links;
  }

  public T getValue() {
    return value;
  }

  @Override
  public String toString() {
    ToStringVisitor<T> visitor = new ToStringVisitor<>();
    return visitor.toString(this);
  }

  private static class ToStringVisitor<T> {

    private int depth = -1;

    public String toString(Link<T> link) {
      ++depth;
      String padding = padding();
      String toString = padding + link.value + "\n";
      for (Link<T> l : link.links) {
        toString += toString(l);
      }
      --depth;
      return toString;
    }

    private String padding() {
      String padding = "";
      for (int i = 0; i < depth; ++i) {
        padding += "  ";
      }
      return padding;
    }
  }
}
