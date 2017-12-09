package topLevelDomain.secondLevelDomain.homeneeds.utils.database;

import topLevelDomain.secondLevelDomain.homeneeds.utils.database.exeception.DatabaseTasksExecutorException;

public interface DatabaseArchivable {
  void archive() throws DatabaseTasksExecutorException;
}
