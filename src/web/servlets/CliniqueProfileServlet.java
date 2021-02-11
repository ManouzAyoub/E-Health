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
import metier.services.CommentaireImpl;
import metier.services.DocteurImpl;
import metier.services.RatingImpl;

@WebServlet("/CliniqueProfile")
public class CliniqueProfileServlet extends HttpServlet {

	private static final String CLINIQUE_PROFILE = "/WEB-INF/cliniqueProfile.jsp";
	RatingImpl ratingImpl                        = RatingImpl.getInstance();
	CommentaireImpl comments                     = CommentaireImpl.getInstance();
	DocteurImpl docteurImpl                      = DocteurImpl.getInstance();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Clinique clinique   = (Clinique) session.getAttribute("DisplayProfileClinique");
		request.setAttribute("clinique", clinique);
		request.setAttribute("docteurImpl", docteurImpl);
		request.setAttribute("progressBar", ratingImpl.getPercentageOfEtoiles(clinique.getCin(), "idClinique"));
		request.setAttribute("nbrRating", ratingImpl.getNumberOfRating(clinique.getCin(), "idClinique"));
		request.setAttribute("average", ratingImpl.average(clinique.getCin(), "idClinique"));
		request.setAttribute("averageRating", ratingImpl.getAverageOfRating(clinique.getCin(), "idClinique"));
		request.setAttribute("distinctValueRating", ratingImpl.countDistinctValueOfRate(clinique.getCin(), "idClinique"));
		request.setAttribute("comments", comments.getComments(clinique.getCin(),"idClinique"));
		request.setAttribute("docteurs", clinique.getDocteurs());
		this.getServletContext().getRequestDispatcher( CLINIQUE_PROFILE ).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
