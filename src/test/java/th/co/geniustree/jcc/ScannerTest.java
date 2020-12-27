package th.co.geniustree.jcc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ScannerTest {
  @Test
  public void test1() throws Exception {
    Scanner scanner = new Scanner(getClass().getResourceAsStream("/ch01/input01"));
    try (scanner) {
      AstParser astParser = new AstParser(scanner);
      AstNode astNode = astParser.parseBinaryExpression();
      AstInterpreter astInterpreter = new AstInterpreter();
      int interpret = astInterpreter.interpret(astNode);
      System.out.println(interpret);
    }
  }

  @Test
  public void test2() throws Exception {
    Scanner scanner = new Scanner(getClass().getResourceAsStream("/ch01/input02"));
    try (scanner) {
      AstParser astParser = new AstParser(scanner);
      AstNode astNode = astParser.parseBinaryExpression();
      AstInterpreter astInterpreter = new AstInterpreter();
      int interpret = astInterpreter.interpret(astNode);
      System.out.println(interpret);
    }
  }

  @Test
  public void test3() throws Exception {
    Scanner scanner = new Scanner(getClass().getResourceAsStream("/ch01/input03"));
    Exception exception = assertThrows(RuntimeException.class, () -> {
      try (scanner) {
        AstParser astParser = new AstParser(scanner);
        AstNode astNode = astParser.parseBinaryExpression();
        AstInterpreter astInterpreter = new AstInterpreter();
        int interpret = astInterpreter.interpret(astNode);
        System.out.println(interpret);
      }
    });
    Assertions.assertEquals("syntax error on line 1, token INT_LITERAL", exception.getMessage());
  }

  @Test
  public void test4() throws Exception {
    Exception exception = assertThrows(RuntimeException.class, () -> {
      Scanner scanner = new Scanner(getClass().getResourceAsStream("/ch01/input04"));
      try (scanner) {
        AstParser astParser = new AstParser(scanner);
        AstNode astNode = astParser.parseBinaryExpression();
        AstInterpreter astInterpreter = new AstInterpreter();
        int interpret = astInterpreter.interpret(astNode);
        System.out.println(interpret);
      }
    });
    Assertions.assertEquals("Unrecognised character . on line 3", exception.getMessage());
  }

  @Test
  public void test5() throws Exception {
    Exception exception = assertThrows(RuntimeException.class, () -> {
      Scanner scanner = new Scanner(getClass().getResourceAsStream("/ch01/input05"));
      try (scanner) {
        AstParser astParser = new AstParser(scanner);
        AstNode astNode = astParser.parseBinaryExpression();
        AstInterpreter astInterpreter = new AstInterpreter();
        int interpret = astInterpreter.interpret(astNode);
        System.out.println(interpret);
      }
    });
    Assertions.assertEquals("Unrecognised character a on line 1", exception.getMessage());

  }
}
