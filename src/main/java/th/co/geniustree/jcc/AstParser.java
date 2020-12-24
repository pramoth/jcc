package th.co.geniustree.jcc;

public class AstParser {
  private Scanner scanner;
  private Token currentToken;

  public AstParser(Scanner scanner) {
    this.scanner = scanner;
  }
  private void scanNextToken(){
    currentToken = scanner.next();
  }
  public AstNode parseBinaryExpression(){
    scanNextToken();
    return binaryExpression();
  }

  private AstNode makeAstNode(AstNode.NodeType nodeType, AstNode left, AstNode right, int intValue) {
    AstNode node = new AstNode();
    node.nodeType = nodeType;
    node.left = left;
    node.right = right;
    node.intValue = intValue;
    return node;
  }

  private AstNode makeLeafNode(AstNode.NodeType nodeType, int intValue) {
    return makeAstNode(nodeType, null, null, intValue);
  }

  private AstNode makeUnary(AstNode.NodeType nodeType, AstNode left, int intValue) {
    return makeAstNode(nodeType, left, null, intValue);
  }

  private AstNode makePrimary() {
    switch (currentToken.tokenType) {
      case INT_LITERAL:
        AstNode node = makeLeafNode(AstNode.NodeType.INT_LITERAL, currentToken.intValue);
        scanNextToken();
        return node;
      default: throw new RuntimeException("syntax error on line "+scanner.getCurrentLine());
    }
  }
  private AstNode.NodeType arithmeticOperation(Token.TokenType tokenType) {
    switch (tokenType) {
      case PLUS:
        return AstNode.NodeType.ADD;
      case MINUS:
        return AstNode.NodeType.SUBTRACT;
      case STAR:
        return AstNode.NodeType.MULTIPLY;
      case SLASH:
        return AstNode.NodeType.DIVIDE;
      default:
        throw new RuntimeException("unknown token in "+tokenType+" on line "+scanner.getCurrentLine());
    }
  }
  private AstNode binaryExpression() {
    AstNode left;
    AstNode right;
    AstNode.NodeType nodeType;
    left = makePrimary();
    if(currentToken.tokenType == Token.TokenType.EOF){
      return left;
    }
    nodeType = arithmeticOperation(currentToken.tokenType);
    scanNextToken();
    right = binaryExpression();
    return makeAstNode(nodeType,left,right,0);
  }
}
