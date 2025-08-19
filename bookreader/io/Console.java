package bookreader.io;

import java.util.Scanner;

public class Console implements IOBridge {
  private Scanner scanner;

  public Console() {
    this.scanner = new Scanner(System.in);
  }

  @Override
  public void output(String content) {
    System.out.println(content);
  }

  @Override
  public String input() {
    System.out.print("-> ");
    return this.scanner.hasNextLine()
      ? this.scanner.nextLine()
      : null;
  }

  @Override
  public void close() {
    this.scanner.close();
  }
}
