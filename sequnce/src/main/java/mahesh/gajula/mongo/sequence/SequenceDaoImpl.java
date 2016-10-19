package mahesh.gajula.mongo.sequence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class SequenceDaoImpl implements SequenceDao{
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public long getNextSequenceId(String key,String collectionName){
		
		Query query= new Query(Criteria.where("_id").is(key));
		SeqId seqId= mongoTemplate.findAndModify(query, new Update().inc("seq", 1),FindAndModifyOptions.options().returnNew(true), SeqId.class,collectionName);
		try{
			if(seqId == null){
				throw new DataNotFoundException("Sequence data is not available for : "+key+" OR Sequence collection "+collectionName+" is not available in DB.");
			}	
		}catch(Exception e){
			e.printStackTrace();
		}

		return seqId.getSeq();

		
		
	}
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

}
