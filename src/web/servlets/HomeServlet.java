package web.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.dao.Implementations.LangueDao;
import metier.dao.Implementations.RoleDao;
import metier.dao.beans.Langue;
import metier.dao.beans.Role;


@WebServlet("/Home")
public class HomeServlet extends HttpServlet {
	
	
	private static final String VUE            = "/WEB-INF/Home.jsp";
	RoleDao roledao                            = RoleDao.getInstance();
	LangueDao langueDao 					   = LangueDao.getInsctance(); 
	List<Role> roles                           = new ArrayList<Role>();
	String[] langues						   = {"Arabic" , "Frensh", "English", "Chinese", "Spanish" };
    
    @Override
    public void init() throws ServletException {
    	roles = roledao.getAll();
    	if (roles.size() == 0) {
    		AjouterLesRoles("admin","desc");
    		AjouterLesRoles("docteur","desc");
    		AjouterLesRoles("clinique","desc");
    		AjouterLesRoles("utiliseur","desc");
		}
    	List<Langue> languages = langueDao.getAll();
    	if (languages.size() == 0) {
			AjouterLangues(langues);
		}
    	super.init();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
	public void AjouterLesRoles(String role , String description) {
		Role r = new Role();
		r.setDescription(description);
		r.setRole(role);
		roledao.add(r);
	}
	
	public void AjouterLangues(String[] langues) {
		for (int i = 0; i < langues.length; i++) {
			Langue langue = new Langue();
			langue.setLangue(langues[i]);
			langueDao.add(langue);
		}
	}

}
