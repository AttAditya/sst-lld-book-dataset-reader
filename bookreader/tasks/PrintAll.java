package bookreader.tasks;

import bookreader.Book;
import bookreader.io.IOBridge;

public class PrintAll implements Task {
  @Override
  public String getName() {
    return "Print details of all books";
  }

  @Override
  public void runTask(Book[] data, IOBridge ioBridge) {
    for (Book book: data)
      if (book != null)
        book.printDetails();
  }
}
