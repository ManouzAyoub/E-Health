package metier.services;

public class LaboratoireImpl {

	private static LaboratoireImpl instance = null;
	
	private LaboratoireImpl() {
		
	}
	
	public static LaboratoireImpl getInstance() {
	    if (instance == null)
	                   instance = new LaboratoireImpl();
	    return instance;
	}
}
