package metier.dao.Implementations;

import java.util.List;
import org.hibernate.Session;
import metier.dao.beans.Clinique;
import metier.dao.util.HibernateUtil;
import metier.dao.util.functionStd;

public class CliniqueDao implements functionStd<Clinique, Long> {

	Session session = HibernateUtil.openSession();
	
	@Override
	public Clinique add(Clinique a) {
		session.beginTransaction();
		session.save(a);
		session.getTransaction().commit();
		return a;
	}

	@Override
	public Clinique edit(Clinique a) {
		session.beginTransaction();
		session.merge(a);
		session.getTransaction().commit();
		return a;
	}

	@Override
	public void delete(Long b) {
		session.beginTransaction();
		Clinique docteur = getById(b);
		session.delete(docteur);
		session.getTransaction().commit();
		
	}

	@Override
	public Clinique getById(Long id) {
		return session.get(Clinique.class, id);
	}

	@Override
	public List<Clinique> getAll() {
		return session.createQuery("select o from Clinique o").list();
	}

}