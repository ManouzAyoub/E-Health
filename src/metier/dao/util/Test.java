package metier.dao.util;

import metier.dao.beans.Docteur;
import metier.dao.Implementations.DocteurDao;
import metier.dao.Implementations.UserDao;

public class Test {
	
	public static void main(String[] args) {
		
		UserDao user = new UserDao();
		DocteurDao docteur = new DocteurDao();
		
		Docteur d = new Docteur();
		
		d.setCin("JA630898");
		d.setAdresse("Agadir");
		d.setNom("Zakaria");
		d.setPrenom("Zakaria");
		d.setName("Youssef");
		d.setSpecialiter("Generale");
		
		Docteur result = docteur.getById("JM63689");
		System.out.println(result);
		docteur.add(d);
					
	}

}
