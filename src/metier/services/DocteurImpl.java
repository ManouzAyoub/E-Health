package metier.services;

public class DocteurImpl {
	
	private static DocteurImpl instance = null;
	
	private DocteurImpl() {
		
	}
	
	public static DocteurImpl getInstance() {
	    if (instance == null)
	                   instance = new DocteurImpl();
	    return instance;
	}
}
