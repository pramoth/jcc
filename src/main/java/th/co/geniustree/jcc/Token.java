package th.co.geniustree.jcc;

public class Token {
  enum TokenType {PLUS, MINUS, STAR, SLASH, INT_LITERAL}

  public TokenType tokenType;
  public int intValue;

  @Override
  public String toString() {
    if (tokenType == TokenType.INT_LITERAL) {
      return "Token{" +
        "tokenType=" + tokenType +
        ", intValue=" + intValue +
        '}';
    } else {
      return "Token{" +
        "tokenType=" + tokenType +
        '}';
    }
  }
}
