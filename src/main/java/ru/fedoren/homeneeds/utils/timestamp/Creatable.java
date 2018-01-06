package ru.fedoren.homeneeds.utils.timestamp;

import java.sql.Timestamp;

public interface Creatable {
  void setCreatedAt(Timestamp createdAt) throws TimestampException;
  Timestamp getCreatedAt() throws TimestampException;
}
