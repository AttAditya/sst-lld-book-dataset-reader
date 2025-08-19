package bookreader.tasks;

import bookreader.Book;
import bookreader.io.IOBridge;

public interface Task {
  public String getName();
  public void runTask(Book[] data, IOBridge ioBridge);
}
