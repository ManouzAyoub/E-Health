package web.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.services.doctorFormService;
import metier.dao.Implementations.DocteurDao;
import metier.dao.beans.Docteur;
import metier.dao.beans.Role;

@WebServlet( "/doctorForm" )
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,maxFileSize=16177215,maxRequestSize = 1024 * 1024 * 50)  // upload file's size up to 16MB
public class DoctorFormServlet extends HttpServlet {
    private static final long  serialVersionUID = 1L;
    public static final String ATT_DOCTOR      = "docteur";
    public static final String ATT_FORM         = "form";
    public static final String ATT_RESULTAT     = "resultat";
    public static final String ATT_ERROR        = "erreurs";

    public static final String VUE              = "/WEB-INF/DoctorForm.jsp";
    public static final String SUCESS           = "/WEB-INF/afficherDoctor.jsp";
    Role role = new Role();

    public DoctorFormServlet() {
        super();

    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
    	 doctorFormService form = new doctorFormService();
         Docteur doctor = form.doctorFormService(request);
         
         DocteurDao doctordao=DocteurDao.getInstance();
         
         String base64Image = Base64.getEncoder().encodeToString(doctor.getId_scan());
         doctor.setBase64image(base64Image);
         
         request.setAttribute( ATT_DOCTOR, doctor );
         request.setAttribute( ATT_FORM, form );

         if ( form.getErreurs().isEmpty() ) {

               doctordao.add(doctor);
 				this.getServletContext().getRequestDispatcher( SUCESS ).forward(
 	                     request, response );
             

         } else {
             this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

         }

    }

}
