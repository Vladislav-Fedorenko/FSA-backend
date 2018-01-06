package ru.fedoren.homeneeds.core.repositories.homeDevice;

import ru.fedoren.homeneeds.core.models.HomeDevice;
import ru.fedoren.homeneeds.utils.database.DatabaseTasksExecutorFactory;
import ru.fedoren.homeneeds.utils.database.extending.InsertExecutor;
import ru.fedoren.homeneeds.utils.database.exeception.DatabaseTasksExecutorException;

import java.util.List;

public class DatabaseHomeDeviceRepository implements HomeDeviceRepository {
  private InsertExecutor<HomeDevice> insertExecutor;

  @SuppressWarnings("unchecked")
  public DatabaseHomeDeviceRepository(DatabaseTasksExecutorFactory factory) {
    insertExecutor = factory.getInsertExecutor();
  }

  @Override
  public HomeDevice addNewHomeDevice(HomeDevice homeDevice) {
    try {
      insertExecutor.setInsertedObject(homeDevice);
      insertExecutor.execute();
      return insertExecutor.getResult();
    } catch (DatabaseTasksExecutorException e) {
      System.out.println(e.getMessage());
    }
    return null;
  }

  @Override
  public boolean deleteHomeDevice(Long homeDeviceId) {
    return false;
  }

  @Override
  public HomeDevice updateHomeDevice(HomeDevice newHomeDevice) {
    return null;
  }

  @Override
  public HomeDevice getHomeDeviceById() {
    return null;
  }

  @Override
  public List<HomeDevice> getHomeDevices() {
    return null;
  }
}
