package mahesh.gajula.mongo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import mahesh.gajula.mongo.sequence.SequenceDao;
import mahesh.gajula.mongo.sequence.SequenceDaoImpl;

public class MyApp {

	private MongoTemplate mongoTemplate;
	
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
		Student s = container.getBean("student",Student.class);
		System.out.println(s.getStudentId());
		SequenceDao seq = container.getBean("sequenceDao",SequenceDaoImpl.class);
		System.out.println(seq.getNextSequenceId("STU", "people_sequnce"));
		
		
		
	}

}
