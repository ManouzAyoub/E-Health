package web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.dao.beans.Clinique;
import metier.dao.util.Instances;

@WebServlet("/InformationClinique")
public class InformationCliniqueFormServlet extends HttpServlet {
	
	private static final String CHAMP_NAME = "nom";
	private static final String CHAMP_ADRESSE = "adresse";
	private static final String CHAMP_EMAIL = "email";
	private static final String CHAMP_TEL = "tel";
	private static final String CHAMP_DESC = "desc";
	private static final String CHAMP_TEL_URGENCE = "urgence";
	private static final String CHAMP_SPECIALITY = "speciality";
	private static final String CHAMP_ID = "id";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter(CHAMP_NAME);
		String adresse = request.getParameter(CHAMP_ADRESSE);
		String tel = request.getParameter(CHAMP_TEL);
		String tel_urgence = request.getParameter(CHAMP_TEL_URGENCE);
		String speciality = request.getParameter(CHAMP_SPECIALITY);
		String description = request.getParameter(CHAMP_DESC);
		String email = request.getParameter(CHAMP_EMAIL);
		String id = request.getParameter(CHAMP_ID);
		
		Clinique clinique = Instances.cliniqueDao.getById(Long.valueOf(id));
		System.out.println(clinique.toString());
		clinique.setAdresse(adresse);
		clinique.setName(name);
		clinique.setAdresse(adresse);
		clinique.setSpeciality(speciality);
		clinique.setDescription(description);
		clinique.setTel(tel);
		clinique.setEmergency_tel(tel_urgence);
		Clinique  c = new Clinique();
		if (clinique.getFirst_using()) {
			c = Instances.cliniqueDao.edit(clinique);
		}else {
			clinique.setFirst_using(true);
			clinique.setDispo(true);
			c = Instances.cliniqueDao.edit(clinique);
		}
		
		
		
		HttpSession session = request.getSession(false);
		session.setAttribute("clinique", c);
		
		this.getServletContext().getRequestDispatcher("/DataClinique").forward(request, response);
	}
	

}

