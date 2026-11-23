import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node {
  ArrayList<Node> children;
  int uniqueInteger;

  Node(int uniqueInteger) {
    this.uniqueInteger = uniqueInteger;
    this.children = new ArrayList<>();
  }

  public void addChild(Node child) {
    this.children.add(child);
  }

  public int getUniqueInteger() {
    return this.uniqueInteger;
  }

  public ArrayList<Integer> getIntegersOfChildrenSorted() {
    ArrayList<Integer> integers = new ArrayList<>();
    for (Node child : this.children) {
      integers.add(child.getUniqueInteger());
    }

    Collections.sort(integers);
    return integers;
  }
}

public class Reachability {
  public static void main(String[] args) {
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);

    n1.addChild(n2);
    n1.addChild(n3);
    n1.addChild(n4);

    System.out.println(n1.getIntegersOfChildrenSorted());
  }
}
