package web.servlets;

import java.io.IOException;
import java.util.Base64;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.dao.Implementations.DocteurDao;
import metier.dao.beans.Docteur;
import metier.services.DocteurImpl;

@WebServlet("/doctorProfile")
public class doctorProfileServlet extends HttpServlet {
	
	DocteurDao docteurDao = DocteurDao.getInstance();
	DocteurImpl docteurImpl = DocteurImpl.getInstance();
	
	private static final String VUE = "/WEB-INF/doctorProfile.jsp"; 
	Map<String, String> donnees_doctor = new HashMap<String, String>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Long id = (Long) session.getAttribute("testSession");
		Docteur docteur = docteurDao.getById(id);
		donnees_doctor = docteurImpl.displayDataInProfilePage(docteur);
		request.setAttribute("data", donnees_doctor);
		request.setAttribute("doctor", docteur);
		request.setAttribute("image", Base64.getEncoder().encodeToString(docteur.getProfile_image()));
		this.getServletContext().getRequestDispatcher( VUE ).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
