package web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.dao.Implementations.CabinetDao;
import metier.dao.Implementations.CommentaireDao;
import metier.dao.beans.Cabinet;
import metier.dao.beans.Commentaire;
import metier.services.CommentaireImpl;

@WebServlet("/commentaireForm")
public class commentaireFormServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private static final String CHAMP_COMMENTAIRE = "comments";
	
    public commentaireFormServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String commentaire = request.getParameter(CHAMP_COMMENTAIRE);
		
		HttpSession session = request.getSession();
		
		System.out.println("from commentaire navigation ----->"  + session.getAttribute("cab"));
		
		Cabinet c = (Cabinet) session.getAttribute("cab");
		
		CommentaireDao dao = CommentaireDao.getInstance();
		CabinetDao cabinet_dao = CabinetDao.getInsctance();
		
		CommentaireImpl cmtsImpl = CommentaireImpl.getInstance();
		Commentaire commenatire = new Commentaire();

		commenatire.setCabinet(cabinet_dao.getById(c.getIdProfil()));
		commenatire.setCommentaire(commentaire);
		
		dao.add(commenatire);
		
		List<Commentaire> cmts = cmtsImpl.getCommentsByCabinet(c);
		
		request.setAttribute("lescommentaires", cmts );
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Cabinet.jsp").forward(request, response);
		
	}

}
