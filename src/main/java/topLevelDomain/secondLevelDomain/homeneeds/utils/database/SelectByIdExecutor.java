package topLevelDomain.secondLevelDomain.homeneeds.utils.database;

import topLevelDomain.secondLevelDomain.homeneeds.utils.database.exeception.DatabaseTasksExecutorException;

public interface SelectByIdExecutor<T> extends DatabaseTasksExecutor {

  void setId(final Long id) throws DatabaseTasksExecutorException;
  T getResult() throws DatabaseTasksExecutorException;
}
