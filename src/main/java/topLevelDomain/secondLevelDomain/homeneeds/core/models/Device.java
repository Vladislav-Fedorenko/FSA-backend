package topLevelDomain.secondLevelDomain.homeneeds.core.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import topLevelDomain.secondLevelDomain.homeneeds.utils.timestamp.extending.EntityTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "devices")
public class Device implements EntityTimestamp {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "created_at")
  private Timestamp createdAt;

  @Column(name = "updated_at")
  private Timestamp updatedAt;

  @OneToMany(mappedBy = "device", fetch = FetchType.LAZY)
  private Set<HomeDevice> homeDevices;

  @JsonCreator
  public Device(@JsonProperty("name") String name,
                @JsonProperty("createdAt") String createdAt,
                @JsonProperty("updatedAt") String updatedAt) {
    this.name = name;
//    this.createdAt = Timestamp.from(Instant.parse(createdAt));
    if(createdAt != null && updatedAt != null) {
      this.createdAt = new Timestamp(Long.valueOf(createdAt));
      this.updatedAt = new Timestamp(Long.valueOf(updatedAt));
    }
  }

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

  public Set<HomeDevice> getHomeDevices() {
    return homeDevices;
  }

  public void setHomeDevices(Set<HomeDevice> homeDevices) {
    this.homeDevices = homeDevices;
  }

  @Override
  public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }

  public Timestamp getCreatedAt() {
    return createdAt;
  }

  @Override
  public void setUpdatedAt(Timestamp updatedAt) { this.updatedAt = updatedAt; }

  public Timestamp getUpdatedAt() {
    return updatedAt;
  }
}
