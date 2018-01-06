package ru.fedoren.homeneeds.utils.database.extending;

import ru.fedoren.homeneeds.utils.database.DatabaseTasksExecutor;
import ru.fedoren.homeneeds.utils.database.exeception.DatabaseTasksExecutorException;

public interface UpdateExecutor<T, U> extends DatabaseTasksExecutor {

  void setId(final Long id) throws DatabaseTasksExecutorException;
  void setUpdatedObject(final T updatedObject) throws DatabaseTasksExecutorException;
  void setArchivedObject(final U archivedObject) throws DatabaseTasksExecutorException;
  void setClassOfUpdatedObject(final Class<T> classOfUpdatedObject) throws DatabaseTasksExecutorException;
  T getResult() throws DatabaseTasksExecutorException;
}
