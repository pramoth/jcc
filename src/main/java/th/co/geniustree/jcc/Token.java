package th.co.geniustree.jcc;

public class Token {
  enum ToeknType {PLUS, MINUS, STAR, SLASH, INT_LITERAL}

  public ToeknType tokenType;
  public int intValue;

  @Override
  public String toString() {
    if (tokenType == ToeknType.INT_LITERAL) {
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
