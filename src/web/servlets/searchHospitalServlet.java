package web.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.dao.beans.Hopital;
import metier.services.HopitalImpl;
import metier.services.RatingImpl;

@WebServlet("/searchHospital")
public class searchHospitalServlet extends HttpServlet {

	private static final String VUE = "/WEB-INF/searchHospital.jsp";
	private static final String HOME = "/WEB-INF/Home.jsp";
	private static final String CHAMP_RECHERCHE = "adresse";
	HopitalImpl hopitalImpl = HopitalImpl.getInstance();
	RatingImpl ratingImpl = RatingImpl.getInstance();
	List<Hopital> hospitals = new ArrayList<Hopital>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adresse = request.getParameter(CHAMP_RECHERCHE);
		
		hospitals = hopitalImpl.getAllHospitalsAccordingToTheirAvailabilityAndAdress(adresse);
		
		if (hospitals != null) {
			request.setAttribute("hospitals", hospitals);
			request.setAttribute("impl", ratingImpl);
			this.getServletContext().getRequestDispatcher( VUE ).forward(request, response);
		}else {
			request.setAttribute("hospitals", hospitals);
			request.setAttribute("impl", ratingImpl);
			this.getServletContext().getRequestDispatcher( VUE ).forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
