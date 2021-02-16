package web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.dao.beans.Docteur;
import metier.dao.util.Instances;


@WebServlet("/ChangeLocalisation")
public class ChangeLocalisationServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String localisation = request.getParameter("place_id");
		String id = request.getParameter("id");
		
		Docteur docteur = Instances.docteurDao.getById(Long.valueOf(id));
		
		docteur.setId(localisation);
		
		Docteur d = Instances.docteurDao.edit(docteur);
		
		HttpSession session = request.getSession(false);
		session.setAttribute("docteur", d);
		this.getServletContext().getRequestDispatcher("/DataDoctor").forward(request, response);
	}

}
