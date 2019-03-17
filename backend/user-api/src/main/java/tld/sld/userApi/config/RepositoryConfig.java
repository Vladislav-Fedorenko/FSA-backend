package tld.sld.userApi.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import tld.sld.userApi.core.repositories.devices.getDevicecByUserId.GetDevicesByUsedIdFromDatabaseRepository;
import tld.sld.userApi.core.repositories.devices.getDevicecByUserId.GetDevicesByUsedIdRepository;

@Configuration
public class RepositoryConfig {

    @Bean
    public GetDevicesByUsedIdRepository getDevicesByUsedIdRepository(JdbcTemplate jdbcTemplate, ObjectMapper objectMapper) {
        return new GetDevicesByUsedIdFromDatabaseRepository(jdbcTemplate, objectMapper);
    }
}
