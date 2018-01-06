package ru.fedoren.homeneeds.utils.database.exeception;

public class DatabaseTasksExecutorException extends Throwable {
  public DatabaseTasksExecutorException(String s, Throwable throwable) {
    super(s, throwable);
  }

  public DatabaseTasksExecutorException(String s) {
    super(s);
  }
}
