package topLevelDomain.secondLevelDomain.homeneeds.utils.database.extending;

import topLevelDomain.secondLevelDomain.homeneeds.utils.database.DatabaseTasksExecutor;
import topLevelDomain.secondLevelDomain.homeneeds.utils.database.exeception.DatabaseTasksExecutorException;

public interface UpdateExecutor<T, U> extends DatabaseTasksExecutor {

  void setId(final Long id) throws DatabaseTasksExecutorException;
  void setUpdatedObject(final T updatedObject) throws DatabaseTasksExecutorException;
  void setArchivedObject(final U archivedObject) throws DatabaseTasksExecutorException;
  void setClassOfUpdatedObject(final Class<T> classOfUpdatedObject) throws DatabaseTasksExecutorException;
  T getResult() throws DatabaseTasksExecutorException;
}
