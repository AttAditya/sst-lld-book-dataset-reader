package bookreader.tasks;

import java.util.HashSet;
import java.util.Set;

import bookreader.Book;
import bookreader.io.IOBridge;

public class AuthorsList implements Task {
  @Override
  public String getName() {
    return "List name of all authors";
  }

  @Override
  public void runTask(Book[] data, IOBridge ioBridge) {
    Set<String> authors = new HashSet<>();
    
    for (Book book: data)
      if (book != null)
        authors.add(book.getAuthor());
    
    for (String author: authors)
      ioBridge.output(" - " + author);
  }
}
