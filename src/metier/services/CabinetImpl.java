package metier.services;

public class CabinetImpl {

	private static CabinetImpl instance = null;
	
	private CabinetImpl() {
		
	}
	
	public static CabinetImpl getInstance() {
	    if (instance == null)
	                   instance = new CabinetImpl();
	    return instance;
	}
}
