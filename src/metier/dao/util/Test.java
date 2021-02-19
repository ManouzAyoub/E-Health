package metier.dao.util;

import metier.dao.beans.Docteur;

public class Test {

	public static void main(String[] args) {
		
		Docteur docteur = Instances.docteurDao.getById(1L);
		Long a = Instances.docteurImpl.getNumberOfVisiters(docteur);
		System.out.println("value is" + a);
		

	}

}
