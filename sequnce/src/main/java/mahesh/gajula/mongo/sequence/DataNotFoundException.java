package mahesh.gajula.mongo.sequence;

public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DataNotFoundException(String errorMessage){
		super(errorMessage);
	}

}
