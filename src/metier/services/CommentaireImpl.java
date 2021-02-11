package metier.services;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import metier.dao.beans.Cabinet;
import metier.dao.beans.Commentaire;
import metier.dao.beans.Docteur;
import metier.dao.util.HibernateUtil;

public class CommentaireImpl {
	
	Session session = HibernateUtil.openSession();
	private static CommentaireImpl instance = null;
	
	private CommentaireImpl() {
		
	}
	
	public List<Commentaire> getComments(Long id, String par){
		String hql = "select c from Commentaire c where "+ par +" = :id";
		Query q = session.createQuery(hql);
		q.setParameter("id", id);
		List<Commentaire> list = q.getResultList();
		if (list.size() != 0) {
			return list;
		}else {
			return null;
		}
	}
	
	public static CommentaireImpl getInstance() {
	    if (instance == null)
	                   instance = new CommentaireImpl();
	    return instance;
	}
}
