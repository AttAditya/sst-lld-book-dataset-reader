package bookreader.helper;

import java.util.ArrayList;
import java.util.List;

import bookreader.Book;

public class AuthorHelper {
  public static List<Book> findBooks(Book[] books, String authorName) {
    List<Book> works = new ArrayList<>();

    for (Book book: books)
      if (book != null && book.getAuthor().equals(authorName))
        works.add(book);

    return works;
  }
}
