package bookreader.tasks;

import bookreader.Book;
import bookreader.io.IOBridge;

public class TaskManager {
  private Task[] tasks;
  private Book[] data;
  private IOBridge ioBridge;
  private boolean active;

  public TaskManager(Task[] tasks, Book[] data, IOBridge ioBridge) {
    this.tasks = tasks;
    this.data = data;
    this.ioBridge = ioBridge;
    this.active = true;
  }
  
  public boolean isActive() {
    return this.active;
  }

  public void performTask(int taskId) {
    if (taskId == 0) {
      this.active = false;
      return;
    }

    if (taskId < 0 || taskId > this.tasks.length)
      throw new RuntimeException(
        "Invalid Task ID!"
      );
    
    tasks[taskId - 1].runTask(this.data, this.ioBridge);
  }

  public String[] getChoices() {
    String[] taskChoices = new String[tasks.length + 1];
    
    taskChoices[0] = "Exit";
    for (int taskId = 0; taskId < tasks.length; taskId++)
      taskChoices[taskId + 1] = tasks[taskId].getName();

    return taskChoices;
  }
}
