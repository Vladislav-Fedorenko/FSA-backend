package ru.fedoren.homeneeds.utils.database.extending;

import org.hibernate.Criteria;
import ru.fedoren.homeneeds.utils.database.DatabaseTasksExecutor;
import ru.fedoren.homeneeds.utils.database.exeception.DatabaseTasksExecutorException;

import java.util.List;

public interface SelectExecutor<T> extends DatabaseTasksExecutor {

  void setCriteria(final Criteria criteria) throws DatabaseTasksExecutorException;
  List<T> getResult() throws DatabaseTasksExecutorException;
}
