package ru.fedoren.homeneeds.utils.database.extending;

import ru.fedoren.homeneeds.utils.database.DatabaseTasksExecutor;
import ru.fedoren.homeneeds.utils.database.exeception.DatabaseTasksExecutorException;

public interface InsertExecutor<T> extends DatabaseTasksExecutor {

  void setInsertedObject(final T insertedObject) throws DatabaseTasksExecutorException;

  T getResult() throws DatabaseTasksExecutorException;
}
