package metier.dao.Implementations;

import java.util.List;

import org.hibernate.Session;
import metier.dao.beans.Laboratoire;
import metier.dao.util.HibernateUtil;
import metier.dao.util.functionStd;

public class LaboratoireDao implements functionStd<Laboratoire, Long>{

	Session session = HibernateUtil.openSession();
	private static LaboratoireDao instance = null;
	
	private LaboratoireDao() {
		
	}
	
	@Override
	public Laboratoire add(Laboratoire a) {
		session.beginTransaction();
		session.save(a);
		session.getTransaction().commit();
		return a;
	}

	@Override
	public Laboratoire edit(Laboratoire a) {
		session.beginTransaction();
		session.merge(a);
		session.getTransaction().commit();
		return a;
	}

	@Override
	public void delete(Long b) {
		session.beginTransaction();
		Laboratoire laboratoire = getById(b);
		session.delete(laboratoire);
		session.getTransaction().commit();
		
	}

	@Override
	public Laboratoire getById(Long id) {
		return session.get(Laboratoire.class, id);
	}

	@Override
	public List<Laboratoire> getAll() {
		return session.createQuery("select o from Laboratoire o").list();
	}
	
	public static LaboratoireDao getInstance() {
	    if (instance == null)
               instance = new LaboratoireDao();
	    return instance;
	}
}
