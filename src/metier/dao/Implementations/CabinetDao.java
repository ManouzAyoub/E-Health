package metier.dao.Implementations;

import java.util.List;

import org.hibernate.Session;

import metier.dao.beans.Cabinet;
import metier.dao.util.HibernateUtil;
import metier.dao.util.functionStd;

public class CabinetDao implements functionStd<Cabinet, Long> {

	Session session = HibernateUtil.openSession();
	private static CabinetDao instance = null;
	
	private CabinetDao() {

	}
	
	@Override
	public Cabinet add(Cabinet a) {
		session.beginTransaction();
		session.save(a);
		session.getTransaction().commit();
		return a;
	}

	@Override
	public Cabinet edit(Cabinet a) {
		session.beginTransaction();
		session.merge(a);
		session.getTransaction().commit();
		return a;
	}

	@Override
	public void delete(Long b) {
		session.beginTransaction();
		Cabinet cabinet = getById(b);
		session.delete(cabinet);
		session.getTransaction().commit();
		
	}

	@Override
	public Cabinet getById(Long id) {
		return session.get(Cabinet.class, id);
	}

	@Override
	public List<Cabinet> getAll() {
		return session.createQuery("select o from Cabinet o").list();
	}
	
	public static CabinetDao getInsctance() {
		if (instance == null)
            instance = new CabinetDao();
		return instance;
	}
}
