package metier.dao.util;

import java.util.ArrayList;
import java.util.List;

import metier.dao.Implementations.CliniqueDao;
import metier.dao.Implementations.DocteurDao;
import metier.dao.beans.Clinique;
import metier.dao.beans.Docteur;

public class TestGestDocteurs {

	public static void main(String[] args) {
		
		CliniqueDao cliniqueDao = CliniqueDao.getInsctance();
		DocteurDao docteurDao   = DocteurDao.getInstance();
		
		Clinique clinique = new Clinique();
		Docteur docteur   = new Docteur();
		
		List<Docteur>  ld = new ArrayList<Docteur>();
		List<Clinique> lc = new ArrayList<Clinique>();
		
		docteur = docteurDao.getById(1L);
		
		lc = docteur.getCliniques();
		
		if (lc.size() != 0) {
			System.out.println(lc.get(0).getName());
		}

	}

}
