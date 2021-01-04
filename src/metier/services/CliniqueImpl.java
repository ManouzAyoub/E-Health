package metier.services;

public class CliniqueImpl {

	private static CliniqueImpl instance = null;
	
	private CliniqueImpl() {
		
	}
	
	public static CliniqueImpl getInstance() {
	    if (instance == null)
	                   instance = new CliniqueImpl();
	    return instance;
	}
}
