package web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.dao.Implementations.CliniqueDao;
import metier.dao.Implementations.RoleDao;
import metier.dao.Implementations.UserDao;
import metier.dao.beans.Clinique;
import metier.dao.beans.Role;
import metier.dao.beans.User;
import metier.services.CliniqueImpl;
import metier.services.RoleImpl;
import metier.services.UserImpl;
import metier.services.clinicFormService;

@WebServlet("/clinicForm")
public class ClinicFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public static final String ATT_CLINIC      = "clinic";
    public static final String ATT_FORM         = "form";
    public static final String ATT_RESULTAT     = "resultat";
    public static final String ATT_ERROR        = "erreurs";

    public static final String VUE              = "/WEB-INF/ClinicForm.jsp";
    public static final String SUCESS           = "/WEB-INF/afficherClinic.jsp";
    
    Role role=new Role();
    
    public ClinicFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		clinicFormService form = clinicFormService.getInstance();
        RoleImpl roleimpl=RoleImpl.getInstance(); 
        RoleDao roledao=RoleDao.getInstance();
    	Clinique clinic = form.clinicFormService(request);

        request.setAttribute( ATT_CLINIC, clinic );
        request.setAttribute( ATT_FORM, form );

        if ( form.getErreurs().isEmpty() ) {

            CliniqueDao clinicdao = CliniqueDao.getInsctance();
            role=roleimpl.getRolebyrole("clinique");
            System.out.print(role.getRole());
            clinic.setRole(role);
            clinicdao.add(clinic);

            this.getServletContext().getRequestDispatcher( SUCESS ).forward(
                    request, response );

        } else {
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

        }

	}

}
