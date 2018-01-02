package topLevelDomain.secondLevelDomain.homeneeds.utils.timestamp;

import java.sql.Timestamp;

public interface Updatable {
  void setUpdatedAt(Timestamp updatedAt) throws TimestampException;
  Timestamp getUpdatedAt() throws TimestampException;
}
