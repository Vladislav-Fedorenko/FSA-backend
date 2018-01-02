package topLevelDomain.secondLevelDomain.homeneeds.core.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

import topLevelDomain.secondLevelDomain.homeneeds.utils.entities.IEntity;

@Entity
@Table(name = "devices_values")
public class DeviceValue implements IEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(cascade = {CascadeType.ALL})
  @JoinColumn(name = "home_devices_id")
  private HomeDevice homeDevice;

  @Column(name = "value")
  private Integer value;

  @Column(name = "date")
  private Date date;

  @Column(name = "created_at")
  private Timestamp createdAt;

  @Column(name = "updated_at")
  private Timestamp updatedAt;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public HomeDevice getHomeDevice() {
    return homeDevice;
  }

  public void setHomeDevice(HomeDevice homeDevice) {
    this.homeDevice = homeDevice;
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

  public Timestamp getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }
}
