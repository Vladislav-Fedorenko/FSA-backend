package topLevelDomain.secondLevelDomain.homeneeds.utils.database.extending;

import topLevelDomain.secondLevelDomain.homeneeds.utils.database.DatabaseTasksExecutor;
import topLevelDomain.secondLevelDomain.homeneeds.utils.database.exeception.DatabaseTasksExecutorException;

public interface InsertExecutor<T> extends DatabaseTasksExecutor {

  void setInsertedObject(final T insertedObject) throws DatabaseTasksExecutorException;
  T getResult() throws DatabaseTasksExecutorException;
}
