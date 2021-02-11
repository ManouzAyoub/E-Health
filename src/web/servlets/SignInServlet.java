package web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.dao.Implementations.UserDao;
import metier.dao.beans.User;
import metier.services.SignInFormService;
import metier.services.UserImpl;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {	
	
    private static final String ATT_VISITER      = "visiter";
    private static final String ATT_FORM         = "form";
    private static final String ATT_RESULTAT     = "resultat";
    private static final String ATT_ERROR        = "erreurs";
       
    private static final String VUE            = "/WEB-INF/SignIn.jsp";
    private static final String SUCESS         = "/WEB-INF/Home.jsp";
   
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
    	
    	HttpSession session = request.getSession();
    	
    	session.setAttribute("visiter", visiter);
    	
    	System.out.println(visiter);
    	
        request.setAttribute( ATT_VISITER, visiter );
        request.setAttribute( ATT_FORM, form );

        if ( form.getErreurs().isEmpty() ) {
            this.getServletContext().getRequestDispatcher( SUCESS ).forward(request, response );
        } else {
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

        }

	}

}
