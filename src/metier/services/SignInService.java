package metier.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import metier.dao.Implementations.UserDao;
import metier.dao.beans.User;
import metier.dao.util.HibernateUtil;

public class SignInService {
	
	Session session = HibernateUtil.openSession();
	private static SignInService instance = null;

	    private static final String CHAMP_EMAIL        = "email";
	    private static final String CHAMP_PASSWORD     = "password";

	    private String              resultat;
	    private Map<String, String> erreurs            = new HashMap<String, String>();

	    public String getResultat() {
	        return resultat;
	    }

	    public void setResultat( String resultat ) {
	        this.resultat = resultat;
	    }

	    public Map<String, String> getErreurs() {
	        return erreurs;
	    }
	    
	    public User VerifyUser( String email,String password) {
	    	String hql="SELECT u FROM user u WHERE u.email = :email AND u.password = :password";
	        Query query = session.createQuery( hql );
	        query.setParameter("email", email);
	        query.setParameter("password", password);
	        User user=new User();
	        user = (User)((org.hibernate.query.Query) query).list().get(0);
	        System.out.print("this is it" +user.getEmail());
    		return user;    		
    	}
	    
	    public User SignInService(HttpServletRequest request) {
	        
	        String email = request.getParameter( CHAMP_EMAIL );
	        String password = request.getParameter( CHAMP_PASSWORD );
	        User visiter = new User();        
	        User listUser=VerifyUser(email, password);
//	        System.out.print("this is it" +listUser.getEmail());
	        
	        if(listUser!=null) {
	        	visiter.setEmail(email);
	        	visiter.setPassword(password);
	        	resultat = "Succés d'inscription!";
	        }
	        else {
	        	visiter.setEmail(email);
	        	erreurs.put( CHAMP_EMAIL, "Vous etes pas inscrit" );
	        	resultat = "Echec d'inscription";
	        }


	        return visiter;
	    }
	   
	    public static SignInService getInstance() {
	        if ( instance == null )
	            instance = new SignInService();
	        return instance;
	    }
}
