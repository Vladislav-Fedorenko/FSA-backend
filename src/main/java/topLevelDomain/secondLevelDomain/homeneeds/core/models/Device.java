package topLevelDomain.secondLevelDomain.homeneeds.core.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "devices")
public class Device {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "created_at")
  private Timestamp createdAt;

  @Column(name = "updated_at")
  private Timestamp updatedAt;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "home_devices",
    joinColumns = @JoinColumn(name = "devices_id"),
    inverseJoinColumns = @JoinColumn(name = "home_info_id"))
  private Set<HomeInfo> homeInfoSet;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public Timestamp getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Set<HomeInfo> getHomeInfoSet() {
    return homeInfoSet;
  }

  public void setHomeInfoSet(Set<HomeInfo> homeInfoSet) {
    this.homeInfoSet = homeInfoSet;
  }
}
