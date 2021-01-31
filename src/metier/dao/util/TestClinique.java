package metier.dao.util;

import java.util.HashSet;
import java.util.Set;

import metier.dao.Implementations.CliniqueDao;
import metier.dao.Implementations.DocteurDao;
import metier.dao.beans.Clinique;
import metier.dao.beans.Docteur;

public class TestClinique {

	public static void main(String[] args) {
		
		Set<Docteur> setDocteur = new HashSet<Docteur>();
		
		CliniqueDao cliniqueDao = CliniqueDao.getInsctance();
		DocteurDao docteurDao   = DocteurDao.getInstance();
		
		Clinique clinique = new Clinique();
		Docteur docteur   = new Docteur();
		
		clinique.setEmail("clinique@clinique.com");
		clinique.setFirstname("clinique");
		clinique.setLastname("clinique");
		clinique.setPassword("clinique");
		
		docteur.setEmail("docteur@docteur.com");
		docteur.setFirstname("docteur");
		docteur.setLastname("docteur");
		docteur.setPassword("docteur");
		
		setDocteur.add(docteur);
		
		clinique.setWorks(setDocteur);
		
		docteurDao.add(docteur);
		cliniqueDao.add(clinique);
		
		

	}

}
