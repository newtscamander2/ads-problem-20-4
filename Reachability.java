/*public ArrayList<Integer> getIntegersOfChildrenSorted() {
  ArrayList<Integer> integers = new ArrayList<>();
  for (Node child : this.children) {
    integers.add(child.getUniqueInteger());
  }

  Collections.sort(integers);
  return integers;
}*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node {
  public ArrayList<Node> children;
  public ArrayList<Node> parents;

  public int uniqueInteger;
  public Node pi;
  public String color = "white";
  public int d;
  public int f;
  public int minValue;

  Node(int uniqueInteger) {
    this.uniqueInteger = uniqueInteger;
    this.children = new ArrayList<>();
    this.parents = new ArrayList<>();
  }

  public void addChild(Node child) {
    this.children.add(child);
    child.parents.add(this);
  }

  public int getUniqueInteger() {
    return this.uniqueInteger;
  }
}

public class Reachability {
  public static int time = 0;

  public static void dfs(Node[] G) {
    Node[] byLabel = new Node[G.length];
    for (Node u : G) {
      byLabel[u.uniqueInteger - 1] = u;
    }

    for (Node u : byLabel) {
      if (u.color.equals("white")) {
        dfsVisit(u, u.uniqueInteger);
      }
    }
  }

  public static void dfsVisit(Node u, int label) {
    u.color = "black";
    u.minValue = label;

    for (Node v : u.parents) {
      if (v.color.equals("white")) {
        dfsVisit(v, label);
      }
    }
  }

  public static void main(String[] args) {
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);

    n1.addChild(n2);
    n1.addChild(n3);
    n1.addChild(n4);

    n2.addChild(n3);
    n3.addChild(n3);
    n4.addChild(n2);
    n4.addChild(n1);

    Node[] G = {n1, n2, n3, n4};

    dfs(G);

    for (Node u : G) {
      System.out.println("MIN(" + u.uniqueInteger + ") is " + u.minValue);
    }
  }
}
