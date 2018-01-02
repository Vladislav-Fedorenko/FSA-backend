package topLevelDomain.secondLevelDomain.homeneeds.utils.archive;

public interface Archived {
  void setArchivingReason(final String archivingReason) throws ArchivedException;
  String getArchivingReason() throws ArchivedException;
}
