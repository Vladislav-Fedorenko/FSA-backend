package topLevelDomain.secondLevelDomain.homeneeds.utils.database;

import topLevelDomain.secondLevelDomain.homeneeds.utils.database.impementation.InsertExecutorImpl;

public class DatabaseTasksExecutorFactory {
  private SelectByIdExecutor selectByIdExecutor;
  private SelectExecutor selectExecutor;
  private InsertExecutor insertExecutor;
  private UpdateExecutor updateExecutor;
  private DeleteExecutor deleteExecutor;

  public SelectByIdExecutor getSelectByIdExecutor() {
    return selectByIdExecutor;
  }

  public SelectExecutor getSelectExecutor() {
    return selectExecutor;
  }

  public InsertExecutor getInsertExecutor() {
    return new InsertExecutorImpl<>();
  }

  public UpdateExecutor getUpdateExecutor() {
    return updateExecutor;
  }

  public DeleteExecutor getDeleteExecutor() {
    return deleteExecutor;
  }
}
