package metier.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import metier.dao.beans.Docteur;
import metier.dao.beans.Pharmacie;
import metier.dao.util.HibernateUtil;

public class PharmacieImpl  {

	private static PharmacieImpl instance = null;
	private Session session = HibernateUtil.openSession();
	
	private PharmacieImpl() {
		
	}
	
	public List<Pharmacie> getPharmaciesByYourAdress(String ville, Boolean bool){
		List<Pharmacie> list = new ArrayList<Pharmacie>();
		String hql = "select p from Pharmacie p where ville like ?1";
		Query q = session.createQuery(hql);
		//q.setParameter("bool", bool);
		q.setParameter(1, "%"+ ville + "%");
		list = q.getResultList();
		return list;
	}
	
	public static PharmacieImpl getInstance() {
	    if (instance == null)
	                   instance = new PharmacieImpl();
	    return instance;
	}
}
