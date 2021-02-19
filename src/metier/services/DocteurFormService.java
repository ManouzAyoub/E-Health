package metier.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;


import metier.dao.beans.Docteur;
import metier.dao.beans.Langue;

public class DocteurFormService {
    private static final String CHAMP_FIRSTNAME       = "firstname";
    private static final String CHAMP_LASTNAME        = "lastname";
    private static final String CHAMP_EMAIL           = "email";
    private static final String CHAMP_SPECIALITY      = "speciality";
    private static final String CHAMP_PRACTICE        = "med_practice";
    private static final String CHAMP_TEL             = "tel";
    private static final String CHAMP_LANGUAGES       = "languages";
    private static final String CHAMP_ID_SCAN         = "id_scan";
    private static final String CHAMP_PROFILE_IMAGE   = "profile_image";
    private static final String CHAMP_MED_CERTIFICATE = "med_certificate";
    private static final String CHAMP_LOCAL_CONTRACT  = "local_contract";
    private static final String CHAMP_VILLE           = "ville";
    

    private String              resultat;
    private Map<String, String> erreurs               = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public void setResultat( String resultat ) {
        this.resultat = resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Docteur doctorFormService( HttpServletRequest request ) throws IOException, ServletException {
    	String ville = request.getParameter(CHAMP_VILLE);
        String firstname   = request.getParameter( CHAMP_FIRSTNAME );
        String lastname    = request.getParameter( CHAMP_LASTNAME );
        String email       = request.getParameter( CHAMP_EMAIL );
        String tel         = request.getParameter( CHAMP_TEL );
        String speciality  = request.getParameter( CHAMP_SPECIALITY );
        String[] languages = request.getParameterValues( CHAMP_LANGUAGES );
        String practice    = request.getParameter(CHAMP_PRACTICE);
        Part medfile       = request.getPart(CHAMP_MED_CERTIFICATE);
        Part localfile     = request.getPart(CHAMP_LOCAL_CONTRACT);
        Part photofile     = request.getPart(CHAMP_PROFILE_IMAGE);
		List<Part> fileParts = request.getParts().stream().filter(part -> CHAMP_ID_SCAN.equals(part.getName()) && part.getSize() > 0).collect(Collectors.toList());
		
		InputStream inputStream1=null,inputStream2=null,inputStream3=null,inputStream4=null;
		
		Docteur doctor = new Docteur();
		
		byte[] bite1=null,bite2=null,bite3=null,bite4=null;
			    
		    if(photofile!=null) {
			    System.out.println(photofile.getName());
			    System.out.println(photofile.getSize());
			    System.out.println(photofile.getContentType());
		    inputStream4=photofile.getInputStream();
    		bite4=convert(inputStream4);
            }
		    doctor.setProfile_image(bite4);
		    
		    /*ID_SCAN*/
        for(Part filepart1 : fileParts) {
    		if(filepart1!=null) {
    		      // prints out some information for debugging
                System.out.println(filepart1.getName());
                System.out.println(filepart1.getSize());
                System.out.println(filepart1.getContentType());
                
        		inputStream1=filepart1.getInputStream();
        		bite1=convert(inputStream1);
    		    }
    		}
	        try {
	        	validationImageID( bite1 );

	        } catch ( Exception e ) {
	            erreurs.put( CHAMP_ID_SCAN, e.getMessage() );
	        }
	        doctor.setId_scan(bite1);
	        /*ID_SCAN*/
	        
	        /*MED_FILE*/
	        if(medfile.getSize()!=0) {
			    System.out.println(medfile.getName());
			    System.out.println(medfile.getSize());
			    System.out.println(medfile.getContentType());
		    inputStream2=medfile.getInputStream();
    		bite2=convert(inputStream2);}
	        
		    try {
		        validationImageCertificat( bite2 );
		    } catch ( Exception e ) {
		        erreurs.put( CHAMP_MED_CERTIFICATE, e.getMessage() );
		    }
	        doctor.setMed_certificate(bite2);
	        /*MED_FILE*/
	        
	        /*LOCAL_FILE*/
		    if(localfile.getSize()!=0) {
			    System.out.println(localfile.getName());
			    System.out.println(localfile.getSize());
			    System.out.println(localfile.getContentType());
			    inputStream3=localfile.getInputStream();
				bite3=convert(inputStream3);}
	        
		    try {
		        validationImageLocalContract( bite3 );
		    } catch ( Exception e ) {
		        erreurs.put( CHAMP_LOCAL_CONTRACT, e.getMessage() );
		    }
		    doctor.setLocal_contract(bite3);
		    /*LOCAL_FILE*/
		    
	        try {
	            validationEmail( email );
	        } catch ( Exception e ) {
	            erreurs.put( CHAMP_EMAIL, e.getMessage() );
	        }
	        doctor.setEmail( email );
	
	        try {
	            validationPrenom( firstname );
	        } catch ( Exception e ) {
	            erreurs.put( CHAMP_FIRSTNAME, e.getMessage() );
	        }
	        doctor.setFirstname( firstname );
	
	        try {
	            validationNom( lastname );
	        } catch ( Exception e ) {
	            erreurs.put( CHAMP_LASTNAME, e.getMessage() );
	        }
	        doctor.setLastname( lastname );
	
	        try {
	            validationTel( tel );
	        } catch ( Exception e ) {
	            erreurs.put( CHAMP_TEL, e.getMessage() );
	        }
	        doctor.setTel( tel );
        
        
        LangueImpl langueImpl = LangueImpl.getInstance();
        List<Langue> les_langues = new ArrayList<>();
        if(languages!=null) {
        for(String lg : languages) {
        	Langue langue = langueImpl.getLangueByString(lg);
        	les_langues.add(langue);
          }
        }
        try {
            validationLangues( les_langues );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_LANGUAGES, e.getMessage() );
        }
        doctor.setLangues(les_langues);
        
        try {
            validationPractice( practice );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_PRACTICE  , e.getMessage() );
        }
        doctor.setPractice(practice);
        
