package metier.dao.util;

import java.util.ArrayList;
import java.util.HashSet;

import java.util.List;
import java.util.Set;

import metier.dao.Implementations.DocteurDao;
import metier.dao.Implementations.LangueDao;
import metier.dao.beans.Docteur;
import metier.dao.beans.Langue;

public class Test {

    public static void main( String[] args ) {
    	
    	List<Langue> les_langues = new ArrayList<>();

        LangueDao langueDao = LangueDao.getInsctance();
        
        // 1
        Langue langue = new Langue();
        
        langue.setLangue("arabe");
        
        langueDao.add(langue);
        
        // 2
        Langue langue_2 = new Langue();
        
        langue_2.setLangue("français");
        
        langueDao.add(langue_2);
        
        // la list
        
        les_langues.add(langue);
        les_langues.add(langue_2);
        
        DocteurDao docteurDao = DocteurDao.getInstance();
        
        Docteur docteur = new Docteur();
        
        docteur.setEmail("bbb");
        docteur.setFirstname("bbb");
        docteur.setLastname("bbb");
        docteur.setLangues(les_langues);
        
        docteurDao.add(docteur);
        

    }

}
