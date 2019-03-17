package tld.sld.userApi.core.repositories.devices.getDevicecByUserId;

import tld.sld.userApi.core.entities.DeviceEntity;
import tld.sld.userApi.core.repositories.RepositoryException;

import java.util.List;

public interface GetDevicesByUsedIdRepository {
    List<DeviceEntity> get(String userId) throws RepositoryException;
}
