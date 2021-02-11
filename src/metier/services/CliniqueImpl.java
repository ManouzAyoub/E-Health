package metier.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import metier.dao.beans.Clinique;
import metier.dao.beans.Docteur;
import metier.dao.beans.Hopital;
import metier.dao.util.HibernateUtil;

public class CliniqueImpl {

	private static CliniqueImpl instance = null;
	private Session session = HibernateUtil.openSession();
	private CliniqueImpl() {
		
	}
	
	public List<Clinique> getAllClinicsAccordingToTheirAvailabilityAndAdress(String adresse , Boolean bool){
		List<Clinique> list = new ArrayList<Clinique>();
		String hql = "select c from Clinique c where dispo = :bool and  adresse like ?1";
		Query q = session.createQuery(hql);
		q.setParameter("bool", bool);
		q.setParameter(1, "%"+adresse + "%");
		list = q.getResultList();
		if (list.size() != 0) {
			return list;
		}else {
			return null;
		}
		
	}
	
	public static CliniqueImpl getInstance() {
	    if (instance == null)
	                   instance = new CliniqueImpl();
	    return instance;
	}
}
