package th.co.geniustree.jcc;

public class Main {
  public static void main(String[] args) throws Exception {
    if (args.length == 0) {
      System.out.println("no input file.");
      return;
    }
    try (Scanner scanner = new Scanner(args[0])) {
      AstParser astParser = new AstParser(scanner);
      AstNode astNode = astParser.parseBinaryExpression();
    }
  }
}
