package th.co.geniustree.jcc;

public class Token {
  enum TokenType {PLUS(10), MINUS(10), STAR(20), SLASH(20), INT_LITERAL(0),EOF(0);
    public int precedance;

    TokenType(int precedance) {
      this.precedance = precedance;
    }
  }

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
