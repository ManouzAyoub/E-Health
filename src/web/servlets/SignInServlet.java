package web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.dao.Implementations.CommentaireDao;
import metier.dao.Implementations.DocteurDao;
import metier.dao.Implementations.UserDao;
import metier.dao.beans.Commentaire;
import metier.dao.beans.Docteur;
import metier.dao.beans.User;
import metier.dao.util.Instances;
import metier.services.CliniqueImpl;
import metier.services.CommentaireImpl;
import metier.services.DocteurImpl;
import metier.services.SignInFormService;
import metier.services.UserImpl;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {	
	
	DocteurDao docteurDao 						 = DocteurDao.getInstance();
	DocteurImpl docImpl 						 = DocteurImpl.getInstance();
	UserImpl userImpl 							 = UserImpl.getInstance();
	CliniqueImpl cliniqueImpl 					 = CliniqueImpl.getInstance();
	CommentaireDao commentaireDao 			     = CommentaireDao.getInstance();
	CommentaireImpl commentaireImpl = CommentaireImpl.getInstance();
    private static final String ATT_VISITER      = "visiter";
    private static final String ATT_FORM         = "form";
    private static final String ATT_RESULTAT     = "resultat";
    private static final String ATT_ERROR        = "erreurs";
    private static final String VUE              = "/WEB-INF/SignIn.jsp";
    private static final String HOME             = "/WEB-INF/Home.jsp";
    private static final String SUCESS_USER      = "/WEB-INF/Home.jsp";
    private static final String SUCESS_ADMIN     = "/DataAdmin";
    private static final String SUCESS_DOCTEUR   = "/WEB-INF/DoctorDashBoard.jsp";
    private static final String SUCESS_CLINIQUE  = "/WEB-INF/Home.jsp";
   
    private Boolean aide = false;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!aide) {
			this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		System.out.println("fonction correctement");
        
		SignInFormService form = SignInFormService.getInstance();
        
    	User visiter = form.SignInService( request );

    	System.out.println("visiter role "+ visiter.getRole());
    	HttpSession session = request.getSession();
    	
    	if ( visiter.getRole().getRole().equals("admin") ) {
    		session.setAttribute("admin", visiter);
			User u = (User) session.getAttribute("admin");
			System.out.println("from sign in section admin is correct " + session.getAttribute("admin"));
			request.setAttribute("adminUser", u);
			this.getServletContext().getRequestDispatcher( "/toAdminData" ).forward( request, response );
			
		}
    	
    	if ( visiter.getRole().getRole().equals("utilisateur") ) {
    		
    		
        	session.setAttribute("visiter", visiter);
        	
        	if ( form.getErreurs().isEmpty() ) {
                this.getServletContext().getRequestDispatcher( SUCESS_USER ).forward(request, response );
            } else {
                this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
            }
		}
    	
    	if ( visiter.getRole().getRole().equals("docteur") ) {
    		
    		
        	session.setAttribute("docteur", visiter);
        	
        	Docteur d = docteurDao.getById(visiter.getCin());
        	
        	// if docteur est entrer le mot de passe génerique ----> dashborad docteur sinon Home
        	
        	if ( form.getErreurs().isEmpty() && d.getDispo() == false ) {
                this.getServletContext().getRequestDispatcher( SUCESS_DOCTEUR ).forward(request, response );
            }
        	else if ( form.getErreurs().isEmpty() && d.getDispo() == true ) {
                this.getServletContext().getRequestDispatcher( HOME ).forward(request, response );
            }
        	else {
                this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
            }
		}
    	
    	if ( visiter.getRole().getRole().equals("clinique") ) {
    		
    		
        	session.setAttribute("clinique", visiter);
        	
        	if ( form.getErreurs().isEmpty() ) {
                this.getServletContext().getRequestDispatcher( SUCESS_CLINIQUE ).forward(request, response );
            } else {
                this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
            }
		}

	}
	
	

}
