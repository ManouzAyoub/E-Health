package metier.dao.util;

import metier.dao.Implementations.DocteurDao;
import metier.dao.Implementations.UserDao;
import metier.dao.beans.Docteur;

public class Test {

    public static void main( String[] args ) {

        UserDao user = UserDao.getInstance();

        Docteur docteur = new Docteur();
        
        docteur.setCin(1L);
        docteur.setEmail("youssef@gmail.com");
        docteur.setFirstname("youssef");
        docteur.setLastname("el gourari");
        docteur.setSpecialiter("test");
        docteur.setName("test");
        
        DocteurDao dao = DocteurDao.getInstance();
        dao.add(docteur);

    }

}
