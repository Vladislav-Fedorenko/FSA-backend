package ru.fedoren.homeneeds.utils.database.extending;

import ru.fedoren.homeneeds.utils.database.DatabaseTasksExecutor;
import ru.fedoren.homeneeds.utils.database.exeception.DatabaseTasksExecutorException;

public interface DeleteExecutor<T, U> extends DatabaseTasksExecutor {

  void setId(final Long id) throws DatabaseTasksExecutorException;
  void setArchivedObject(final U archivedObject) throws DatabaseTasksExecutorException;
  void setClassOfDeletedObject(final Class<T> classOfDeletedObject) throws DatabaseTasksExecutorException;
  boolean getResult() throws DatabaseTasksExecutorException;
}
