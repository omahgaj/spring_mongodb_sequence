package mahesh.gajula.mongo.sequence;



public interface SequenceDao {
	public long getNextSequenceId(String key,String collectionName);

}
