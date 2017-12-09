package topLevelDomain.secondLevelDomain.homeneeds.utils.database.impementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import topLevelDomain.secondLevelDomain.homeneeds.utils.database.extending.InsertExecutor;
import topLevelDomain.secondLevelDomain.homeneeds.utils.database.exeception.DatabaseTasksExecutorException;
import topLevelDomain.secondLevelDomain.homeneeds.utils.timestamp.extending.EntityTimestamp;

import java.sql.Timestamp;
import java.time.Instant;

public class InsertExecutorImpl<T extends EntityTimestamp> implements InsertExecutor<T> {
  private SessionFactory sessionFactory;
  private T insertingObject;
  private T resultInserting;

  public InsertExecutorImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public void execute() throws DatabaseTasksExecutorException {
    try {
      Timestamp timestamp = Timestamp.from(Instant.now());
      insertingObject.setCreatedAt(timestamp);
      insertingObject.setUpdatedAt(timestamp);

      Session session = sessionFactory.openSession();
      session.beginTransaction();
      session.save(insertingObject);
      session.getTransaction().commit();

      insertingObject.setCreatedAt(timestamp);
      insertingObject.setUpdatedAt(timestamp);
      this.resultInserting = this.insertingObject;
    } catch (Exception e) {
      throw new DatabaseTasksExecutorException("", e);
    }
  }

  @Override
  public void setInsertingObject(T insertingObject) throws DatabaseTasksExecutorException {
   try{
     this.insertingObject = insertingObject;
   } catch (Exception e) {
     throw new DatabaseTasksExecutorException("", e);
   }
  }

  @Override
  public T getResult() throws DatabaseTasksExecutorException {
    return this.resultInserting;
  }
}
