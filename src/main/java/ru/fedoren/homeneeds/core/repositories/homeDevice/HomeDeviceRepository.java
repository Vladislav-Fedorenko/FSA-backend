package ru.fedoren.homeneeds.core.repositories.homeDevice;

import ru.fedoren.homeneeds.core.models.HomeDevice;

import java.util.List;

public interface HomeDeviceRepository {
  HomeDevice addNewHomeDevice(final HomeDevice homeDevice);

  boolean deleteHomeDevice(final Long homeDeviceId);

  HomeDevice updateHomeDevice(final HomeDevice newHomeDevice);

  HomeDevice getHomeDeviceById();

  List<HomeDevice> getHomeDevices();
}
