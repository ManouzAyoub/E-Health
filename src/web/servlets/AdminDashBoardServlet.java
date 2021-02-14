package web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.dao.beans.Docteur;
import metier.dao.util.Instances;
import metier.services.DocteurImpl;

@WebServlet("/adminDash")
public class AdminDashBoardServlet extends HttpServlet {
	
	public static final String VUE              = "/WEB-INF/AdminDashboard.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// retourner les docteur qui nous sont pas encore confirmer
		List<Docteur> docs =	Instances.docteurImpl.getDoctorsAccordingToTheirAvailability(false);
		
		request.setAttribute("docs", docs);
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
