package topLevelDomain.secondLevelDomain.homeneeds.utils.timestamp;

import java.sql.Timestamp;

public interface Updatable {
  void setUpdatedAt(Timestamp updatedAt);
  Timestamp getUpdatedAt();
}
