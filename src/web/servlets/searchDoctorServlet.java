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

import metier.dao.Implementations.DocteurDao;
import metier.dao.beans.Docteur;
import metier.services.DocteurImpl;
import metier.services.RoleImpl;

@WebServlet(name="searchDoctor", urlPatterns = "/searchDoctor")
public class searchDoctorServlet extends HttpServlet {
	
	public static final String SUCESS               = "/WEB-INF/searchDoctor.jsp";
	public static final String VUE                  = "/WEB-INF/Home.jsp";
	public static final String ATT_DOCTORS          = "doctors";
	private static final String CHAMP_RECHERCHER    = "localisation";
	private Map<Long, List<String>> data_doctors    = new HashMap<Long	, List<String>>();
	DocteurDao docteurDao = DocteurDao.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String adresse           = request.getParameter(CHAMP_RECHERCHER);

		DocteurImpl docteurImpl  = DocteurImpl.getInstance();
		
		RoleImpl roleimpl = RoleImpl.getInstance();
		
		List<Docteur> allDoctors = docteurImpl.getDoctorsByYourAdress(adresse,true);
		
		if(!allDoctors.isEmpty()) {
			for(Docteur all : allDoctors) {
				System.out.println("---- * ---- : " + all.getFirstname());
			}
			data_doctors = docteurImpl.displayDoctorsInPage(allDoctors);
			
			request.setAttribute(ATT_DOCTORS, data_doctors);
			request.setAttribute("docteurDao", docteurDao);
			this.getServletContext().getRequestDispatcher( SUCESS ).forward(request, response);
		}else {
			System.out.println("n'existe pas");
			this.getServletContext().getRequestDispatcher( VUE ).forward(request, response);
		}
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
