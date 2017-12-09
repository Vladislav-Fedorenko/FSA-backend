package topLevelDomain.secondLevelDomain.homeneeds.utils.database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import topLevelDomain.secondLevelDomain.homeneeds.utils.database.extending.*;
import topLevelDomain.secondLevelDomain.homeneeds.utils.database.impementation.InsertExecutorImpl;

public class DatabaseTasksExecutorFactory {
  private SelectByIdExecutor selectByIdExecutor;
  private SelectExecutor selectExecutor;
  private InsertExecutor insertExecutor;
  private UpdateExecutor updateExecutor;
  private DeleteExecutor deleteExecutor;

  private SessionFactory sessionFactory;

  public DatabaseTasksExecutorFactory() {
    sessionFactory = new Configuration().configure().buildSessionFactory();
  }

  public SelectByIdExecutor getSelectByIdExecutor() {
    return selectByIdExecutor;
  }

  public SelectExecutor getSelectExecutor() {
    return selectExecutor;
  }

  public InsertExecutor getInsertExecutor() {
    return new InsertExecutorImpl<>(sessionFactory);
  }

  public UpdateExecutor getUpdateExecutor() {
    return updateExecutor;
  }

  public DeleteExecutor getDeleteExecutor() {
    return deleteExecutor;
  }
}
