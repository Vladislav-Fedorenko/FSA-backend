package topLevelDomain.secondLevelDomain.homeneeds.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import topLevelDomain.secondLevelDomain.homeneeds.core.repositories.homeDevice.DatabaseHomeDeviceRepository;
import topLevelDomain.secondLevelDomain.homeneeds.core.repositories.homeDevice.HomeDeviceRepository;
import topLevelDomain.secondLevelDomain.homeneeds.utils.database.DatabaseTasksExecutorFactory;

@Configuration
public class RepositoriesConfig {
  private DatabaseTasksExecutorFactory factory = new DatabaseTasksExecutorFactory();

  @Bean
  public HomeDeviceRepository homeDeviceRepository() {
    return new DatabaseHomeDeviceRepository(factory);
  }
}
