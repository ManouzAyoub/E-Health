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

    

    public Docteur doctorFormService( HttpServletRequest request ) throws IOException, ServletException {
        String firstname     = request.getParameter( CHAMP_FIRSTNAME );
        String lastname      = request.getParameter( CHAMP_LASTNAME );
        String email         = request.getParameter( CHAMP_EMAIL );
        String tel           = request.getParameter( CHAMP_TEL );
        String speciality    = request.getParameter( CHAMP_SPECIALITY );
        String[] languages   = request.getParameterValues( CHAMP_LANGUAGES );
        String practice      = request.getParameter(CHAMP_PRACTICE);
        Part medfile         = request.getPart(CHAMP_MED_CERTIFICATE);
        Part localfile       = request.getPart(CHAMP_LOCAL_CONTRACT);
        Part photofile       = request.getPart(CHAMP_PROFILE_IMAGE);
		List<Part> fileParts = request.getParts().stream().filter(part -> CHAMP_ID_SCAN.equals(part.getName()) && part.getSize() > 0).collect(Collectors.toList());
		
		InputStream inputStream1=null,inputStream2=null,inputStream3=null,inputStream4=null;
		
		Docteur doctor = new Docteur();
		
		//byte[] bite1=null,bite2=null,bite3=null,bite4=null;
		byte[] bites[] = null;
		
        for(Part filepart1 : fileParts) {
		if(filepart1!=null) {
		      // prints out some information for debugging
            System.out.println(filepart1.getName());
            System.out.println(filepart1.getSize());
            System.out.println(filepart1.getContentType());
            
    		inputStream1=filepart1.getInputStream();
    		bites[0]=convert(inputStream1);
	
		    }
		}
		    
		    if(medfile!=null) {
			    System.out.println(medfile.getName());
			    System.out.println(medfile.getSize());
			    System.out.println(medfile.getContentType());
		    inputStream2=medfile.getInputStream();
    		bites[1]=convert(inputStream2);
             }
		    
		    if(localfile!=null) {
			    System.out.println(localfile.getName());
			    System.out.println(localfile.getSize());
			    System.out.println(localfile.getContentType());
		    inputStream3=localfile.getInputStream();
		    bites[2]=convert(inputStream3);

		    }
		    
		    if(photofile!=null) {
			    System.out.println(photofile.getName());
			    System.out.println(photofile.getSize());
			    System.out.println(photofile.getContentType());
		    inputStream4=photofile.getInputStream();
		    bites[3]=convert(inputStream4);
            }
        
        try {
            validationEmail( email );
            doctor.setEmail( email );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_EMAIL, e.getMessage() );
        }
        

        try {
            validationPrenom( firstname );
            doctor.setFirstname( firstname );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_FIRSTNAME, e.getMessage() );
        }
        

        try {
            validationNom( lastname );
            doctor.setLastname( lastname );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_LASTNAME, e.getMessage() );
        }
        

        try {
            validationTel( tel );
            doctor.setTel( tel );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_TEL, e.getMessage() );
        }
        

        if ( erreurs.isEmpty() ) {
            resultat = "Succés d'inscription!";
        } else {
            resultat = "Echec d'inscription";
        }
        
        LangueImpl langueImpl = LangueImpl.getInstance();
        
        doctor.setSpeciality(speciality);
        List<Langue> les_langues = new ArrayList<>();
        for(String lg : languages) {
        	Langue langue = langueImpl.getLangueByString(lg);
        	les_langues.add(langue);
        }
        doctor.setLangues(les_langues);	
        doctor.setPractice(practice);
        doctor.setId_scan(bites[0]);
        doctor.setMed_certificate(bites[1]);
        doctor.setLocal_contract(bites[2]);
        doctor.setProfile_image(bites[3]);
        return doctor;
    }
    
    
    


    private void validationPrenom( String firstname ) throws Exception {
        if ( firstname != null ) {
            if ( firstname.trim().length() < 3 ) {
                throw new Exception( "Veuillez saisir un nom de plus de 3 caractéres." );
            }
        }
    }

    private void validationNom( String lastname ) throws Exception {
        if ( lastname != null ) {
            if ( lastname.trim().length() < 3 ) {
                throw new Exception( "Veuillez saisir un nom de plus de 3 caractéres." );
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
    
    private byte[] convert(InputStream inputstream) throws IOException {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		int nRead;
		byte[] data = new byte[16384];

		while ((nRead = inputstream.read(data, 0, data.length)) != -1) {
		  buffer.write(data, 0, nRead);
		}

		return buffer.toByteArray();
    }
    
    public String getResultat() {
        return resultat;
    }

    public void setResultat( String resultat ) {
        this.resultat = resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }
    
    
}
