package metier.dao.util;

import metier.dao.beans.User;
import metier.services.SignInService;

public class TestGetUser {

	public static void main(String[] args) {
		
		SignInService impl = SignInService.getInstance();
		
		User user = impl.VerifyUser("salma.al.jaouhari@gmail.com", "salma");
		
		if (user == null) {
			System.out.println("is not defined");
		} else {
			System.out.println(user.getFirstname());
		}

	}

}
