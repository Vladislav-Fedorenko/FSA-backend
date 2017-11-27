package topLevelDomain.secondLevelDomain.homeneeds.core.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "home_devices")
public class HomeDevice {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @OneToMany(mappedBy = "homeDevice", fetch = FetchType.LAZY)
  private Long id;

  @ManyToOne(cascade = {CascadeType.ALL})
  @JoinColumn(name = "devices_id")
  private Device device;

  @ManyToOne(cascade = {CascadeType.ALL})
  @JoinColumn(name = "home_info_id")
  private HomeInfo homeInfo;

  @Column(name = "number")
  private String number;

  @Column(name = "verification_date")
  private Date verificationDate;

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

  public Device getDevice() {
    return device;
  }

  public void setDevice(Device device) {
    this.device = device;
  }

  public HomeInfo getHomeInfo() {
    return homeInfo;
  }

  public void setHomeInfo(HomeInfo homeInfo) {
    this.homeInfo = homeInfo;
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

  public Timestamp getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }
}
