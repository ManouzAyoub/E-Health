package metier.services;

public class RoleImpl {
	
	private static RoleImpl instance = null;
	
	private RoleImpl() {
		
	}
	
	public static RoleImpl getInstance() {
	    if (instance == null)
	                   instance = new RoleImpl();
	    return instance;
	}
}
