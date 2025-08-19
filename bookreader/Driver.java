// ATTADITYA.GITHUB.IO

package bookreader;

import bookreader.io.IOBridge;
import bookreader.io.Console;
import bookreader.tasks.AuthorsList;
import bookreader.tasks.BookCount;
import bookreader.tasks.BookList;
import bookreader.tasks.BookPrices;
import bookreader.tasks.BookRated;
import bookreader.tasks.PrintAll;
import bookreader.tasks.Task;
import bookreader.tasks.TaskManager;

public class Driver {
  public static void main(String[] args) {
    IOBridge ioBridge = new Console();
    String datasetPath;

    if (args.length < 1) {
      ioBridge.output("Path to Dataset:");
      datasetPath = ioBridge.input();
    } else {
      datasetPath = args[0];
    }

    DatasetReader datasetReader = new DatasetReader();
    Book[] books = datasetReader.getBooks(datasetPath);

    TaskManager taskManager = new TaskManager(new Task[] {
      new BookCount(),
      new AuthorsList(),
      new BookList(),
      new BookRated(),
      new BookPrices(),
      new PrintAll(),
    }, books, ioBridge);

    while (taskManager.isActive()) {
      String[] choices = taskManager.getChoices();
      for (int choiceIndex = 0; choiceIndex < choices.length; choiceIndex++)
        ioBridge.output(choiceIndex + ": " + choices[choiceIndex]);
      
      int choosen = Integer.parseInt(ioBridge.input());
      taskManager.performTask(choosen);
      ioBridge.output("");
    }
  }
}
