package topLevelDomain.secondLevelDomain.homeneeds.core.repositories.device;

import topLevelDomain.secondLevelDomain.homeneeds.core.models.Device;

import java.util.List;

public interface DeviceRepository {
  Device addNewDevice(final Device newDevice);
  Device updateDevice(final Device newDevice);
  Device getDeviceById(final Long deviceId);
  List<Device> getDevices();
  boolean deleteDevice(final Long deviceId);

}
