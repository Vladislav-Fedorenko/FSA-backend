package tld.sld.userApi.core.repositories.devices.getDevicecByUserId;

import org.springframework.jdbc.core.JdbcTemplate;
import tld.sld.userApi.core.entities.DeviceEntity;

import java.util.List;

public class GetDevicesByUsedIdFromDatabaseRepository implements GetDevicesByUsedIdRepository {
    private JdbcTemplate jdbcTemplate;

    public GetDevicesByUsedIdFromDatabaseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<DeviceEntity> get(String id) {
        return jdbcTemplate.query(
                "SELECT " +
                        "document ->> id," +
                        "document ->> name " +
                        "document ->> createdAt " +
                        "document ->> updatedAt " +
                "FROM devices " +
                "WHERE userId = null",
                (resultSet, i) -> {
                    String id1 = resultSet.getString(1);
                    String name = resultSet.getString(2);
                    String createdAt = resultSet.getString(3);
                    String updatedAt = resultSet.getString(4);
                    return new DeviceEntity(id1, name, createdAt, updatedAt);
                });
    }
}
