package web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.dao.Implementations.DocteurDao;
import metier.dao.beans.Clinique;
import metier.dao.beans.Docteur;
import metier.dao.util.Instances;
import metier.services.DocteurImpl;
import metier.services.SendEmailService;

@WebServlet("/SendEmail")
public class SendEmailServlet extends HttpServlet {
	
	public static final String VUE              = "/WEB-INF/AdminDashboard.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if (session.getAttribute("admin") != null) {
			
			String s = request.getParameter("approve");
			String des = request.getParameter("desapprove");
			String appClinique = request.getParameter("approvec");
			String desClinique = request.getParameter("desapprovec");
			
			if ( s != null) {
							
				String id = request.getParameter("id");
				
				Docteur docteur = Instances.docteurDao.getById(Long.valueOf(id));
				
				String message = "message envoyer au docteur dans l'email";
				
				String password = Instances.send.generateRandomPassword(8);
				
				Instances.send.sendEMailToUser(message, password, docteur.getEmail());
				
				docteur.setPassword(password);
				docteur.setAdmin_confirmation(true);
				
				Instances.docteurDao.edit(docteur);
				
				response.sendRedirect( request.getContextPath() + "/toAdminData");
				
				
			}
			
			if (des != null ) {
				String email = request.getParameter("email");
				
				String message_echeck = "message envoyer au docteur dans l'email erreeeeeeeeeeeeeeeeeeeeeeeeeeeeur";
				
				Instances.send.sendEMailToUser(message_echeck, " - ", email);
				
				response.sendRedirect( request.getContextPath() + "/toAdminData");
				
			}
			
			if ( appClinique != null) {
				
				String id = request.getParameter("id");
				
				Clinique clinique = Instances.cliniqueDao.getById(Long.valueOf(id));
				
				String message = "message envoyer au docteur dans l'email";
				
				String password = Instances.send.generateRandomPassword(8);
				
				Instances.send.sendEMailToUser(message, password, clinique.getEmail());
				
				clinique.setPassword(password);
				clinique.setAdmin_confirmation(true);
				
				Instances.cliniqueDao.edit(clinique);
				
				response.sendRedirect( request.getContextPath() + "/toAdminData");
				
				
			}
			
			if (desClinique != null ) {
				String id = request.getParameter("id");
				
				Clinique clinique = Instances.cliniqueDao.getById(Long.valueOf(id));
				
				String message_echeck = "message envoyer au docteur dans l'email erreeeeeeeeeeeeeeeeeeeeeeeeeeeeur";
				
				Instances.send.sendEMailToUser(message_echeck, " - ", clinique.getEmail());
				
				response.sendRedirect( request.getContextPath() + "/toAdminData");
			}
		} else {
			response.sendRedirect( request.getContextPath() + "/Home");
		}
		
		
		

		
	}

}
