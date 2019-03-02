package tld.sld.userApi.core.entities;

public class DeviceEntity {
    private String id;
    private String name;
    private String createdAt;
    private String updatedAt;

    public DeviceEntity(String id, String name, String createdAt, String updatedAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}
