package metier.services;

public class HopitalImpl {

	private static HopitalImpl instance = null;
	
	private HopitalImpl() {
		
	}
	
	public static HopitalImpl getInstance() {
	    if (instance == null)
	                   instance = new HopitalImpl();
	    return instance;
	}
}
