package th.co.geniustree.jcc;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Scanner implements AutoCloseable {
  private InputStreamReader reader;
  private int currentLine = 1;
  private int putBack = -1;

  public Scanner(FileReader reader) {
    this.reader = reader;
  }

  public Scanner(InputStream inputStream) {
    this.reader = new InputStreamReader(inputStream, StandardCharsets.US_ASCII);
  }

  public Scanner(String sourceCode) throws IOException {
    reader = new FileReader(sourceCode, StandardCharsets.US_ASCII);
  }

  public int next() {
    try {
      if (putBack > -1) {
        int ch = putBack;
        putBack = -1;
        return ch;
      }
      int ch = reader.read();
      if (ch == '\n') {
        currentLine++;
      }
      return ch;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public int skipWhiteSpaceUntilNextToken() {
    int ch = next();
    while (Character.isWhitespace(ch)) {
      ch = next();
    }
    return ch;
  }

  public int scanTo(Token token) {
    int ch = skipWhiteSpaceUntilNextToken();
    switch (ch) {
      case -1:
        return -1;
      case '+':
        token.tokenType = Token.ToeknType.PLUS;
        break;
      case '-':
        token.tokenType = Token.ToeknType.MINUS;
        break;
      case '*':
        token.tokenType = Token.ToeknType.STAR;
        break;
      case '/':
        token.tokenType = Token.ToeknType.SLASH;
        break;
      default:
        if (Character.isDigit(ch)) {
          token.tokenType = Token.ToeknType.INT_LITERAL;
          token.intValue = scanint(ch);
        } else {
          throw new RuntimeException("Unrecognised character " + (char) ch + " on line " + currentLine);
        }
    }
    return ch;
  }

  private int scanint(int ch) {
    int digitIndex = 0;
    int value = 0;
    while ((digitIndex = "0123456789".indexOf(ch)) > -1) {
      value = value * 10 + digitIndex;
      ch = next();
    }
    putBack = ch;
    return value;
  }

  @Override
  public void close() throws Exception {
    if (reader != null) {
      reader.close();
    }
  }
}
