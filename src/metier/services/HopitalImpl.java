package metier.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import metier.dao.beans.Docteur;
import metier.dao.beans.Hopital;
import metier.dao.util.HibernateUtil;

public class HopitalImpl {

	private static HopitalImpl instance = null;
	private Session session = HibernateUtil.openSession();
	
	private HopitalImpl() {
		
	}
	
	public List<Hopital> getAllHospitalsAccordingToTheirAvailabilityAndAdress(String adresse){
		List<Hopital> list = new ArrayList<Hopital>();
		String hql = "select h from Hopital h where adresse like ?1";
		Query q = session.createQuery(hql);
		q.setParameter(1, "%"+adresse + "%");
		list = q.getResultList();
		if (list.size() != 0) {
			return list;
		}else {
			return null;
		}
	}
	
	public static HopitalImpl getInstance() {
	    if (instance == null)
	                   instance = new HopitalImpl();
	    return instance;
	}
}
