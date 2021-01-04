package metier.dao.Implementations;

import java.util.List;
import org.hibernate.Session;

import metier.dao.beans.Docteur;
import metier.dao.util.HibernateUtil;
import metier.dao.util.functionStd;

public class DocteurDao implements functionStd<Docteur, String> {
	
	Session session = HibernateUtil.openSession();
	private static DocteurDao instance = null;
	
	private DocteurDao() {
		
	}
	
	@Override
	public Docteur add(Docteur a) {
		session.beginTransaction();
		session.save(a);
		session.getTransaction().commit();
		return a;
	}

	@Override
	public Docteur edit(Docteur a) {
		session.beginTransaction();
		session.merge(a);
		session.getTransaction().commit();
		return a;
	}

	@Override
	public void delete(String b) {
		session.beginTransaction();
		Docteur docteur = getById(b);
		session.delete(docteur);
		session.getTransaction().commit();
		
	}

	@Override
	public Docteur getById(String id) {
		return session.get(Docteur.class, id);
	}

	@Override
	public List<Docteur> getAll() {
		return session.createQuery("select o from Docteur o").list();
	}
	
	public static DocteurDao getInstance() {
	    if (instance == null)
	                   instance = new DocteurDao();
	    return instance;
	}
}
