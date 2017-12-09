package topLevelDomain.secondLevelDomain.homeneeds.utils.database.extending;

import topLevelDomain.secondLevelDomain.homeneeds.utils.database.DatabaseTasksExecutor;
import topLevelDomain.secondLevelDomain.homeneeds.utils.database.exeception.DatabaseTasksExecutorException;

public interface DeleteExecutor extends DatabaseTasksExecutor {

  void setId(final Long id) throws DatabaseTasksExecutorException;
  boolean getResult() throws DatabaseTasksExecutorException;
}
