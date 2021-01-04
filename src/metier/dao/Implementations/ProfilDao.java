package metier.dao.Implementations;

import java.util.List;

import org.hibernate.Session;

import metier.dao.beans.Pharmacie;
import metier.dao.beans.Profil;
import metier.dao.util.HibernateUtil;
import metier.dao.util.functionStd;

public class ProfilDao implements functionStd<Profil, Long>{

	Session session = HibernateUtil.openSession();
	private static ProfilDao instance = null;
	
	private ProfilDao() {
		
	}
	
	@Override
	public Profil add(Profil a) {
		session.beginTransaction();
		session.save(a);
		session.getTransaction().commit();
		return a;
	}

	@Override
	public Profil edit(Profil a) {
		session.beginTransaction();
		session.merge(a);
		session.getTransaction().commit();
		return a;
	}

	@Override
	public void delete(Long b) {
		session.beginTransaction();
		Profil profil = getById(b);
		session.delete(profil);
		session.getTransaction().commit();
		
	}

	@Override
	public Profil getById(Long id) {
		return session.get(Profil.class, id);
	}

	@Override
	public List<Profil> getAll() {
		return session.createQuery("select o from Profil o").list();
	}
	
	public static ProfilDao getInstance() {
	    if (instance == null)
               instance = new ProfilDao();
	    return instance;
	}

}
