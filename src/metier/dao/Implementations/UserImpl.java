package metier.dao.Implementations;



import java.util.List;
import org.hibernate.Session;
import metier.dao.beans.User;
import metier.dao.util.HibernateUtil;
import metier.dao.util.functionStd;

public class UserImpl implements functionStd<User, String>{
	
	Session session = HibernateUtil.openSession();

	@Override
	public User add(User a) {
		session.beginTransaction();
		session.save(a);
		session.getTransaction().commit();
		return a;
	}

	@Override
	public User edit(User a) {
		session.beginTransaction();
		session.merge(a);
		session.getTransaction().commit();
		return a;
	}

	@Override
	public void delete(String b) {
		session.beginTransaction();
		User user = getById(b);
		session.delete(user);
		session.getTransaction().commit();
	}

	@Override
	public List<User> getAll() {
		return  session.createQuery("select o from User o").list();
	}

	@Override
	public User getById(String id) {
		return session.get(User.class, id);
	}
	
	

}
