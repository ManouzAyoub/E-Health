package metier.dao.util;

import metier.dao.Implementations.DocteurDao;
import metier.dao.Implementations.UserDao;
import metier.dao.beans.Docteur;

public class Test {

    public static void main( String[] args ) {

        DocteurDao doctorDao = DocteurDao.getInstance();

        Docteur docteur = new Docteur();
        
         docteur=doctorDao.getById(4L);
         System.out.println(docteur.getId_scan());  

    }

}
