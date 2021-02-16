package web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.dao.beans.Docteur;
import metier.dao.beans.Education;
import metier.dao.util.Instances;

@WebServlet("/EducationForm")
public class EducationFormServlet extends HttpServlet {
	
	private static final String CHAMP_DATE = "anneeDiplome";
	private static final String CHAMP_DIPLOME = "nomDiplome";
	private static final String CHAMP_ETABLISSEMENT = "etablissementDiplome";
	private static final String CHAMP_DOCTEUR = "doc";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String etablissement = request.getParameter(CHAMP_ETABLISSEMENT);
		String diplome = request.getParameter(CHAMP_DIPLOME);
		String date = request.getParameter(CHAMP_DATE);
		String doc = request.getParameter(CHAMP_DOCTEUR);
		
		Education education = new Education();
		Docteur docteur = Instances.docteurDao.getById(Long.valueOf(doc));
		education.setAnneeEduc(date);
		education.setEducation(etablissement);
		education.setDescEduc(diplome);
		education.setDocteur(docteur);
		
		Instances.educDao.add(education);
		HttpSession session = request.getSession(false);
		session.setAttribute("docteur", docteur);
		
		this.getServletContext().getRequestDispatcher("/DataDoctor").forward(request, response);
		
	}

}
