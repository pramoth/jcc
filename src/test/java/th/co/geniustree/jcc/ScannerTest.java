package th.co.geniustree.jcc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ScannerTest {
  @Test
  public void test1() throws Exception {
    Scanner scanner = new Scanner(getClass().getResourceAsStream("/ch01/input01"));
    Token token = new Token();
    try (scanner) {
      while (scanner.scanTo(token) > -1) {
        System.out.println(token);
      }
    }
  }

  @Test
  public void test2() throws Exception {
    Scanner scanner = new Scanner(getClass().getResourceAsStream("/ch01/input02"));
    Token token = new Token();
    try (scanner) {
      while (scanner.scanTo(token) > -1) {
        System.out.println(token);
      }
    }
  }

  @Test
  public void test3() throws Exception {
    Scanner scanner = new Scanner(getClass().getResourceAsStream("/ch01/input03"));
    Token token = new Token();
    try (scanner) {
      while (scanner.scanTo(token) > -1) {
        System.out.println(token);
      }
    }
  }

  @Test
  public void test4() throws Exception {
    Exception exception = assertThrows(RuntimeException.class, () -> {
      Scanner scanner = new Scanner(getClass().getResourceAsStream("/ch01/input04"));
      Token token = new Token();
      try (scanner) {
        while (scanner.scanTo(token) > -1) {
          System.out.println(token);
        }
      }
    });
    Assertions.assertEquals("Unrecognised character . on line 3", exception.getMessage());
  }

  @Test
  public void test5() throws Exception {
    Exception exception = assertThrows(RuntimeException.class, () -> {
      Scanner scanner = new Scanner(getClass().getResourceAsStream("/ch01/input05"));
      Token token = new Token();
      try (scanner) {
        while (scanner.scanTo(token) > -1) {
          System.out.println(token);
        }
      }
    });
    Assertions.assertEquals("Unrecognised character a on line 1", exception.getMessage());

  }
}
