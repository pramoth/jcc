package th.co.geniustree.jcc;

public class Main {
  public static void main(String[] args) throws Exception {
    if (args.length == 0) {
      System.out.println("no input file.");
      return;
    }
    try (Scanner scanner = new Scanner(args[0])) {
      Token token = new Token();
      try (scanner) {
        while (scanner.scanTo(token) > -1) {
          System.out.println(token);
        }
      }
    }
  }
}
