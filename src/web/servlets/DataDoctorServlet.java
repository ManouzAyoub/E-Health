package web.servlets;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.dao.beans.Clinique;
import metier.dao.beans.Commentaire;
import metier.dao.beans.Docteur;
import metier.dao.beans.Education;
import metier.dao.beans.Hopital;
import metier.dao.beans.Recomponse;
import metier.dao.util.Instances;

@WebServlet("/DataDoctor")
public class DataDoctorServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		Docteur docteur = (Docteur) session.getAttribute("docteur");
		List<Commentaire> comments = Instances.commentImpl.getComments(docteur.getCin(), "idDocteur");
		Long numbersOfComments = Instances.commentImpl.getNumbersOfComments(docteur.getCin(), "idDocteur");
		Long numberOfRating = Instances.ratingImpl.getNumberOfRating(docteur.getCin(), "idDocteur");
		int averageOfRating = Instances.ratingImpl.getAverageOfRating(docteur.getCin(), "idDocteur");
		Double average = Instances.ratingImpl.average(docteur.getCin(), "idDocteur");
		Map<Integer,Long> map = Instances.ratingImpl.countDistinctValueOfRate(docteur.getCin(), "idDocteur");
		request.setAttribute("cliniques", docteur.getCliniques());
		request.setAttribute("hopitaux", docteur.getHopitales());
		request.setAttribute("commentaires", comments);
		request.setAttribute("nbrsOfComments", numbersOfComments != null ? numbersOfComments : 0);
		request.setAttribute("docteur", docteur);
		request.setAttribute("image", Base64.getEncoder().encodeToString(docteur.getProfile_image()));
		List<Education> educations = Instances.educImpl.getEducationByDoctor(docteur);
		List<Recomponse> recompences = Instances.recomImpl.getRecompenseByDoctor(docteur);
		request.setAttribute("educations", educations);
		request.setAttribute("recompences", recompences);
		//rating section
		
		/*
		 * Number Of Associations || besoin d'une function apres
		 */
		List<Clinique> clques = docteur.getCliniques();
		List<Hopital> hles = docteur.getHopitales();
		int nbrAssociation = clques.size() + hles.size();
		request.setAttribute("nbrAssociation", nbrAssociation );
		request.setAttribute("DistinctValue", map);
		request.setAttribute("numberOfRating", numberOfRating != null ? numberOfRating : 0);
		request.setAttribute("averageOfRating", averageOfRating );
		request.setAttribute("average", average);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/DocteurDashboard.jsp").forward(request, response);
	}

}
