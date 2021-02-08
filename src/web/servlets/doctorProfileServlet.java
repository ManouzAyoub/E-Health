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
import metier.dao.beans.Clinique;
import metier.dao.beans.Commentaire;
import metier.dao.beans.Docteur;
import metier.dao.beans.Hopital;
import metier.services.CommentaireImpl;
import metier.services.DocteurImpl;
import metier.services.EducationImpl;
import metier.services.RatingImpl;
import metier.services.RecompenseImpl;

@WebServlet("/doctorProfile")
public class doctorProfileServlet extends HttpServlet {
	
	DocteurDao docteurDao   = DocteurDao.getInstance();
	DocteurImpl docteurImpl = DocteurImpl.getInstance();
	RatingImpl ratingImpl   = RatingImpl.getInstance();
	Map<Integer , Long> map = new HashMap<Integer, Long>();
	
	private static final String VUE = "/WEB-INF/doctorProfile.jsp"; 
	Map<String, String> donnees_doctor = new HashMap<String, String>();
	EducationImpl educImpl = EducationImpl.getInstance();
	RecompenseImpl recomImpl = RecompenseImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Long id = (Long) session.getAttribute("testSession");
		Docteur docteur = docteurDao.getById(id);		
		map = ratingImpl.countDistinctValueOfRate(docteur);
		donnees_doctor = docteurImpl.displayDataInProfilePage(docteur);
		request.setAttribute("data", donnees_doctor);
		List<Clinique> lc = docteur.getCliniques();
		List<Hopital> lh = docteur.getHopitales();
		request.setAttribute("doctor", docteur);
		request.setAttribute("hopitaux", lh);
		request.setAttribute("cliniques", lc);
		request.setAttribute("image", Base64.getEncoder().encodeToString(docteur.getProfile_image()));
		CommentaireImpl commentImpl = CommentaireImpl.getInstance();
		List<Commentaire> lcomments = commentImpl.getCommentsByDocteur(docteur);
		request.setAttribute("comments", lcomments);
		request.setAttribute("evaluations", map );
		request.setAttribute("nbrRating", ratingImpl.getNumberOfRatingByDoctor(docteur));
		request.setAttribute("average", ratingImpl.average(docteur));
		request.setAttribute("nbr", ratingImpl.getAverageOfRatingByDoctor(docteur));
		request.setAttribute("recompenses", recomImpl.getRecompenseByDoctor(docteur));
		request.setAttribute("educations", educImpl.getEducationByDoctor(docteur));
		this.getServletContext().getRequestDispatcher( VUE ).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
