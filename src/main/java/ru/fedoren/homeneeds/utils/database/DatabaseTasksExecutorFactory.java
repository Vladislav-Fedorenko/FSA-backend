package ru.fedoren.homeneeds.utils.database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.fedoren.homeneeds.utils.database.extending.*;
import ru.fedoren.homeneeds.utils.database.impementation.DeleteWithArchivingExecutorImpl;
import ru.fedoren.homeneeds.utils.database.impementation.InsertExecutorImpl;
import ru.fedoren.homeneeds.utils.database.impementation.UpdateWithArchivingExecutorImpl;

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
    return new UpdateWithArchivingExecutorImpl(sessionFactory);
  }

  public DeleteExecutor getDeleteExecutor() {
    return new DeleteWithArchivingExecutorImpl(sessionFactory);
  }
}
