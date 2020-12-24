package th.co.geniustree.jcc;

public class AstInterpreter {

  int interpret(AstNode node) {
    int leftValue = 0;
    int rightValue = 0;
    if (node.left != null) {
      leftValue = interpret(node.left);
    }
    if (node.right != null) {
      rightValue = interpret(node.right);
    }
    switch (node.nodeType) {
      case ADD:
        return leftValue + rightValue;
      case SUBTRACT:
        return leftValue - rightValue;
      case MULTIPLY:
        return leftValue * rightValue;
      case DIVIDE:
        return leftValue / rightValue;
      case INT_LITERAL: return node.intValue;
      default: throw new RuntimeException("Unknown AST operator"+node.nodeType);
    }
  }
}
