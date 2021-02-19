package web.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.dao.beans.Clinique;
import metier.dao.beans.Docteur;
import metier.dao.util.Instances;

/**
 * Servlet implementation class cliniqueAssociation
 */
@WebServlet("/cliniqueAssociation")
public class cliniqueAssociation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cliniqueAssociation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String idDocteur = request.getParameter("id");
		Docteur doc = Instances.docteurDao.getById(Long.valueOf(idDocteur));
		
		
		String idClinique = request.getParameter("idClinique");
		Clinique clinique = Instances.cliniqueDao.getById(Long.valueOf(idClinique));
		List<Docteur> docteurs = clinique.getDocteurs();
		docteurs.add(doc);
		clinique.setDocteurs(docteurs);
		
		Clinique clinic = Instances.cliniqueDao.edit(clinique);
		HttpSession session = request.getSession(false);
		session.setAttribute("clinique", clinic);
		
		this.getServletContext().getRequestDispatcher("/DataClinique").forward(request, response);
	}

}
