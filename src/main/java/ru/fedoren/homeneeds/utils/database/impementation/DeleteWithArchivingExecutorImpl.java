package ru.fedoren.homeneeds.utils.database.impementation;

import java.sql.Timestamp;
import java.time.Instant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ru.fedoren.homeneeds.utils.archive.ArchivedException;
import ru.fedoren.homeneeds.utils.database.exeception.DatabaseTasksExecutorException;
import ru.fedoren.homeneeds.utils.database.extending.DeleteExecutor;
import ru.fedoren.homeneeds.utils.entities.IArchiveEntity;
import ru.fedoren.homeneeds.utils.entities.IArchiveEntityException;
import ru.fedoren.homeneeds.utils.entities.IEntity;
import ru.fedoren.homeneeds.utils.timestamp.TimestampException;

public class DeleteWithArchivingExecutorImpl<T extends IEntity, U extends IArchiveEntity>
    implements DeleteExecutor<T, U> {

  private SessionFactory sessionFactory;
  private Session session;

  private U archivedObject;
  private Class<T> classOfDeletedObject;
  private Long idOfDeletedObject;
  private boolean resultOfDeleting;

  public DeleteWithArchivingExecutorImpl(final SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public void execute() throws DatabaseTasksExecutorException {
    try {
      session = sessionFactory.openSession();
      session.beginTransaction();

      Timestamp timestamp = getTimestamp();
      T deletedObject = getDeletedObjectFromDatabase();
      prepareObjectToArchive(deletedObject, timestamp);
      session.save(archivedObject);
      session.delete(deletedObject);
      session.getTransaction().commit();
      session.evict(deletedObject);

      resultOfDeleting = isDeleted();
    } catch (IArchiveEntityException exp) {
      throw new DatabaseTasksExecutorException(
        "Failed deleting. Errors of setting values of fields from entity to archive_entity",
        exp
      );
    } catch (TimestampException exp) {
      throw new DatabaseTasksExecutorException(
        "Failed deleting. Errors of setting timestamp of creating to archive_entity",
        exp
      );
    } catch (ArchivedException exp) {
      throw new DatabaseTasksExecutorException(
        "Failed deleting. Errors of setting reason of archiving to archive_entity",
        exp
      );
    } finally {
      session.close();
    }
  }

  private Timestamp getTimestamp() {
    return Timestamp.from(Instant.now());
  }

  private T getDeletedObjectFromDatabase() {
    return session.get(classOfDeletedObject, idOfDeletedObject);
  }

  private void prepareObjectToArchive(final T deletedObject, final Timestamp timestamp)
      throws IArchiveEntityException, TimestampException,
      ArchivedException, DatabaseTasksExecutorException {

    if (deletedObject == null) {
      throw new DatabaseTasksExecutorException(
        "Failed deleting. Object with id = " + idOfDeletedObject + " not found in database"
      );
    }
    archivedObject.setValuesOfFieldsFromEntity(deletedObject);
    archivedObject.setCreatedAt(timestamp);
    archivedObject.setArchivingReason("delete");
  }

  private boolean isDeleted() {
    return getDeletedObjectFromDatabase() == null;
  }

  @Override
  public void setId(final Long id) throws DatabaseTasksExecutorException {
    try {
      this.idOfDeletedObject = id;
    } catch (Exception exp) {
      throw new DatabaseTasksExecutorException(
        "Failed of setting deleted object's id",
        exp
      );
    }
  }

  @Override
  public void setArchivedObject(final U archivedObject)
      throws DatabaseTasksExecutorException {

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
  public void setClassOfDeletedObject(final Class<T> classOfDeletedObject)
      throws DatabaseTasksExecutorException {

    try {
      this.classOfDeletedObject = classOfDeletedObject;
    } catch (Exception exp) {
      throw new DatabaseTasksExecutorException(
        "Failed of setting deleted object's class",
        exp
      );
    }
  }

  @Override
  public boolean getResult() throws DatabaseTasksExecutorException {
    try {
      return resultOfDeleting;
    } catch (Exception exp) {
      throw new DatabaseTasksExecutorException(
        "Failed of getting deleting's result",
        exp
      );
    }
  }
}
