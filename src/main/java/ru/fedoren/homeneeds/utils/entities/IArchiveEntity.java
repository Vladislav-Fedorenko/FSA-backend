package ru.fedoren.homeneeds.utils.entities;

import ru.fedoren.homeneeds.utils.archive.Archived;
import ru.fedoren.homeneeds.utils.timestamp.Creatable;

public interface IArchiveEntity extends Creatable, Archived {
  void setValuesOfFieldsFromEntity(final IEntity entity)
      throws IArchiveEntityException;
}
