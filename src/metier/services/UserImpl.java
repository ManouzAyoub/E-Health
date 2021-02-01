package metier.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import metier.dao.beans.User;
import metier.dao.util.HibernateUtil;

public class UserImpl {

	Session session = HibernateUtil.openSession();
	private static UserImpl instance = null;

    private UserImpl() {

    }

    private static final String CHAMP_FIRSTNAME    = "firstname";
    private static final String CHAMP_LASTNAME     = "lastname";
    private static final String CHAMP_EMAIL        = "email";
    private static final String CHAMP_PASSWORD     = "password";
    private static final String CHAMP_CONFIRMATION = "confirmation";

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
    
	public void validationEmail( String email) throws Exception{
    	String hql="select u from User u where u.email = :email";
        Query query = session.createQuery( hql );
        query.setParameter("email", email);
        User user = new User();
        List<User> list = query.getResultList();
        if (list.size() != 0) {
        	throw new Exception( "cet email a déja été choisie" );
		}else {
			return;
		}
	}

    public User visitorFormService( HttpServletRequest request ) {
        String firstname = request.getParameter( CHAMP_FIRSTNAME );
        String lastname = request.getParameter( CHAMP_LASTNAME );
        String email = request.getParameter( CHAMP_EMAIL );
        String password = request.getParameter( CHAMP_PASSWORD );
        String conf = request.getParameter( CHAMP_CONFIRMATION );
        String cin = request.getParameter(CHAMP_FIRSTNAME);
        User visiter = new User();

        
        try {
        	validationEmail(email);
        } catch ( Exception e ) {
            erreurs.put( CHAMP_EMAIL, e.getMessage() );
        }
        visiter.setEmail( email );

        try {
            validationMdp( password, conf );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_PASSWORD, e.getMessage() );
        }
        visiter.setPassword( password );

        try {
            validationPrenom( firstname );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_FIRSTNAME, e.getMessage() );
        }
        visiter.setFirstname( firstname );

        try {
            validationNom( lastname );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_LASTNAME, e.getMessage() );
        }
        visiter.setLastname( lastname );

        if ( erreurs.isEmpty() ) {
            resultat = "Succés d'inscription!";
        } else {
            resultat = "Echec d'inscription";
        }

        return visiter;
    }

    private void validationPrenom( String firstname ) throws Exception {
        if ( firstname != null ) {
            if ( firstname.trim().length() < 3 ) {
                throw new Exception( "Veuillez saisir un nom de plus de 3 caract�res." );
            }
        }
    }

    private void validationNom( String lastname ) throws Exception {
        if ( lastname != null ) {
            if ( lastname.trim().length() < 3 ) {
                throw new Exception( "Veuillez saisir un nom de plus de 3 caract�res." );
            }
        }
    }

    private void validationMdp( String motDePasse, String confirmation ) throws Exception {
        if ( motDePasse != null && motDePasse.trim().length() != 0 && confirmation != null
                && confirmation.trim().length() != 0 ) {
            if ( !motDePasse.equals( confirmation ) ) {
                throw new Exception( "Les mots de passe entr�s sont diff�rents, merci de les saisir � nouveau." );
            } else if ( motDePasse.trim().length() < 3 ) {
                throw new Exception( "Les mots de passe doivent contenir au moins 3 caract�res." );
            }
        } else {
            throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
        }
    }

    public static UserImpl getInstance() {
        if ( instance == null )
            instance = new UserImpl();
        return instance;
    }
}
