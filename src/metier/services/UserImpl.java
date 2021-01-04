package metier.services;

public class UserImpl {
	
	private static UserImpl instance = null;
	
	private UserImpl() {
		
	}
	
	public static UserImpl getInstance() {
	    if (instance == null)
	                   instance = new UserImpl();
	    return instance;
	}
}
