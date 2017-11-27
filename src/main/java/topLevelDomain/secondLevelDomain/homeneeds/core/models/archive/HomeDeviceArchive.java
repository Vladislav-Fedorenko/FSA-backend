package topLevelDomain.secondLevelDomain.homeneeds.core.models.archive;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "archive_home_devices")
public class HomeDeviceArchive {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "home_devices_id")
  private Long homeDeviceId;

  @Column(name = "devices_id")
  private Long deviceId;

  @Column(name = "home_info_id")
  private Long homeInfoId;

  @Column(name = "number")
  private String number;

  @Column(name = "verification_date")
  private Date verificationDate;

  @Column(name = "created_at")
  private Timestamp createdAt;

  @Column(name = "deleted_at")
  private Timestamp deletedAt;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getHomeDeviceId() {
    return homeDeviceId;
  }

  public void setHomeDeviceId(Long homeDeviceId) {
    this.homeDeviceId = homeDeviceId;
  }

  public Long getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(Long deviceId) {
    this.deviceId = deviceId;
  }

  public Long getHomeInfoId() {
    return homeInfoId;
  }

  public void setHomeInfoId(Long homeInfoId) {
    this.homeInfoId = homeInfoId;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Date getVerificationDate() {
    return verificationDate;
  }

  public void setVerificationDate(Date verificationDate) {
    this.verificationDate = verificationDate;
  }

  public Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
  }

  public Timestamp getDeletedAt() {
    return deletedAt;
  }

  public void setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
  }
}
