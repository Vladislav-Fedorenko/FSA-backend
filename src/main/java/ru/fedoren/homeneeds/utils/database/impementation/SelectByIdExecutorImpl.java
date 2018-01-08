package ru.fedoren.homeneeds.utils.database.impementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ru.fedoren.homeneeds.utils.database.exeception.DatabaseTasksExecutorException;
import ru.fedoren.homeneeds.utils.database.extending.SelectByIdExecutor;

public class SelectByIdExecutorImpl<T> implements SelectByIdExecutor<T> {
  private SessionFactory sessionFactory;

  private Long idOfSelectedObject;
  private Class<T> classOfSelectedObject;
  private T resultSelecting;

  public SelectByIdExecutorImpl(final SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public void execute() throws DatabaseTasksExecutorException {
    Session session = sessionFactory.openSession();
    resultSelecting = session.get(classOfSelectedObject, idOfSelectedObject);
    session.close();
    if (resultSelecting == null) {
      throw new DatabaseTasksExecutorException(
        "Failed selecting. Object with id = " + idOfSelectedObject + " not found in database"
      );
    }
  }

  @Override
  public void setId(Long id) throws DatabaseTasksExecutorException {
    try {
      this.idOfSelectedObject = id;
    } catch (Exception exp) {
      throw new DatabaseTasksExecutorException(
        "Failed of setting selected object's id",
        exp
      );
    }
  }

  @Override
  public void setClassOfSelectedObject(Class<T> classOfSelectedObject)
      throws DatabaseTasksExecutorException {

    try {
      this.classOfSelectedObject = classOfSelectedObject;
    } catch (Exception exp) {
      throw new DatabaseTasksExecutorException(
        "Failed of setting selected object's class",
        exp
      );
    }
  }

  @Override
  public T getResult() throws DatabaseTasksExecutorException {
    try {
      return this.resultSelecting;
    } catch (Exception exp) {
      throw new DatabaseTasksExecutorException(
        "Failed of getting selecting's result",
        exp
      );
    }
  }
}
