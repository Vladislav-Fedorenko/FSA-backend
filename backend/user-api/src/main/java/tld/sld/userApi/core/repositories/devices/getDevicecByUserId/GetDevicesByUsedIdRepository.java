package tld.sld.userApi.core.repositories.devices.getDevicecByUserId;

import tld.sld.userApi.core.entities.DeviceEntity;

import java.util.List;

public interface GetDevicesByUsedIdRepository {
    List<DeviceEntity> get(String userId);
}
