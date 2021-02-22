package metier.services;

public class ProfilImpl {

	private static ProfilImpl instance = null;
	
	private ProfilImpl() {
		
	}
	
	public static ProfilImpl getInstance() {
	    if (instance == null)
	                   instance = new ProfilImpl();
	    return instance;
	}
}
