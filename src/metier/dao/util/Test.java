package metier.dao.util;

import java.util.ArrayList;
import java.util.HashSet;

import java.util.List;
import java.util.Set;

import metier.dao.Implementations.DocteurDao;
import metier.dao.Implementations.LangueDao;
import metier.dao.Implementations.RatingDao;
import metier.dao.Implementations.RoleDao;
import metier.dao.beans.Docteur;
import metier.dao.beans.Langue;
import metier.dao.beans.Rating;
import metier.dao.beans.Role;
import metier.services.DocteurImpl;
import metier.services.RatingImpl;

public class Test {

    public static void main( String[] args ) {
    	
    	List<Langue> les_langues = new ArrayList<>();
    	
    	Set<Langue> setLangue = new HashSet<Langue>();
    	Set<Docteur> setDocteur = new HashSet<Docteur>();

    	DocteurImpl implDocteur = DocteurImpl.getInstance();
    	
    	 Role role = new Role();
         role.setRole("admin");
         
         RoleDao roleDao = RoleDao.getInstance();
         roleDao.add(role);
    	
        LangueDao langueDao = LangueDao.getInsctance();
        
        Langue ins_l1 = new Langue();
        
        ins_l1.setLangue("Arabic");
        langueDao.add(ins_l1);
        
        Langue ins_l2 = new Langue();
        ins_l2.setLangue("English");
        langueDao.add(ins_l2);
        
        Langue l1 = langueDao.getById(1L);
        Langue l2 = langueDao.getById(1L);
         les_langues.add(l2);
         les_langues.add(l1);
        
        DocteurDao docteurDao = DocteurDao.getInstance();
        
        Role r = roleDao.getById(1);
        
        Docteur docteur = new Docteur();
        
        docteur.setEmail("youssef@gmail.com");
        docteur.setFirstname("Youssef");
        docteur.setLastname("El Gourari");
        docteur.setLangues(les_langues);
        docteur.setParlerPar(setLangue);
        docteur.setConsultationDomicile(true);
        docteur.setTeleMedcine(true);
        docteur.setDispo(true);
        docteur.setAdresse("agadir hay salam");
        docteur.setGender("Homme");
        docteur.setTel("0676873368");
        docteur.setHeureDepart(9);
        docteur.setHeureFin(16);
        docteur.setAge(33);
        docteur.setJourDepart("Lundi");
        docteur.setJourFin("vendredi");
        docteur.setPractice("Cabinet");
        docteur.setSpeciality("Chirurgie esthétique");
        docteur.setRole(r);

       Docteur doc = docteurDao.add(docteur);
        
        Rating rating = new Rating();
        
        Docteur d = docteurDao.getById(1L);
        
        rating.setNumberEtoile(4);
        rating.setDocteur(d);
        
        RatingDao dao = RatingDao.getInstance();
        
        dao.add(rating);
        
       
        
        System.out.println("Fin D'inssersion");
        
        
        
        
    }

}
