package metier.dao.Implementations;

import java.util.List;
import org.hibernate.Session;

import metier.dao.beans.Docteur;
import metier.dao.util.HibernateUtil;
import metier.dao.util.functionStd;

public class DocteurImpl implements functionStd<Docteur, Long> {
	
	Session session = HibernateUtil.openSession();
	
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
	public void delete(Long b) {
		session.beginTransaction();
		Docteur docteur = getById(b);
		session.delete(docteur);
		session.getTransaction().commit();
		
	}

	@Override
	public Docteur getById(Long id) {
		return session.get(Docteur.class, id);
	}

	@Override
	public List<Docteur> getAll() {
		return session.createQuery("select o from Docteur o").list();
	}
}
