package tld.sld.userApi.core.models;

import tld.sld.userApi.core.entities.DeviceEntity;

public class DeviceModel {
    private String id;
    private String name;
    private String createdAt;
    private String updatedAt;

    public DeviceModel(DeviceEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.createdAt = entity.getCreatedAt();
        this.updatedAt = entity.getUpdatedAt();
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
