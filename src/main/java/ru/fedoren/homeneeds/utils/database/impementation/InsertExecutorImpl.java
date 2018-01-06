package ru.fedoren.homeneeds.utils.database.impementation;

import java.sql.Timestamp;
import java.time.Instant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ru.fedoren.homeneeds.utils.database.exeception.DatabaseTasksExecutorException;
import ru.fedoren.homeneeds.utils.database.extending.InsertExecutor;
import ru.fedoren.homeneeds.utils.entities.IEntity;
import ru.fedoren.homeneeds.utils.timestamp.TimestampException;

public class InsertExecutorImpl<T extends IEntity> implements InsertExecutor<T> {

  private SessionFactory sessionFactory;
  private Session session;

  private T insertedObject;
  private T resultInserting;

  public InsertExecutorImpl(final SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public void execute() throws DatabaseTasksExecutorException {
    try {
      session = sessionFactory.openSession();
      session.beginTransaction();

      Timestamp timestamp = getTimestamp();
      prepareObjectToInsert(insertedObject, timestamp);
      session.save(insertedObject);
      session.getTransaction().commit();

      resultInserting = insertedObject;
    } catch (TimestampException exp) {
      throw new DatabaseTasksExecutorException(
        "Failed inserting. Errors of setting timestamp of creating/updating to archive_entity",
        exp
      );
    } finally {
      session.close();
    }
  }

  private Timestamp getTimestamp() {
    return Timestamp.from(Instant.now());
  }

  private void prepareObjectToInsert(final T insertedObject, final Timestamp timestamp)
      throws TimestampException {
    insertedObject.setCreatedAt(timestamp);
    insertedObject.setUpdatedAt(timestamp);
  }

  @Override
  public void setInsertedObject(final T insertedObject) throws DatabaseTasksExecutorException {
    try {
      this.insertedObject = insertedObject;
    } catch (Exception exp) {
      throw new DatabaseTasksExecutorException(
        "Failed of setting inserted object",
        exp
      );
    }
  }

  @Override
  public T getResult() throws DatabaseTasksExecutorException {
    try {
      return this.resultInserting;
    } catch (Exception exp) {
      throw new DatabaseTasksExecutorException(
        "Failed of getting inserting's result",
        exp
      );
    }
  }
}
