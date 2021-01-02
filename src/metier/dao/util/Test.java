package metier.dao.util;

import metier.dao.beans.User;
import metier.dao.Implementations.UserImpl;

public class Test {
	
	public static void main(String[] args) {
		
		UserImpl user = new UserImpl();
		
		User usr = new User();
		
		usr.setAdresse("agadir");
		usr.setCin("jm63689");
		usr.setNom("el gourari");
		usr.setPrenom("youssef");
		
		user.add(usr);
					
	}

}
