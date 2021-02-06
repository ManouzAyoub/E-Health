package web.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.dao.beans.Docteur;
import metier.services.DocteurImpl;

@WebServlet(name="searchDoctor", urlPatterns = "/searchDoctor")
public class searchDoctorServlet extends HttpServlet {
	
	public static final String VUE               = "/WEB-INF/searchDoctor.jsp";
	public static final String ATT_DOCTORS       = "doctors";
	private Map<Long, List<String>> data_doctors = new HashMap<Long	, List<String>>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("from servlet search doctor ");
		
		DocteurImpl docteurImpl = DocteurImpl.getInstance();
		
		List<Docteur> allDoctors = docteurImpl.getDoctorsAccordingToTheirAvailability(true);
		
		data_doctors = docteurImpl.displayDoctorsInPage(allDoctors);
		
		request.setAttribute(ATT_DOCTORS, data_doctors);
		
		this.getServletContext().getRequestDispatcher( VUE ).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
