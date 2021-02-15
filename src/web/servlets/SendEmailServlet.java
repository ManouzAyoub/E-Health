package web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.dao.Implementations.DocteurDao;
import metier.dao.beans.Docteur;
import metier.services.DocteurImpl;
import metier.services.SendEmailService;

@WebServlet("/SendEmail")
public class SendEmailServlet extends HttpServlet {
	
	public static final String VUE              = "/WEB-INF/AdminDashboard.jsp";
	SendEmailService send   = SendEmailService.getInstance();
	DocteurDao docteurDao   = DocteurDao.getInstance();
	DocteurImpl docteurImpl = DocteurImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		
		String message_echeck = "message envoyer au docteur dans l'email erreeeeeeeeeeeeeeeeeeeeeeeeeeeeur";
		
		send.sendEMailToUser(message_echeck, "test", "youssefelgourari97@gmail.com");
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		
		Docteur docteur = docteurImpl.getDocteurByEmail(email);
		
		String message = "message envoyer au docteur dans l'email";
		
		String password = send.generateRandomPassword(8);
		
		send.sendEMailToUser(message, password, email);
		
		docteur.setPassword(password);
		
		docteurDao.edit(docteur);
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
		
	}

}
