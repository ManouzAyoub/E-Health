package web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.dao.beans.User;
import metier.dao.util.Instances;


@WebServlet("/UserProfile")
public class UserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User user = new User();
		if ( session.getAttribute("visiter") != null) {
			user = (User) session.getAttribute("visiter");
			request.setAttribute("user", user);
			this.getServletContext().getRequestDispatcher("/WEB-INF/profileUser.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String telephone = request.getParameter("tel");
		String email = request.getParameter("email");
		String new_pass = request.getParameter("new_pass");
		String last_pass = request.getParameter("last_pass");
		String confirmation = request.getParameter("confirmation");
		
		HttpSession session = request.getSession(false);
		
		if (session.getAttribute("visiter") != null) {
			User user = Instances.signInService.VerifyUser(email, last_pass);
			
			if (user != null) {
				if (new_pass.equals(confirmation)) {
					user.setFirstname(prenom);
					user.setLastname(nom);
					user.setPassword(new_pass);
					user.setTel(telephone);
					User u = Instances.userDao.edit(user);
					request.setAttribute("user", u);
					session.setAttribute("visiter", u);
					response.sendRedirect(request.getContextPath() + "/UserProfile");
				}
			} else {
				request.setAttribute("user", session.getAttribute("visiter"));
				response.sendRedirect(request.getContextPath() + "/UserProfile");
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/Home");
		}
	}

}