        doctor.setHeureDepart("9:00");
        doctor.setHeureFin("15:00");
        doctor.setJourDepart("Lundi");
        doctor.setJourFin("Vendredi");
        doctor.setDispo(false);
        doctor.setNbrVisiters(0L);
        doctor.setTeleMedcine(false);
        doctor.setConsultationDomicile(false);
        doctor.setId("ChIJyRyt2um2sw0RdIT0i7fQ-Lw");
        doctor.setVille(ville);
        doctor.setFirst_using(false);

        
        if ( erreurs.isEmpty() ) {
            resultat = "Succ�s d'inscription!";
        } else {
            resultat = "Echec d'inscription";
        }

        doctor.setSpeciality(speciality);
        return doctor;
    }
    
    
    
    private void validationImageID( byte[] bite ) throws Exception {
        if ( bite == null ) {
                throw new Exception( "Veuillez saisir un screeshot de votre carte nationale!" );
        }
    }
    
    private void validationImageCertificat( byte[] bite  ) throws Exception {
    	System.out.print("NOT null");

        if ( bite == null ) {
	    	System.out.print("nulllllll");

                throw new Exception( "Veuillez saisir un screeshot de votre certificat m�dical!" );
        }
    }
    
    private void validationImageLocalContract( byte[] bite ) throws Exception {
        if ( bite == null ) {
                throw new Exception( "Veuillez saisir un screeshot de votre contract de location!" );
        }
    }
    
    private void validationLangues( List<Langue> les_langues ) throws Exception {
        if ( les_langues.size() == 0 ) {
                throw new Exception( "Veuillez saisir la/les langues que vous parlez" );
        }
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

    private void validationEmail( String email ) throws Exception {
        String regex = "([^.@]+)(\\\\.[^.@]+)*@([^.@]+\\\\.)+([^.@]+)";
        if ( email != null && email.trim().length() != 0 ) {
            if ( email.matches( regex ) ) {
                throw new Exception( "adresse email valid�" );
            }

        } else {
            throw new Exception( "Veuillez saisir une adresse email s'il vous plait!" );
        }
    }

    private void validationTel( String tel ) throws Exception {
        if ( tel != null ) {
            if ( tel.trim().length() != 10 ) {
                throw new Exception( "on demande votre numero de tel r�el" );
            }
        } else {
            throw new Exception( "Veuillez saisir votre numero de Telephone" );
        }
    }
    private void validationPractice( String practice ) throws Exception {
        if ( practice=="none") {
                throw new Exception( "Veuillez saisir votre domaine m�dical!" );
        }
    }
    
    private byte[] convert(InputStream inputstream) throws IOException {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		int nRead;
		byte[] data = new byte[16384];

		while ((nRead = inputstream.read(data, 0, data.length)) != -1) {
		  buffer.write(data, 0, nRead);
		}

		return buffer.toByteArray();
    }
    
    
}