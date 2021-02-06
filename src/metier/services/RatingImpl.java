package metier.services;

import java.util.List;

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
		System.out.println("a ===> " + a);
		System.out.println("b ===> " + b);
		int c = (int) Math.round(a/b);
		return c;
	}
	
	public List<Long> countDistinctValueOfRate(Docteur docteur){
		String hql = "select count(distinct r.numberEtoile) from Rating r where idDocteur = :idDocteur";
		Query q = session.createQuery(hql);
		q.setParameter("idDocteur", docteur.getCin());
		List<Long> list = q.getResultList();
		return list;
	}
}
