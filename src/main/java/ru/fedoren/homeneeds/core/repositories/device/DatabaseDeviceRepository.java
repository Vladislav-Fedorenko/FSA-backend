package ru.fedoren.homeneeds.core.repositories.device;

import java.util.List;

import ru.fedoren.homeneeds.core.models.Device;
import ru.fedoren.homeneeds.core.models.archive.DeviceArchive;
import ru.fedoren.homeneeds.utils.database.DatabaseTasksExecutorFactory;
import ru.fedoren.homeneeds.utils.database.exeception.DatabaseTasksExecutorException;
import ru.fedoren.homeneeds.utils.database.extending.DeleteExecutor;
import ru.fedoren.homeneeds.utils.database.extending.InsertExecutor;
import ru.fedoren.homeneeds.utils.database.extending.SelectByIdExecutor;
import ru.fedoren.homeneeds.utils.database.extending.UpdateExecutor;


public class DatabaseDeviceRepository implements DeviceRepository {
  private InsertExecutor<Device> insertExecutor;
  private SelectByIdExecutor<Device> selectByIdExecutor;
  private UpdateExecutor<Device, DeviceArchive> updateExecutor;
  private DeleteExecutor<Device, DeviceArchive> deleteExecutor;

  /**
   * .
   * @param factory of executors
   */
  @SuppressWarnings("unchecked")
  public DatabaseDeviceRepository(final DatabaseTasksExecutorFactory factory) {
    this.insertExecutor = factory.getInsertExecutor();
    this.selectByIdExecutor = factory.getSelectByIdExecutor();
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
    try {
      selectByIdExecutor.setId(deviceId);
      selectByIdExecutor.setClassOfSelectedObject(Device.class);
      selectByIdExecutor.execute();
      return selectByIdExecutor.getResult();
    } catch (DatabaseTasksExecutorException e) {
      e.printStackTrace();
    }
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
