package metier.dao.util;

import metier.dao.Implementations.UserDao;
import metier.dao.beans.User;

public class Test {

    public static void main( String[] args ) {

        UserDao user = UserDao.getInstance();

        User u = new User();
        u.setEmail( "salma@gmail.com" );
        u.setFirstname( "salma" );
        u.setLastname( "jaouhari" );
        u.setPassword( "health123" );
        user.add( u );


    }

}
