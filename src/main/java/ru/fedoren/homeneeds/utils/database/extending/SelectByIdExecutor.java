package ru.fedoren.homeneeds.utils.database.extending;

import ru.fedoren.homeneeds.utils.database.DatabaseTasksExecutor;
import ru.fedoren.homeneeds.utils.database.exeception.DatabaseTasksExecutorException;

public interface SelectByIdExecutor<T> extends DatabaseTasksExecutor {

  void setId(final Long id)
      throws DatabaseTasksExecutorException;

  T getResult()
      throws DatabaseTasksExecutorException;
}
