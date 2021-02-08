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
import metier.dao.beans.Commentaire;
import metier.dao.beans.Docteur;
import metier.dao.beans.User;
import metier.services.CommentaireImpl;
import metier.services.DocteurImpl;

@WebServlet("/addComment")
public class addCommentServlet extends HttpServlet {

	private static final String VUE = "/WEB-INF/doctorProfile.jsp";
	private static final String COMMENT = "userOwnComment";
	DocteurDao docteurDao = DocteurDao.getInstance();
	DocteurImpl docteurImpl = DocteurImpl.getInstance();
	Map<String , String > donnees_doctor = new HashMap<String, String>();
	
	
	CommentaireDao commentDao = CommentaireDao.getInstance();
	User user = new User();
	
	UserDao userDao = UserDao.getInstance();
	
	public addCommentServlet() {
        super();
    }
	
	Docteur docteur = new Docteur();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Long id = (Long) session.getAttribute("testSession");
		user = (User) session.getAttribute("visiter");
		docteur = docteurDao.getById(id);
		donnees_doctor = docteurImpl.displayDataInProfilePage(docteur);
		request.setAttribute("data", donnees_doctor);
		request.setAttribute("doctor", docteur);
		request.setAttribute("image", Base64.getEncoder().encodeToString(docteur.getProfile_image()));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		String commentaire = request.getParameter(COMMENT);
		Commentaire comment = new Commentaire();
		comment.setCommentaire(commentaire);
		comment.setUser(user);
		comment.setDocteur(docteur);
		commentDao.add(comment);
		CommentaireImpl commentImpl = CommentaireImpl.getInstance();
		List<Commentaire> lcomments = commentImpl.getCommentsByDocteur(docteur);
		request.setAttribute("comments", lcomments);
		
		this.getServletContext().getRequestDispatcher( VUE ).forward(request, response);
	}

}
