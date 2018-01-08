package ru.fedoren.homeneeds.utils.database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ru.fedoren.homeneeds.utils.database.extending.DeleteExecutor;
import ru.fedoren.homeneeds.utils.database.extending.InsertExecutor;
import ru.fedoren.homeneeds.utils.database.extending.SelectByIdExecutor;
import ru.fedoren.homeneeds.utils.database.extending.SelectExecutor;
import ru.fedoren.homeneeds.utils.database.extending.UpdateExecutor;
import ru.fedoren.homeneeds.utils.database.impementation.DeleteWithArchivingExecutorImpl;
import ru.fedoren.homeneeds.utils.database.impementation.InsertExecutorImpl;
import ru.fedoren.homeneeds.utils.database.impementation.SelectByIdExecutorImpl;
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
    return new SelectByIdExecutorImpl<>(sessionFactory);
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
