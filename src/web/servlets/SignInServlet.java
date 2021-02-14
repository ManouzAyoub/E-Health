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
    private static final String SUCESS_ADMIN     = "/WEB-INF/AdminDashboard.jsp";
    private static final String SUCESS_DOCTEUR   = "/WEB-INF/DoctorDashBoard.jsp";
    private static final String SUCESS_CLINIQUE  = "/WEB-INF/Home.jsp";
   
	  public SignInServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		System.out.println("fonction correctement");
        
		SignInFormService form = SignInFormService.getInstance();
        
    	User visiter = form.SignInService( request );
    	
    	
    	request.setAttribute( ATT_VISITER, visiter );
        request.setAttribute( ATT_FORM, form );
    	
    	if ( visiter.getRole().getRole().equals("admin") ) {
    		
			HttpSession session = request.getSession();
			session.setAttribute("admin", visiter);
			List<Commentaire> comments = commentaireImpl.getCommentsNotApproved(false, false);
			request.setAttribute("comments", comments);
			request.setAttribute("clinics", cliniqueImpl.getAllClinicsAccordingToTheirAvailability( false ));
			request.setAttribute("docs", docImpl.getDoctorsAccordingToTheirAvailability(false));
			request.setAttribute("nbrUsers", userImpl.getNumbersOfUserVisiter(4) != null ? userImpl.getNumbersOfUserVisiter(4) : 0 );
			request.setAttribute("nbrDoctors", userImpl.getNumbersOfUser("Docteur") != null ? userImpl.getNumbersOfUser("Docteur") : 0  );
			request.setAttribute("nbrPharmacies", userImpl.getNumbersOfUser("Pharmacie") != null ? userImpl.getNumbersOfUser("Pharmacie") : 0 );
			request.setAttribute("nbrClinics", userImpl.getNumbersOfUser("Clinique") != null ? userImpl.getNumbersOfUser("Clinique") : 0  );
			
			if ( form.getErreurs().isEmpty() ) {
	            this.getServletContext().getRequestDispatcher( SUCESS_ADMIN ).forward(request, response );
	        } else {
	            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	        }
		}
    	
    	if ( visiter.getRole().getRole().equals("utilisateur") ) {
    		
    		HttpSession session = request.getSession();
        	session.setAttribute("visiter", visiter);
        	
        	if ( form.getErreurs().isEmpty() ) {
                this.getServletContext().getRequestDispatcher( SUCESS_USER ).forward(request, response );
            } else {
                this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
            }
		}
    	
    	if ( visiter.getRole().getRole().equals("docteur") ) {
    		
    		HttpSession session = request.getSession();
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
    		
    		HttpSession session = request.getSession();
        	session.setAttribute("clinique", visiter);
        	
        	if ( form.getErreurs().isEmpty() ) {
                this.getServletContext().getRequestDispatcher( SUCESS_CLINIQUE ).forward(request, response );
            } else {
                this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
            }
		}

	}
	
	

}
