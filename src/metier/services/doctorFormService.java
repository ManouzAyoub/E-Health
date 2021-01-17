package metier.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;


import metier.dao.beans.Docteur;

public class doctorFormService {
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
        String firstname = request.getParameter( CHAMP_FIRSTNAME );
        String lastname = request.getParameter( CHAMP_LASTNAME );
        String email = request.getParameter( CHAMP_EMAIL );
        String tel = request.getParameter( CHAMP_TEL );
        String speciality = request.getParameter( CHAMP_SPECIALITY );
        String[] languages = request.getParameterValues( CHAMP_LANGUAGES );
        String practice=request.getParameter(CHAMP_PRACTICE);
        
        Part medfile=request.getPart(CHAMP_MED_CERTIFICATE);
        Part localfile=request.getPart(CHAMP_LOCAL_CONTRACT);
        Part photofile=request.getPart(CHAMP_PROFILE_IMAGE);
		List<Part> fileParts = request.getParts().stream().filter(part -> CHAMP_ID_SCAN.equals(part.getName()) && part.getSize() > 0).collect(Collectors.toList());
		
		InputStream inputStream1=null,inputStream2=null,inputStream3=null,inputStream4=null;
		
		Docteur doctor = new Docteur();
		
		byte[] bite1=null,bite2=null,bite3=null,bite4=null;
		
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
		    
		    if(medfile!=null) {
			    System.out.println(medfile.getName());
			    System.out.println(medfile.getSize());
			    System.out.println(medfile.getContentType());
		    inputStream2=medfile.getInputStream();
    		bite2=convert(inputStream2);
             }
		    
		    if(localfile!=null) {
			    System.out.println(localfile.getName());
			    System.out.println(localfile.getSize());
			    System.out.println(localfile.getContentType());
		    inputStream3=localfile.getInputStream();
    		bite3=convert(inputStream3);

		    }
		    
		    if(photofile!=null) {
			    System.out.println(photofile.getName());
			    System.out.println(photofile.getSize());
			    System.out.println(photofile.getContentType());
		    inputStream4=photofile.getInputStream();
    		bite4=convert(inputStream4);
            }
        
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

        if ( erreurs.isEmpty() ) {
            resultat = "Succ�s d'inscription!";
        } else {
            resultat = "Echec d'inscription";
        }
        
        doctor.setSpeciality(speciality);
        doctor.setLanguages(languages[0]);
        doctor.setPractice(practice);
        doctor.setId_scan(bite1);
        doctor.setMed_certificate(bite2);
        doctor.setLocal_contract(bite3);
        doctor.setProfile_image(bite4);
        return doctor;
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
