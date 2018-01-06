package topLevelDomain.secondLevelDomain.homeneeds.utils.database.impementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.sql.Timestamp;
import java.time.Instant;

import topLevelDomain.secondLevelDomain.homeneeds.utils.archive.ArchivedException;
import topLevelDomain.secondLevelDomain.homeneeds.utils.database.exeception.DatabaseTasksExecutorException;
import topLevelDomain.secondLevelDomain.homeneeds.utils.entities.IArchiveEntityException;
import topLevelDomain.secondLevelDomain.homeneeds.utils.timestamp.TimestampException;
import topLevelDomain.secondLevelDomain.homeneeds.utils.database.extending.UpdateExecutor;
import topLevelDomain.secondLevelDomain.homeneeds.utils.entities.IArchiveEntity;
import topLevelDomain.secondLevelDomain.homeneeds.utils.entities.IEntity;


public class UpdateWithArchivingExecutorImpl<T extends IEntity, U extends IArchiveEntity>
  implements UpdateExecutor<T, U> {

  private SessionFactory sessionFactory;
  private Session session;

  private T updatedObject;
  private U archivedObject;
  private Class<T> classOfUpdatedObject;
  private Long idOfUpdatedObject;
  private T resultOfUpdating;

  public UpdateWithArchivingExecutorImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public void execute() throws DatabaseTasksExecutorException {
    try {
      session = sessionFactory.openSession();
      session.beginTransaction();

      Timestamp timestamp = getTimestamp();
      prepareObjectToArchive(getUpdatedObjectFromDatabase(), timestamp);
      session.save(archivedObject);
      prepareObjectToUpdate(updatedObject, timestamp);
      session.merge(updatedObject);
      session.getTransaction().commit();
      session.evict(updatedObject);

      resultOfUpdating = getUpdatedObjectFromDatabase();
    } catch (IArchiveEntityException iArchiveEntityException) {
      throw new DatabaseTasksExecutorException(
        "Failed updating. Errors of setting values of fields from entity to archive_entity",
        iArchiveEntityException
      );
    } catch (ArchivedException archivedException) {
      throw new DatabaseTasksExecutorException(
        "Failed updating. Errors of setting timestamp of creating to archive_entity",
        archivedException
      );
    } catch (TimestampException timestampException) {
      throw new DatabaseTasksExecutorException(
        "Failed updating. Errors of setting reason of archiving to archive_entity",
        timestampException
      );
    } finally {
      session.close();
    }
  }

  private Timestamp getTimestamp() {
    return Timestamp.from(Instant.now());
  }

  private T getUpdatedObjectFromDatabase() {
    return session.get(classOfUpdatedObject, idOfUpdatedObject);
  }

  private void prepareObjectToArchive(final T objectFromDatabase, final Timestamp timestamp)
    throws IArchiveEntityException, TimestampException, ArchivedException, DatabaseTasksExecutorException {

    if(objectFromDatabase == null) {
      throw new DatabaseTasksExecutorException(
        "Failed updating. Object with id = " + idOfUpdatedObject + " not found in database"
      );
    }
    archivedObject.setValuesOfFieldsFromEntity(objectFromDatabase);
    archivedObject.setCreatedAt(timestamp);
    archivedObject.setArchivingReason("update");
  }

  private void prepareObjectToUpdate(final T updatedObject, final Timestamp timestamp) throws TimestampException {
    updatedObject.setUpdatedAt(timestamp);
  }

  @Override
  public void setId(final Long id) throws DatabaseTasksExecutorException {
    try {
      this.idOfUpdatedObject = id;
    } catch (Exception exp) {
      throw new DatabaseTasksExecutorException(
        "Failed of setting updated object's id",
        exp
      );
    }
  }

  @Override
  public void setUpdatedObject(final T updatedObject) throws DatabaseTasksExecutorException {
    try {
      this.updatedObject = updatedObject;
    } catch (Exception exp) {
      throw new DatabaseTasksExecutorException(
        "Failed of setting updated object",
        exp
      );
    }
  }

  @Override
  public void setArchivedObject(U archivedObject) throws DatabaseTasksExecutorException {
    try {
      this.archivedObject = archivedObject;
    } catch (Exception exp) {
      throw new DatabaseTasksExecutorException(
        "Failed of setting archived object",
        exp
      );
    }
  }

  @Override
  public void setClassOfUpdatedObject(Class<T> classOfUpdatedObject) throws DatabaseTasksExecutorException {
    try {
      this.classOfUpdatedObject = classOfUpdatedObject;
    } catch (Exception exp) {
      throw new DatabaseTasksExecutorException(
        "Failed of setting updated object's class",
        exp
      );
    }
  }

  @Override
  public T getResult() throws DatabaseTasksExecutorException {
    try {
      return resultOfUpdating;
    } catch (Exception exp) {
      throw new DatabaseTasksExecutorException(
        "Failed of getting updating's result",
        exp
      );
    }
  }
}
