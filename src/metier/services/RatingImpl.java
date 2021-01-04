package metier.services;

public class RatingImpl {

	private static RatingImpl instance = null;
	
	private RatingImpl() {
		
	}
	
	public static RatingImpl getInstance() {
	    if (instance == null)
	                   instance = new RatingImpl();
	    return instance;
	}
}
