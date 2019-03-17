package tld.sld.userApi.core.repositories.devices.getDevicecByUserId;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import tld.sld.userApi.core.entities.DeviceEntity;

import java.io.IOException;
import java.util.List;

public class GetDevicesByUsedIdFromDatabaseRepository implements GetDevicesByUsedIdRepository {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private JdbcTemplate jdbcTemplate;
    private ObjectMapper objectMapper;

    public GetDevicesByUsedIdFromDatabaseRepository(JdbcTemplate jdbcTemplate, ObjectMapper objectMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.objectMapper = objectMapper;
    }

    public List<DeviceEntity> get(String id) throws RepositoryException {
        try {
            String query = "SELECT " +
                "document ->> 'id', " +
                "document ->> 'name', " +
                "document ->> 'createdAt', " +
                "document ->> 'updatedAt' " +
                "FROM devices " +
                "WHERE document ->> 'userId' = ?";
            logger.info("QUERY {}, PARAMS id={}", query, id);
            return jdbcTemplate.query(
                    query,
                    new Object[]{id},
                    (resultSet, i) -> {
                        DeviceEntity deviceEntity = null;
                        try {
                            deviceEntity = objectMapper.readValue(resultSet.getString("document"), DeviceEntity.class);
                        } catch (IOException e) {
                            logger.warn("Failed to get document. The exception = {}", e);
                        }
                        return deviceEntity;
                    }
            );
        } catch (Exception e) {
            throw new RepositoryException("Can't get all devices by userId=" + id, e);
        }
    }
}
