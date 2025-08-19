package bookreader.tasks;

import bookreader.helper.AuthorHelper;
import bookreader.io.IOBridge;

import java.util.List;

import bookreader.Book;

public class BookPrices implements Task {
  @Override
  public String getName() {
    return "List works and their prices of a given author";
  }

  @Override
  public void runTask(Book[] data, IOBridge ioBridge) {
    ioBridge.output("Author Name: ");
    String authorName = ioBridge.input();
    List<Book> books = AuthorHelper.findBooks(data, authorName);
    
    ioBridge.output(
      books.isEmpty()
        ? "No books by " + authorName
        : "Books by " + authorName
    );

    for (Book book: books)
      ioBridge.output(
        " - " + book.getName() + ": Price " + book.getPrice()
      );
  }
}
