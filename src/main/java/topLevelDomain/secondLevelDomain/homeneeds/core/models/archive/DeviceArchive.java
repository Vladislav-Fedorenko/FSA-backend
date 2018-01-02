package topLevelDomain.secondLevelDomain.homeneeds.core.models.archive;

import javax.persistence.*;
import java.sql.Timestamp;

import topLevelDomain.secondLevelDomain.homeneeds.utils.entities.IArchiveEntity;
import topLevelDomain.secondLevelDomain.homeneeds.utils.archive.ArchivedException;

@Entity
@Table(name = "archive_devices")
public class DeviceArchive implements IArchiveEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "devices_id")
  private Long deviceId;

  @Column(name = "name")
  private String name;

  @Column(name = "created_at")
  private Timestamp createdAt;

  @Column(name = "archiving_reason")
  private String archivingReason;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(Long deviceId) {
    this.deviceId = deviceId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
  }

  @Override
  public void setArchivingReason(final String archivingReason) throws ArchivedException {
    this.archivingReason = archivingReason;
  }

  @Override
  public String getArchivingReason() throws ArchivedException {
    return archivingReason;
  }
}
