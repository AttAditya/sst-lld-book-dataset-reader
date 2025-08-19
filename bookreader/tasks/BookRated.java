package bookreader.tasks;

import java.util.ArrayList;
import java.util.List;

import bookreader.io.IOBridge;
import bookreader.Book;

public class BookRated implements Task {
  @Override
  public String getName() {
    return "List works with a given rating";
  }

  @Override
  public void runTask(Book[] data, IOBridge ioBridge) {
    ioBridge.output("Rating: ");
    double rating = Double.parseDouble(ioBridge.input());
    List<Book> books = new ArrayList<>();

    for (Book book: data)
      if (book.getUserRating() == rating)
        books.add(book);
    
    ioBridge.output(
      books.isEmpty()
        ? "No books rated " + rating
        : "Books rated " + rating
    );

    for (Book book: books)
      ioBridge.output(" - " + book.getName());
  }
}
