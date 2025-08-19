package bookreader.tasks;

import bookreader.helper.AuthorHelper;
import bookreader.io.IOBridge;

import java.util.List;

import bookreader.Book;

public class BookCount implements Task {
  @Override
  public String getName() {
    return "Count of all books of a given author";
  }

  @Override
  public void runTask(Book[] data, IOBridge ioBridge) {
    ioBridge.output("Author Name: ");
    String authorName = ioBridge.input();
    List<Book> books = AuthorHelper.findBooks(data, authorName);
    ioBridge.output("Count: " + books.size());
  }
}
