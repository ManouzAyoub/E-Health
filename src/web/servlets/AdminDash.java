package web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.dao.beans.Docteur;
import metier.services.DocteurImpl;

@WebServlet("/adminDash")
public class AdminDash extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DocteurImpl docimpl=DocteurImpl.getInstance();
	public static final String VUE              = "/WEB-INF/AdminDashboard.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Docteur> docs=docimpl.getDoctorsAccordingToTheirAvailability(false);
		request.setAttribute("docs", docs);
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
