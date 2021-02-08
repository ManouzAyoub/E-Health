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
	
	public List<Commentaire> getCommentsByDocteur(Docteur id){
		String hql = "select c from Commentaire c where idDocteur = :idDocteur";
		Query q = session.createQuery(hql);
		q.setParameter("idDocteur", id.getCin());
		List<Commentaire> list = q.getResultList();
		return list;
	}
	
	public static CommentaireImpl getInstance() {
	    if (instance == null)
	                   instance = new CommentaireImpl();
	    return instance;
	}
}
