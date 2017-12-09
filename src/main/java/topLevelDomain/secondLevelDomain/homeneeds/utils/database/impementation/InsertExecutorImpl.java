package topLevelDomain.secondLevelDomain.homeneeds.utils.database.impementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import topLevelDomain.secondLevelDomain.homeneeds.utils.database.InsertExecutor;
import topLevelDomain.secondLevelDomain.homeneeds.utils.database.exeception.DatabaseTasksExecutorException;

public class InsertExecutorImpl<T> implements InsertExecutor<T> {
  @Autowired
  private SessionFactory sessionFactory;
  private T insertingObject;
  private T resultInserting;

  @Override
  public void execute() throws DatabaseTasksExecutorException {
    try {
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      session.save(insertingObject);
      session.getTransaction().commit();
      this.resultInserting = this.insertingObject;
    } catch (Exception e) {
      throw new DatabaseTasksExecutorException("", e);
    }
  }

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
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
