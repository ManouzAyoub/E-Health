package metier.services;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.healthForms.beans.Clinic;
import com.healthForms.beans.Visiter;

import metier.dao.beans.Clinique;

public class clinicFormService {
	 private static final String CHAMP_NAME    = "name";
	    private static final String CHAMP_ADDRESS     = "address";
	    private static final String CHAMP_EMAIL     = "email";
	    private static final String CHAMP_TEL       = "tel";
	    private static final String CHAMP_EMER_TEL    = "emergency_tel";
	    private static final String CHAMP_SPECIALITY = "speciality";

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
 public Clinic clinicFormService(HttpServletRequest request) {
     String name = request.getParameter( CHAMP_NAME );
     String address = request.getParameter( CHAMP_ADDRESS );
     String email = request.getParameter( CHAMP_EMAIL);
     String tel = request.getParameter( CHAMP_TEL );
     String emer_tel = request.getParameter( CHAMP_EMER_TEL );
     String[] speciality = request.getParameterValues( CHAMP_SPECIALITY );

     Clinique clinic = new Clinique();
     
     try {
         validationNom( name );
     } catch ( Exception e ) {
         erreurs.put( CHAMP_NAME, e.getMessage() );
     }
     clinic.setName(name);
     
     try {
         validationAddress( address );
     } catch ( Exception e ) {
         erreurs.put( CHAMP_ADDRESS, e.getMessage() );
     }
     clinic.setAddress(address);
     
     try {
         validationTel( tel );
     } catch ( Exception e ) {
         erreurs.put( CHAMP_TEL, e.getMessage() );
     }
     clinic.setTel( tel );
     
     try {
         validationTel( emer_tel );
     } catch ( Exception e ) {
         erreurs.put( CHAMP_EMER_TEL, e.getMessage() );
     }
     clinic.setEmergency_tel(emer_tel);;
     
     try {
         validationEmail( email );
     } catch ( Exception e ) {
         erreurs.put( CHAMP_EMAIL, e.getMessage() );
     }
     clinic.setEmail( email );
     clinic.setSpeciality(speciality[0]);
       
     if ( erreurs.isEmpty() ) {
         resultat = "Succés d'inscription!";
     } else {
         resultat = "Echec d'inscription";
     }
     
    
     
     return clinic;
 }
 
 private void validationNom( String name ) throws Exception {
     if ( name != null ) {
         if ( name.trim().length() < 3 ) {
             throw new Exception( "Veuillez saisir un nom de plus de 3 caractéres." );
         }
     }
 }
 private void validationAddress( String address ) throws Exception {
     if ( address != null ) {
         if ( address.trim().length() < 6 ) {
             throw new Exception( "Veuillez saisir un nom de plus de 6 caractéres." );
         }
     }
 }
 
 private void validationEmail( String email ) throws Exception {
     String regex = "([^.@]+)(\\\\.[^.@]+)*@([^.@]+\\\\.)+([^.@]+)";
     if ( email != null && email.trim().length() != 0 ) {
         if ( email.matches( regex ) ) {
             throw new Exception( "adresse email validé" );
         }

     } else {
         throw new Exception( "Veuillez saisir une adresse email s'il vous plait!" );
     }
 }

 private void validationTel( String tel ) throws Exception {
     if ( tel != null ) {
         if ( tel.trim().length() != 10 ) {
             throw new Exception( "on demande votre numero de tel réel" );
         }
     } else {
         throw new Exception( "Veuillez saisir votre numero de Telephone" );
     }
 }
}
