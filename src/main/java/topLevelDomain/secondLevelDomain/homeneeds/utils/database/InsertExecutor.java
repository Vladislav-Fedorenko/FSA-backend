package topLevelDomain.secondLevelDomain.homeneeds.utils.database;

import topLevelDomain.secondLevelDomain.homeneeds.utils.database.exeception.DatabaseTasksExecutorException;

public interface InsertExecutor<T> extends DatabaseTasksExecutor {

  void setInsertingObject(final T insertingObject) throws DatabaseTasksExecutorException;
  T getResult() throws DatabaseTasksExecutorException;
}
