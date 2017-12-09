package topLevelDomain.secondLevelDomain.homeneeds.utils.database.extending;

import topLevelDomain.secondLevelDomain.homeneeds.utils.database.DatabaseTasksExecutor;
import topLevelDomain.secondLevelDomain.homeneeds.utils.database.exeception.DatabaseTasksExecutorException;

public interface UpdateExecutor<T> extends DatabaseTasksExecutor {

  void setId(final Long id) throws DatabaseTasksExecutorException;
  void setUpdatedObject(final T updatedObject) throws DatabaseTasksExecutorException;
  T getResult() throws DatabaseTasksExecutorException;
}
