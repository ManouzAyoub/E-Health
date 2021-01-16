package metier.services;

import java.util.List;

import org.hibernate.Session;

import metier.dao.beans.Cabinet;
import metier.dao.beans.Commentaire;
import metier.dao.util.HibernateUtil;

public class CommentaireImpl {
	
	Session session = HibernateUtil.openSession();
	private static CommentaireImpl instance = null;
	
	private CommentaireImpl() {
		
	}
	
	
	
	public List<Commentaire> getCommentsByCabinet(Cabinet id){
		return session.createQuery("select o.commentaire from Commentaire o where o.idCabinet = " + id.getIdProfil() ).list();
	}
	
	public static CommentaireImpl getInstance() {
	    if (instance == null)
	                   instance = new CommentaireImpl();
	    return instance;
	}
}
