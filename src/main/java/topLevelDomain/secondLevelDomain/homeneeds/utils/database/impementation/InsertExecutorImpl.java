package topLevelDomain.secondLevelDomain.homeneeds.utils.database.impementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.sql.Timestamp;
import java.time.Instant;

import topLevelDomain.secondLevelDomain.homeneeds.utils.database.extending.InsertExecutor;
import topLevelDomain.secondLevelDomain.homeneeds.utils.database.exeception.DatabaseTasksExecutorException;
import topLevelDomain.secondLevelDomain.homeneeds.utils.entities.IEntity;
import topLevelDomain.secondLevelDomain.homeneeds.utils.timestamp.TimestampException;

public class InsertExecutorImpl<T extends IEntity> implements InsertExecutor<T> {
  private SessionFactory sessionFactory;
  private T insertedObject;
  private T resultInserting;

  public InsertExecutorImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public void execute() throws DatabaseTasksExecutorException {
    try {
      Timestamp timestamp = getTimestamp();
      insert(insertedObject, timestamp);
      resultInserting = insertedObject;
    } catch (TimestampException e) {
      throw new DatabaseTasksExecutorException("timestamp", e);
    } catch (Exception e) {
      throw new DatabaseTasksExecutorException("", e);
    }
  }

  private Timestamp getTimestamp() {
    return Timestamp.from(Instant.now());
  }

  private void insert(final T insertedObject, final Timestamp timestamp) throws TimestampException {
    insertedObject.setCreatedAt(timestamp);
    insertedObject.setUpdatedAt(timestamp);
    writeObjectToDatabase(insertedObject);
  }

  private void writeObjectToDatabase(final Object object) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.save(object);
    session.getTransaction().commit();
  }

  @Override
  public void setInsertedObject(T insertedObject) throws DatabaseTasksExecutorException {
   try {
     this.insertedObject = insertedObject;
   } catch (Exception e) {
     throw new DatabaseTasksExecutorException("", e);
   }
  }

  @Override
  public T getResult() throws DatabaseTasksExecutorException {
    try {
      return this.resultInserting;
    } catch (Exception e) {
      throw new DatabaseTasksExecutorException("", e);
    }
  }
}
