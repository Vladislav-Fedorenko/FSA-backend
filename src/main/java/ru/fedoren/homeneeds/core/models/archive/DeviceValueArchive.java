package ru.fedoren.homeneeds.core.models.archive;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

import ru.fedoren.homeneeds.utils.archive.ArchivedException;
import ru.fedoren.homeneeds.utils.entities.IArchiveEntity;
import ru.fedoren.homeneeds.utils.entities.IArchiveEntityException;
import ru.fedoren.homeneeds.utils.entities.IEntity;

@Entity
@Table(name = "archive_devices_values")
public class DeviceValueArchive implements IArchiveEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "devices_values_id")
  private Long deviceValueId;

  @Column(name = "value")
  private Integer value;

  @Column(name = "date")
  private Date date;

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

  public Long getDeviceValueId() {
    return deviceValueId;
  }

  public void setDeviceValueId(Long deviceValueId) {
    this.deviceValueId = deviceValueId;
  }

  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
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

  @Override
  public void setValuesOfFieldsFromEntity(IEntity entity) throws IArchiveEntityException {

  }
}
