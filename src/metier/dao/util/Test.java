package metier.dao.util;

import java.util.ArrayList;
import java.util.HashSet;

import java.util.List;
import java.util.Set;

import metier.dao.Implementations.DocteurDao;
import metier.dao.Implementations.LangueDao;
import metier.dao.Implementations.RatingDao;
import metier.dao.beans.Docteur;
import metier.dao.beans.Langue;
import metier.dao.beans.Rating;
import metier.services.DocteurImpl;
import metier.services.RatingImpl;

public class Test {

    public static void main( String[] args ) {
    	
    	List<Langue> les_langues = new ArrayList<>();
    	
    	Set<Langue> setLangue = new HashSet<Langue>();
    	Set<Docteur> setDocteur = new HashSet<Docteur>();

    	DocteurImpl implDocteur = DocteurImpl.getInstance();
    	
        LangueDao langueDao = LangueDao.getInsctance();
        
        // 1
        Langue langue = new Langue();
        
        langue.setLangue("arabe");
        
        langueDao.add(langue);
        setLangue.add(langue);
        
        // 2
        Langue langue_2 = new Langue();
        
        langue_2.setLangue("français");
        
        langueDao.add(langue_2);
        setLangue.add(langue_2);
        
        // la list
        
        les_langues.add(langue);
        les_langues.add(langue_2);
        
        DocteurDao docteurDao = DocteurDao.getInstance();
        
        Docteur docteur = new Docteur();
        
        docteur.setEmail("bbb");
        docteur.setFirstname("bbb");
        docteur.setLastname("bbb");
        docteur.setLangues(les_langues);
        docteur.setParlerPar(setLangue);
        docteur.setConsultationDomicile(true);
        docteur.setTeleMedcine(true);
        docteur.setDispo(true);
        docteur.setAdresse("agadir hay salam");
        docteur.setGender("Femme");
        docteur.setTel("0676873368");
        
        Docteur d = docteurDao.add(docteur);
        
        RatingDao ratingDao = RatingDao.getInstance();
        RatingImpl ratingImpl = RatingImpl.getInstance();
        Rating rating = new Rating();
        
        
        List<Docteur> list = implDocteur.getDoctorsAccordingToTheirAvailability(false);
        
        if (list.isEmpty()) {
			System.out.println("rien a afficher");
		}
        
        for(Docteur ls : list) {
        	System.out.println(ls.toString());
        }
        
        Docteur docteurbyid = docteurDao.getById(1L);
        rating.setDocteur(docteurbyid);
        rating.setNumberEtoile(4);
        ratingDao.add(rating);
        long result = ratingImpl.getNumberOfEtoileByDoctor(docteurbyid);
        Double a = result + 0.0;
        System.out.println("resultat of rating ---- " + result);
        System.out.println("the last function average --***-- : " + ratingImpl.getAverageOfRatingByDoctor(docteurbyid));
        
        
        
        
        
        long result_two = ratingImpl.getNumberOfRatingByDoctor(docteurbyid);
        Double b = result_two - 1 + 0.0;
        System.out.println(a);
        System.out.println(b);
        System.out.println("number of rating : " + (result_two - 1));
        System.out.println("resultat of round function " + Math.round(a/(b)));
        
        
        List<Langue> list_langue = docteurbyid.getLangues();
        
        for(Langue lg : list_langue ) {
        	System.out.println( "allez youssef : " + lg.getLangue());
        }
//        
//        List<Langue> list_langue = implDocteur.getLanguagesSpokenByDocteur(docteurbyid);
//        System.out.println(list_langue);
        

    }

}
