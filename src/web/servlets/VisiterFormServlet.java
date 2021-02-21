package web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.dao.Implementations.RoleDao;
import metier.dao.Implementations.UserDao;
import metier.dao.beans.Role;
import metier.dao.beans.User;
import metier.services.RoleImpl;
import metier.services.UserImpl;

@WebServlet( "/visiterForm" )
public class VisiterFormServlet extends HttpServlet {
    private static final long  serialVersionUID = 1L;
    public static final String ATT_VISITER      = "visiter";
    public static final String ATT_FORM         = "form";
    public static final String ATT_RESULTAT     = "resultat";
    public static final String ATT_ERROR        = "erreurs";

    public static final String VUE              = "/WEB-INF/VisiterForm.jsp";
    public static final String SUCESS           = "/WEB-INF/Home.jsp";
    
    Role role=new Role();
    
    public VisiterFormServlet() {
        super();
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        
    	UserImpl form = UserImpl.getInstance();
    	
        RoleImpl roleimpl=RoleImpl.getInstance();
        
        RoleDao roledao=RoleDao.getInstance();
        
    	User visiter = form.visitorFormService( request );

        request.setAttribute( ATT_VISITER, visiter );
        request.setAttribute( ATT_FORM, form );

        if ( form.getErreurs().isEmpty() ) {

            UserDao userdao = UserDao.getInstance();
            
            role=roleimpl.getRolebyrole("utilisateur");
            
            visiter.setRole(role);
            userdao.add( visiter );

            this.getServletContext().getRequestDispatcher( SUCESS ).forward(
                    request, response );

        } else {
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

        }

    }

}
