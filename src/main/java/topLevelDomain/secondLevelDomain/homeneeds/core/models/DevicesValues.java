package topLevelDomain.secondLevelDomain.homeneeds.core.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "devices_values")
public class DevicesValues {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinTable(name = "home_devices",
    joinColumns = @JoinColumn(name = "home_devices_id"),
    inverseJoinColumns = @JoinColumn(name = "id"))
  private Long homeDevice;

  @Column(name = "value")
  private Integer value;

  @Column(name = "date")
  private Date date;

  @Column(name = "created_at")
  private Timestamp createdAt;

  @Column(name = "updated_at")
  private Timestamp updatedAt;

  @ManyToMany
  @JoinTable(name = "home_devices",
    joinColumns = @JoinColumn(name = "home_info_id"),
    inverseJoinColumns = @JoinColumn(name = "devices_id"))
  private Set<Device> deviceSet;
}
