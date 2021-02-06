package metier.dao.util;

import java.util.ArrayList;
import java.util.List;

import metier.dao.Implementations.CliniqueDao;
import metier.dao.Implementations.DocteurDao;
import metier.dao.beans.Clinique;
import metier.dao.beans.Docteur;

public class TestAddClinique {
	
	public static void main(String[] args) {
		
		List<Clinique> list = new ArrayList<Clinique>();
		
		CliniqueDao cliniqueDao = CliniqueDao.getInsctance();
		DocteurDao docteurDao   = DocteurDao.getInstance();
		
		Clinique clinique = new Clinique();
		Docteur docteur   = new Docteur();
		
		clinique = cliniqueDao.getById(2L);
		
		list.add(clinique);
		
		docteur = docteurDao.getById(1L);
		
		docteur.setCliniques(list);
		
		docteurDao.edit(docteur);
		
	}
}
