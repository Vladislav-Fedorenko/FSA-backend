package ru.fedoren.homeneeds.core.repositories.device;

import ru.fedoren.homeneeds.core.models.Device;
import ru.fedoren.homeneeds.core.models.archive.DeviceArchive;
import ru.fedoren.homeneeds.utils.database.DatabaseTasksExecutorFactory;
import ru.fedoren.homeneeds.utils.database.exeception.DatabaseTasksExecutorException;
import ru.fedoren.homeneeds.utils.database.extending.DeleteExecutor;
import ru.fedoren.homeneeds.utils.database.extending.InsertExecutor;
import ru.fedoren.homeneeds.utils.database.extending.UpdateExecutor;

import java.util.List;

public class DatabaseDeviceRepository implements DeviceRepository {
  private InsertExecutor<Device> insertExecutor;
  private UpdateExecutor<Device, DeviceArchive> updateExecutor;
  private DeleteExecutor<Device, DeviceArchive> deleteExecutor;

  @SuppressWarnings("unchecked")
  public DatabaseDeviceRepository(final DatabaseTasksExecutorFactory factory) {
    this.insertExecutor = factory.getInsertExecutor();
    this.updateExecutor = factory.getUpdateExecutor();
    this.deleteExecutor = factory.getDeleteExecutor();
  }

  @Override
  public Device addNewDevice(Device newDevice) {
    try {
      insertExecutor.setInsertedObject(newDevice);
      insertExecutor.execute();
      return insertExecutor.getResult();
    } catch (DatabaseTasksExecutorException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public Device updateDevice(Device newDevice) {
    try {
      updateExecutor.setId(newDevice.getId());
      updateExecutor.setClassOfUpdatedObject(Device.class);
      updateExecutor.setUpdatedObject(newDevice);
      updateExecutor.setArchivedObject(new DeviceArchive());
      updateExecutor.execute();
      return updateExecutor.getResult();
    } catch (DatabaseTasksExecutorException e) {
      e.printStackTrace();
    }
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
    try {
      deleteExecutor.setId(deviceId);
      deleteExecutor.setClassOfDeletedObject(Device.class);
      deleteExecutor.setArchivedObject(new DeviceArchive());
      deleteExecutor.execute();
      return deleteExecutor.getResult();
    } catch (DatabaseTasksExecutorException e) {
      e.printStackTrace();
    }
    return false;
  }
}
