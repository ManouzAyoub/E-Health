package metier.services;

import java.util.List;

import metier.dao.beans.Clinique;
import metier.dao.beans.Docteur;

public class CliniqueImpl {

	private static CliniqueImpl instance = null;
	
	private CliniqueImpl() {
		
	}
	
	public List<Clinique> getCliniquesByDoctor(Docteur docteur){
		String hql = "select c from Clinique c where idDocteur =: idDocteur";
		return null;
	}
	
	public static CliniqueImpl getInstance() {
	    if (instance == null)
	                   instance = new CliniqueImpl();
	    return instance;
	}
}
