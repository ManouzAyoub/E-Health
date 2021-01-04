package metier.dao.util;

import metier.dao.beans.Docteur;
import metier.dao.beans.User;
import metier.dao.Implementations.DocteurDao;
import metier.dao.Implementations.UserDao;

public class Test {
	
	public static void main(String[] args) {
		
		
		DocteurDao docteur = DocteurDao.getInstance();
		UserDao user = UserDao.getInstance();
		
		User u = new User();
		
		u.setAdresse("adresse");
		u.setCin("JM");
		u.setNom("Gourari");
		u.setPrenom("Youssef");
		
		user.add(u);
		
		
//		Docteur d = new Docteur();
//		
//		d.setCin("JC630898");
//		d.setAdresse("Agadir");
//		d.setNom("Zakaria");
//		d.setPrenom("Zakaria");
//		d.setName("Youssef");
//		d.setSpecialiter("Generale");
//		
//		Docteur result = docteur.getById("JM63689");
//		System.out.println(result);
//		docteur.add(d);
					
	}

}
