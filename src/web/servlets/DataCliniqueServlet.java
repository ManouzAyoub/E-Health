package web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.dao.beans.Clinique;
import metier.dao.beans.Commentaire;
import metier.dao.beans.Docteur;
import metier.dao.util.Instances;

@WebServlet("/DataClinique")
public class DataCliniqueServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Clinique clinique = (Clinique) session.getAttribute("clinique");
		
		List<Docteur> docteurs = clinique.getDocteurs();
		request.setAttribute("nbrDoctors", docteurs.size());
		
		List<Commentaire> comments = Instances.commentImpl.getComments(clinique.getCin(), "idClinique");
		request.setAttribute("comments", comments);
		
		request.setAttribute("doctors", docteurs);
	}

}
