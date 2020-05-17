package common;

import java.util.Collections;

public class Node {
  private String value;
  private Node left;
  private Node right;

  public Node(String value, Node left, Node right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  public Node(String value, Node left) {
    this(value, left, null);
  }

  public Node(String value) {
    this(value, null, null);
  }

  public String getValue() {
    return value;
  }

  public Node getLeft() {
    return left;
  }

  public Node getRight() {
    return right;
  }

  /**
   * Serializes the tree into a string
   *
   * @return serialized representation of a tree
   */
  public String toString() {
    // we start indentation at zero for the root.
    return toString(0);
  }

  /**
   * Serializes the tree into a string
   *
   * @return serialized representation of a tree
   */
  public String toString(int indent) {

    String spacer = "  ";
    String bump = String.join("", Collections.nCopies(indent, spacer));

    StringBuilder sb = new StringBuilder(bump);
    sb.append("Node: ");

    bump = bump + spacer;

    if (value == null) {
      sb.append("null");

    } else {
      sb.append("\"");
      sb.append(value);
      sb.append("\"");
    }

    if (this.left == null) {
      sb.append("\n");
      sb.append(bump);
      sb.append("null");

    } else {
      sb.append("\n");
      sb.append(this.left.toString(indent + 1));
    }

    if (this.right == null) {
      sb.append("\n");
      sb.append(bump);
      sb.append("null");

    } else {
      sb.append("\n");
      sb.append(this.right.toString(indent + 1));
    }

    return sb.toString();
  }

  /**
   * deserializes the string back into the tree.
   *
   * @param serialized serialized tree as string
   * @return de-serialized tree
   */
  public static Node deserialize(String serialized) {

    String marker = "Node: ";
    int valueStart = serialized.indexOf(marker);

    if (valueStart < 0) {
      return null;
    }

    valueStart += marker.length();
    int valueEnd = serialized.indexOf("\n");
    String value = serialized.substring(valueStart, valueEnd);

    if (value.charAt(0) == '"') {
      value = value.substring(1, value.length() - 1);
    } else {
      value = null;
    }

    String modified = serialized.replaceAll("\n  ", "\n");
    modified = modified.substring(valueEnd + 1);

    int rightStart = Math.max(modified.indexOf("\nN"), modified.indexOf("\nn")) + 1;

    Node left = null;
    if (modified.substring(0, 4) != "null") {
      left = deserialize(modified.substring(0, rightStart));
    }

    Node right = null;
    if (modified.substring(rightStart, rightStart + 4) != "null") {
      right = deserialize(modified.substring(rightStart));
    }

    return new Node(value, left, right);
  }
}
