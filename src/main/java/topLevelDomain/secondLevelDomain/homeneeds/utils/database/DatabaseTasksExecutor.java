package topLevelDomain.secondLevelDomain.homeneeds.utils.database;

import topLevelDomain.secondLevelDomain.homeneeds.utils.database.execption.DatabaseTasksExecutorException;

public interface DatabaseTasksExecutor {
  void execute() throws DatabaseTasksExecutorException;
}
