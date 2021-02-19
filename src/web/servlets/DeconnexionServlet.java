package web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Deconnexion")
public class DeconnexionServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("visiter") != null) {
			session.removeAttribute("visiter");
		}
		
		if (session.getAttribute("docteur") != null) {
			session.removeAttribute("docteur");
		}
		
		if (session.getAttribute("admin") != null) {
			session.removeAttribute("admin");
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
