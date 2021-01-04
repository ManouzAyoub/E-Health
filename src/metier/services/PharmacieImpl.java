package metier.services;

public class PharmacieImpl  {

	private static PharmacieImpl instance = null;
	
	private PharmacieImpl() {
		
	}
	
	public static PharmacieImpl getInstance() {
	    if (instance == null)
	                   instance = new PharmacieImpl();
	    return instance;
	}
}
