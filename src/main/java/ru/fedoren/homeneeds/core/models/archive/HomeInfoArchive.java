package ru.fedoren.homeneeds.core.models.archive;

import javax.persistence.*;
import java.sql.Timestamp;

import ru.fedoren.homeneeds.utils.archive.ArchivedException;
import ru.fedoren.homeneeds.utils.entities.IArchiveEntity;
import ru.fedoren.homeneeds.utils.entities.IArchiveEntityException;
import ru.fedoren.homeneeds.utils.entities.IEntity;

@Entity
@Table(name = "archive_home_info")
public class HomeInfoArchive implements IArchiveEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "home_info_id")
  private Long homeInfoId;

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

  public Long getHomeInfoId() {
    return homeInfoId;
  }

  public void setHomeInfoId(Long homeInfoId) {
    this.homeInfoId = homeInfoId;
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

  @Override
  public void setValuesOfFieldsFromEntity(IEntity entity) throws IArchiveEntityException {

  }
}
