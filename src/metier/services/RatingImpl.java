package metier.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.hibernate.Session;

import metier.dao.beans.Docteur;
import metier.dao.util.HibernateUtil;

public class RatingImpl {

	private static RatingImpl instance = null;
	Session session = HibernateUtil.openSession();
	
	private RatingImpl() {
		
	}
	
	public static RatingImpl getInstance() {
	    if (instance == null)
	                   instance = new RatingImpl();
	    return instance;
	}
	
	public Long getNumberOfEtoileByDoctor( Docteur docteur ) {
		String hql = "select sum(o.numberEtoile) from Rating o where idDocteur = :idDocteur";
		Query q = session.createQuery(hql);
		q.setParameter("idDocteur", docteur.getCin());
		List<Long> list = q.getResultList();
		return list.get(0);
	}
	
	public Long getNumberOfRatingByDoctor( Docteur docteur ) {
		String hql = "select count(o.idRating) from Rating o where idDocteur = :idDocteur";
		Query q = session.createQuery(hql);
		q.setParameter("idDocteur", docteur.getCin());
		List<Long> list = q.getResultList();
		return list.get(0);
	}
	
	public int getAverageOfRatingByDoctor(Docteur docteur) {
		long numberofEtoile = getNumberOfEtoileByDoctor(docteur);
		long numberOfRating = getNumberOfRatingByDoctor(docteur);
		Double a = numberofEtoile + 0.0;
		Double b = numberOfRating + 0.0;
		int c = (int) Math.round(a/b);
		return c;
	}
	
	public Double average(Docteur docteur) {
		long numberofEtoile = getNumberOfEtoileByDoctor(docteur);
		long numberOfRating = getNumberOfRatingByDoctor(docteur);
		Double a = numberofEtoile + 0.0;
		Double b = numberOfRating + 0.0;
		return a/b;
	}
	
	public Map<Integer , Long> countDistinctValueOfRate(Docteur docteur){
		Map<Integer , Long > map = new HashMap<Integer , Long>();
		Long aide;
		for(int i=1 ; i<6 ; i++) {
			map.put(i, countRatingEtoiles(i, docteur));
		}
		return map;
	}
	
	public Long countRatingEtoiles(int number, Docteur docteur) {
		String hql = "select count(r.numberEtoile) from Rating r where idDocteur = :idDocteur and numberEtoile = :nbr";
		Query q = session.createQuery(hql);
		q.setParameter("idDocteur", docteur.getCin());
		q.setParameter("nbr", number);
		List<Long> list = q.getResultList();
		if (list.size() !=0) {
			return  list.get(0);
		}else {
			return Long.valueOf(0);
		}
		
	}
}
