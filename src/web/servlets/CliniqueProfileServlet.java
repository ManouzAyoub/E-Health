package web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.dao.beans.Clinique;
import metier.dao.beans.Hopital;
import metier.dao.util.Instances;
import metier.services.CommentaireImpl;
import metier.services.DocteurImpl;
import metier.services.RatingImpl;

@WebServlet("/CliniqueProfile")
public class CliniqueProfileServlet extends HttpServlet {

	private static final String CLINIQUE_PROFILE = "/WEB-INF/cliniqueProfile.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// recuperer quel docteur a ete choisi par le client
		HttpSession session = request.getSession(false);
		Clinique clinique   = (Clinique) session.getAttribute("DisplayProfileClinique");

		// Afficher les donnée du docteur choisi dans la page de son profile
		request.setAttribute("clinique", clinique);
		request.setAttribute("docteurImpl", Instances.docteurImpl);
		request.setAttribute("progressBar", Instances.ratingImpl.getPercentageOfEtoiles(clinique.getCin(), "idClinique"));
		request.setAttribute("nbrRating", Instances.ratingImpl.getNumberOfRating(clinique.getCin(), "idClinique"));
		request.setAttribute("average", Instances.ratingImpl.average(clinique.getCin(), "idClinique"));
		request.setAttribute("averageRating", Instances.ratingImpl.getAverageOfRating(clinique.getCin(), "idClinique"));
		request.setAttribute("distinctValueRating", Instances.ratingImpl.countDistinctValueOfRate(clinique.getCin(), "idClinique"));
		request.setAttribute("comments", Instances.commentImpl.getComments(clinique.getCin(),"idClinique"));
		
		request.setAttribute("docteurs", clinique.getDocteurs());
		
		this.getServletContext().getRequestDispatcher( CLINIQUE_PROFILE ).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
