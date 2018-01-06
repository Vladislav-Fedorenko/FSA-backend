package ru.fedoren.homeneeds.utils.database;

import ru.fedoren.homeneeds.utils.database.exeception.DatabaseTasksExecutorException;

public interface DatabaseTasksExecutor {
  void execute() throws DatabaseTasksExecutorException;
}
