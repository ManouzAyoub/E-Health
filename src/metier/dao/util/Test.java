package metier.dao.util;

import java.util.List;

import metier.dao.beans.Docteur;
import metier.dao.beans.Hopital;
import metier.dao.beans.User;

public class Test {

	public static void main(String[] args) {
		
		List<User> user = Instances.userDao.getAll();
		
		
		System.out.println(user);

	}

}
