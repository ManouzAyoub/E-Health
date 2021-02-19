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

import metier.dao.Implementations.CommentaireDao;
import metier.dao.Implementations.DocteurDao;
import metier.dao.Implementations.UserDao;
import metier.dao.beans.Clinique;
import metier.dao.beans.Commentaire;
import metier.dao.beans.Docteur;
import metier.dao.beans.Hopital;
import metier.dao.beans.Langue;
import metier.dao.beans.Rating;
import metier.dao.beans.User;
import metier.dao.util.Instances;
import metier.services.CommentaireImpl;
import metier.services.DocteurImpl;
import metier.services.RatingImpl;

@WebServlet("/addComment")
public class AddCommentServlet extends HttpServlet {

	private static final String VUE_DOCTEUR_PROFILE  = "/WEB-INF/doctorProfile.jsp";
	private static final String VUE_HOPITAL_PROFILE  = "/WEB-INF/hospitalProfile.jsp";
	private static final String VUE_CLINIQUE_PROFILE = "/WEB-INF/cliniqueProfile.jsp";
	private static final String COMMENT_DOCTEUR      = "userOwnComment";
	private static final String COMMENT_HOPITAL      = "comment_hopital";
	private static final String COMMENT_CLINIQUE     = "comment_clinique";
	private static final String RAT_HOPITAL = "ratingStars";
	
	User user                   = new User();
	Docteur docteur             = new Docteur();
	Hopital hopital             = new Hopital();
	Clinique clinique           = new Clinique();
	 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session        = request.getSession(false);
		user                       = (User) session.getAttribute("visiter");
		
		String commentaire         = request.getParameter(COMMENT_DOCTEUR);
		String commentaire_hopital = request.getParameter(COMMENT_HOPITAL);
		String comment_clinique    = request.getParameter(COMMENT_CLINIQUE);
		String[] nbretoilerath = request.getParameterValues(RAT_HOPITAL); 
		int nbr = 0;
		if (nbretoilerath != null) {
			for (int i = 0; i < nbretoilerath.length; i++) {
				if (nbretoilerath[i] != null) {
					nbr = Integer.valueOf(nbretoilerath[0]);
				}
			}
		}
		
		System.out.println("sssss you sssss" + nbr);
		
		// commentaire pour un docteur
		if (commentaire != null) {
			docteur = (Docteur) session.getAttribute("CommentDoctor");
			Rating rating = new Rating();
			rating.setDocteur(docteur);
			rating.setNumberEtoile(nbr);
			rating.setUser(user);
			Instances.ratingDao.add(rating);
			request.setAttribute("data", Instances.docteurImpl.displayDataInProfilePage(docteur));
			request.setAttribute("doctor", docteur);
			request.setAttribute("image", Base64.getEncoder().encodeToString(docteur.getProfile_image()));
			addComment(commentaire, "Docteur", docteur, null, null, user);
			request.setAttribute("comments", Instances.commentImpl.getComments(docteur.getCin(),"idDocteur"));	
			commentaire = null;
			this.getServletContext().getRequestDispatcher( VUE_DOCTEUR_PROFILE ).forward(request, response);
		}
		
		// commentaire pour un hopital
		if (commentaire_hopital != null ) {
			hopital = (Hopital) session.getAttribute("DisplayProfileHospital");
			Rating rating = new Rating();
			rating.setHopital(hopital);
			rating.setNumberEtoile(nbr);
			rating.setUser(user);
			Instances.ratingDao.add(rating);
			addComment(commentaire_hopital, "Hopital", null,  hopital,null, user);
			request.setAttribute("comments", Instances.commentImpl.getComments(hopital.getIdHopital(),"idHopital"));
			request.setAttribute("hopital", hopital);
			request.setAttribute("docteurs", hopital.getDocteurs());
			request.setAttribute("impl", Instances.ratingImpl);
			request.setAttribute("docteurImpl", Instances.docteurImpl);
			request.setAttribute("nbrRating", Instances.ratingImpl.getNumberOfRating(hopital.getIdHopital(), "idHopital"));
			request.setAttribute("average", Instances.ratingImpl.average(hopital.getIdHopital(), "idHopital"));
			request.setAttribute("averageRating", Instances.ratingImpl.getAverageOfRating(hopital.getIdHopital(), "idHopital"));
			request.setAttribute("distinctValueRating", Instances.ratingImpl.countDistinctValueOfRate(hopital.getIdHopital(), "idHopital"));
			this.getServletContext().getRequestDispatcher( VUE_HOPITAL_PROFILE ).forward(request, response);
		}
		
		// commentaire pour un clinique
		if (comment_clinique != null) {
			clinique = (Clinique) session.getAttribute("DisplayProfileClinique");
			Rating rating = new Rating();
			rating.setClinique(clinique);
			rating.setNumberEtoile(nbr);
			rating.setUser(user);
			Instances.ratingDao.add(rating);
			addComment(comment_clinique, "Clinique", null, null, clinique, user);
			request.setAttribute("comments", Instances.commentImpl.getComments(clinique.getCin(),"idClinique"));
			request.setAttribute("clinique", clinique);
			request.setAttribute("docteurs", clinique.getDocteurs());
			request.setAttribute("impl", Instances.ratingImpl);
			request.setAttribute("docteurImpl", Instances.docteurImpl);
			request.setAttribute("nbrRating", Instances.ratingImpl.getNumberOfRating(clinique.getCin(), "idClinique"));
			request.setAttribute("average", Instances.ratingImpl.average(clinique.getCin(), "idClinique"));
			request.setAttribute("averageRating", Instances.ratingImpl.getAverageOfRating(clinique.getCin(), "idClinique"));
			request.setAttribute("distinctValueRating", Instances.ratingImpl.countDistinctValueOfRate(clinique.getCin(), "idClinique"));
			this.getServletContext().getRequestDispatcher( VUE_CLINIQUE_PROFILE ).forward(request, response);
		}
		
		
		
	}

	public void addComment(String comment, String qui, Docteur d, Hopital h, Clinique c, User u) {
		Commentaire commentaire = new Commentaire();
		commentaire.setCommentaire(comment);
		if (qui.equals("Docteur")) {
			commentaire.setDocteur(d);
		}
		if (qui.equals("Hopital")) {
			commentaire.setHopital(h);
		}
		if (qui.equals("Clinique")) {
			commentaire.setClinique(c);
		}
		commentaire.setUser(u);
		Instances.commentDao.add(commentaire);
	}
}
