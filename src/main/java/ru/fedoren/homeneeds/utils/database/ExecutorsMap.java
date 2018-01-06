package ru.fedoren.homeneeds.utils.database;

import org.hibernate.SessionFactory;
import ru.fedoren.homeneeds.core.models.Device;
import ru.fedoren.homeneeds.utils.database.impementation.InsertExecutorImpl;
import ru.fedoren.homeneeds.utils.database.impementation.UpdateWithArchivingExecutorImpl;

import java.util.HashMap;
import java.util.Map;

public class ExecutorsMap {
  private Map<Class, DatabaseTasksExecutor> executorInsertMap = new HashMap<>();
  private Map<Class, DatabaseTasksExecutor> executorUpdateMap = new HashMap<>();

  public ExecutorsMap(final SessionFactory sessionFactory) {
    executorInsertMap.put(Device.class, new InsertExecutorImpl<Device>(sessionFactory));
    executorUpdateMap.put(Device.class, new UpdateWithArchivingExecutorImpl(sessionFactory));
  }
}
