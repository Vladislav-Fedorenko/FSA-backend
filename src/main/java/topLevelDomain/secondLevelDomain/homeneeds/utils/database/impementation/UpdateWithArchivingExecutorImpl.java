package topLevelDomain.secondLevelDomain.homeneeds.utils.database.impementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.sql.Timestamp;
import java.time.Instant;

import topLevelDomain.secondLevelDomain.homeneeds.utils.archive.ArchivedException;
import topLevelDomain.secondLevelDomain.homeneeds.utils.database.exeception.DatabaseTasksExecutorException;
import topLevelDomain.secondLevelDomain.homeneeds.utils.database.extending.UpdateExecutor;
import topLevelDomain.secondLevelDomain.homeneeds.utils.entities.IArchiveEntity;
import topLevelDomain.secondLevelDomain.homeneeds.utils.entities.IArchiveEntityException;
import topLevelDomain.secondLevelDomain.homeneeds.utils.entities.IEntity;
import topLevelDomain.secondLevelDomain.homeneeds.utils.timestamp.TimestampException;


public class UpdateWithArchivingExecutorImpl<T extends IEntity, U extends IArchiveEntity>
  implements UpdateExecutor<T, U> {

  private SessionFactory sessionFactory;
  private T updatedObject;
  private U archivedObject;
  private Class classOfUpdatedObject;
  private Long idOfUpdatedObject;
  private T resultOfUpdating;

  public UpdateWithArchivingExecutorImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public void execute() throws DatabaseTasksExecutorException {
    try {
      Timestamp timestamp = getTimestamp();
      archive(getUpdatedObjectFromDatabase(), timestamp);
      update(updatedObject, timestamp);
      resultOfUpdating = updatedObject;
    } catch (IArchiveEntityException e) {
      throw new DatabaseTasksExecutorException("i archive", e);
    } catch (ArchivedException e) {
      throw new DatabaseTasksExecutorException("archive", e);
    } catch (TimestampException e) {
      throw new DatabaseTasksExecutorException("timestamp", e);
    } catch (Exception e) {
      throw new DatabaseTasksExecutorException(" ", e);
    }
  }

  private Timestamp getTimestamp() {
    return Timestamp.from(Instant.now());
  }

  private T getUpdatedObjectFromDatabase() {
    Session session = sessionFactory.openSession();
    return (T) session.get(classOfUpdatedObject, idOfUpdatedObject);
  }

  private void archive(final T existingObject, final Timestamp timestamp)
    throws IArchiveEntityException, TimestampException, ArchivedException {

    archivedObject.setValuesOfFieldsFromEntity(existingObject);
    archivedObject.setCreatedAt(timestamp);
    // TODO: replace string "update" to ENUM
    archivedObject.setArchivingReason("update");
    writeObjectToDatabase(archivedObject);
  }

  private void update(final T updatedObject, final Timestamp timestamp) throws TimestampException {
    updatedObject.setUpdatedAt(timestamp);
    writeObjectToDatabase(updatedObject);
  }

//  TODO: change on two methods 1) save to archive collection 2) update in exist collection
  private void writeObjectToDatabase(final Object object) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.saveOrUpdate(object);
    session.getTransaction().commit();
  }

  @Override
  public void setId(Long id) throws DatabaseTasksExecutorException {
    try {
      this.idOfUpdatedObject = id;
    } catch (Exception e) {
      throw new DatabaseTasksExecutorException("", e);
    }
  }

  @Override
  public void setUpdatedObject(T updatedObject) throws DatabaseTasksExecutorException {
    try {
      this.updatedObject = updatedObject;
    } catch (Exception e) {
      throw new DatabaseTasksExecutorException("", e);
    }
  }

  @Override
  public void setArchivedObject(U archivedObject) throws DatabaseTasksExecutorException {
    try {
      this.archivedObject = archivedObject;
    } catch (Exception e) {
      throw new DatabaseTasksExecutorException("", e);
    }
  }

  @Override
  public void setClassOfUpdatedObject(Class classOfUpdatedObject) throws DatabaseTasksExecutorException {
    try {
      this.classOfUpdatedObject = classOfUpdatedObject;
    } catch (Exception e) {
      throw new DatabaseTasksExecutorException("", e);
    }
  }

  @Override
  public T getResult() throws DatabaseTasksExecutorException {
    try {
      return resultOfUpdating;
    } catch (Exception e) {
      throw new DatabaseTasksExecutorException("", e);
    }
  }
}
