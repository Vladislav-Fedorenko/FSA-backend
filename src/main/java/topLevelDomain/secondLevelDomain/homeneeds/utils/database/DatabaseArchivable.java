package topLevelDomain.secondLevelDomain.homeneeds.utils.database;

import topLevelDomain.secondLevelDomain.homeneeds.utils.database.execption.DatabaseTasksExecutorException;

public interface DatabaseArchivable {
  void archive() throws DatabaseTasksExecutorException;
}
