import common.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem_0003Test {

  @Test
  void serialize() {

    Node node = new Node("root", new Node("left", new Node("left.left")), new Node("right"));

    String serialized =
            """
Node: "root"
  Node: "left"
    Node: "left.left"
      null
      null
    null
  Node: "right"
    null
    null""";

    assertEquals(serialized, Problem_0003.serialize(node));
  }

  /**
   * The following test should pass: * *
   *
   * <p>node =new Node("root", new Node("left", new Node("left.left")), new Node("right")); assert *
   * deserialize(serialize(node)).left.left.val == 'left.left'
   */
  @Test
  void deserialize() {

    Node node = new Node("root", new Node("left", new Node("left.left")), new Node("right"));

    assertEquals("left.left", Problem_0003.deserialize(Problem_0003.serialize(node)).getLeft().getLeft().getValue());
  }
}