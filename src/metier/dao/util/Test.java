package metier.dao.util;

import metier.dao.beans.Docteur;
import metier.dao.beans.Hopital;
import metier.dao.beans.User;

public class Test {

	public static void main(String[] args) {
		
		User user = Instances.userDao.getById(5L);
		Hopital hopital = Instances.hopitalDao.getById(6L);
		
		
		int a = Instances.ratingImpl.getNumberOfEtoileByUserAndHopital(user, hopital);
		System.out.println(a);

	}

}
