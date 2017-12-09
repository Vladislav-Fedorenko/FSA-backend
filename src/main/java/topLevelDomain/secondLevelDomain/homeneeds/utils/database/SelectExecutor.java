package topLevelDomain.secondLevelDomain.homeneeds.utils.database;

import org.hibernate.Criteria;
import topLevelDomain.secondLevelDomain.homeneeds.utils.database.exeception.DatabaseTasksExecutorException;

import java.util.List;

public interface SelectExecutor<T> extends DatabaseTasksExecutor {

  void setCriteria(final Criteria criteria) throws DatabaseTasksExecutorException;
  List<T> getResult() throws DatabaseTasksExecutorException;
}
