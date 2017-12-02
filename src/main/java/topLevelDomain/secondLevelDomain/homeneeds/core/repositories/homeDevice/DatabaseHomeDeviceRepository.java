package topLevelDomain.secondLevelDomain.homeneeds.core.repositories.homeDevice;

import topLevelDomain.secondLevelDomain.homeneeds.core.models.HomeDevice;

import java.util.List;

public class DatabaseHomeDeviceRepository implements HomeDeviceRepository {

  @Override
  public HomeDevice addNewHomeDevice(HomeDevice homeDevice) {
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
