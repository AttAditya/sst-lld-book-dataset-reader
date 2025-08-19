package bookreader.tasks;

import bookreader.helper.AuthorHelper;
import bookreader.io.IOBridge;

import java.util.List;

import bookreader.Book;

public class BookList implements Task {
  @Override
  public String getName() {
    return "List works of a given author";
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
      ioBridge.output(" - " + book.getName());
  }
}
