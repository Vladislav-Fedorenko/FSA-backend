package ru.fedoren.homeneeds.core.models;

import ru.fedoren.homeneeds.utils.entities.IEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "home_info")
public class HomeInfo implements IEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "created_at")
  private Timestamp createdAt;

  @Column(name = "updated_at")
  private Timestamp updatedAt;

  @OneToMany(mappedBy = "homeInfo", fetch = FetchType.LAZY)
  private Set<HomeDevice> homeDevices;

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

  public Set<HomeDevice> getHomeDevices() {
    return homeDevices;
  }

  public void setHomeDevices(Set<HomeDevice> homeDevices) {
    this.homeDevices = homeDevices;
  }
}
