package bookreader.io;

public interface IOBridge {
  public void output(String content);
  public String input();
  public void close();
}
