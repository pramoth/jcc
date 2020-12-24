package th.co.geniustree.jcc;

public class AstNode {
  enum NodeType {ADD, SUBTRACT, MULTIPLY, DIVIDE, INT_LITERAL}
  NodeType nodeType;
  public AstNode left;
  public AstNode right;
  public int intValue;
}
