package topLevelDomain.secondLevelDomain.homeneeds.core.repositories.device;

import topLevelDomain.secondLevelDomain.homeneeds.core.models.Device;
import topLevelDomain.secondLevelDomain.homeneeds.utils.database.DatabaseTasksExecutorFactory;
import topLevelDomain.secondLevelDomain.homeneeds.utils.database.exeception.DatabaseTasksExecutorException;
import topLevelDomain.secondLevelDomain.homeneeds.utils.database.extending.InsertExecutor;

import java.util.List;

public class DatabaseDeviceRepository implements DeviceRepository {
  private InsertExecutor<Device> insertExecutor;

  @SuppressWarnings("unchecked")
  public DatabaseDeviceRepository(final DatabaseTasksExecutorFactory factory) {
    this.insertExecutor = factory.getInsertExecutor();
  }

  @Override
  public Device addNewDevice(Device newDevice) {
    try {
      insertExecutor.setInsertingObject(newDevice);
      insertExecutor.execute();
      return insertExecutor.getResult();
    } catch (DatabaseTasksExecutorException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public Device updateDevice(Device newDevice) {
    return null;
  }

  @Override
  public Device getDeviceById(Long deviceId) {
    return null;
  }

  @Override
  public List<Device> getDevices() {
    return null;
  }

  @Override
  public boolean deleteDevice(Long deviceId) {
    return false;
  }
}
