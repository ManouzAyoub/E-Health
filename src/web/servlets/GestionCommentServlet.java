package web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.dao.Implementations.CommentaireDao;
import metier.dao.Implementations.DocteurDao;
import metier.dao.beans.Commentaire;
import metier.dao.util.Instances;
import metier.services.CliniqueImpl;
import metier.services.CommentaireImpl;
import metier.services.DocteurImpl;
import metier.services.UserImpl;

@WebServlet("/GestionComment")
public class GestionCommentServlet extends HttpServlet {
	
	private static final String CHAMP_APPROVE = "apprv";
	private static final String CHAMP_DELETE  = "dlte";
	private static final String VUE  = "/WEB-INF/AdminDashboard.jsp";
	
	
	CommentaireDao commentaireDao = CommentaireDao.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Commentaire commentaire = new Commentaire();
		String approve = request.getParameter(CHAMP_APPROVE);
		String delete  = request.getParameter(CHAMP_DELETE);
		
		if (approve != null) {
			commentaire = commentaireDao.getById(Long.valueOf(approve));
			commentaire.setApprov(true);
			commentaireDao.edit(commentaire);
		}
		
		if (delete != null) {
			commentaire = commentaireDao.getById(Long.valueOf(delete));
			commentaire.setDel(true);
			commentaireDao.edit(commentaire);
		}
		
		List<Commentaire> comments = Instances.commentImpl.getCommentsNotApproved(false, false);
		request.setAttribute("comments", comments);
		request.setAttribute("clinics", Instances.cliniqueImpl.getAllClinicsAccordingToTheirAvailability( false ));
		request.setAttribute("docs", Instances.docteurImpl.getDoctorsAccordingToTheirAvailability(false));
		request.setAttribute("nbrUsers", Instances.userImpl.getNumbersOfUser("User") != null ? Instances.userImpl.getNumbersOfUser("User") : 0 );
		request.setAttribute("nbrDoctors", Instances.userImpl.getNumbersOfUser("Docteur") != null ? Instances.userImpl.getNumbersOfUser("Docteur") : 0  );
		request.setAttribute("nbrPharmacies", Instances.userImpl.getNumbersOfUser("Pharmacie") != null ? Instances.userImpl.getNumbersOfUser("Pharmacie") : 0 );
		request.setAttribute("nbrClinics", Instances.userImpl.getNumbersOfUser("Clinique") != null ? Instances.userImpl.getNumbersOfUser("Clinique") : 0  );
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
