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

import metier.dao.beans.Langue;
import metier.dao.beans.Role;
import metier.dao.beans.User;
import metier.dao.util.Instances;


@WebServlet("/Home")
public class HomeServlet extends HttpServlet {
	
	
	private static final String VUE            = "/WEB-INF/Home.jsp";
	List<Role> roles                           = new ArrayList<Role>();
	String[] langues						   = {"Arabic" , "Frensh", "English", "Chinese", "Spanish" };
    
    @Override
    public void init() throws ServletException {
    	roles = Instances.roleDao.getAll();
    	if (roles.size() == 0) {
    		AjouterLesRoles("admin","desc");
    		AjouterLesRoles("docteur","desc");
    		AjouterLesRoles("clinique","desc");
    		AjouterLesRoles("utilisateur","desc");
		}
    	List<Langue> languages = Instances.langueDao.getAll();
    	if (languages.size() == 0) {
			AjouterLangues(langues);
		}
    	
    	if ( Instances.userDao.getAll().size() == 0 ) {
			AjouterAdmin();
		}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
//		if ( session.getAttribute("admin") != null ) {
//			response.sendRedirect(request.getContextPath() + "/toAdminData");
//		}
//		else {
//			this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
//		}
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void AjouterLesRoles(String role , String description) {
		Role r = new Role();
		r.setDescription(description);
		r.setRole(role);
		Instances.roleDao.add(r);
	}
	
	public void AjouterLangues(String[] langues) {
		for (int i = 0; i < langues.length; i++) {
			Langue langue = new Langue();
			langue.setLangue(langues[i]);
			Instances.langueDao.add(langue);
		}
	}
	
	public void AjouterAdmin() {
		User user = new User();
		Role role = Instances.roleDao.getById(1);
		user.setEmail("admin@gmail.com");
		user.setFirstname("youssef");
		user.setLastname("el gourari");
		user.setPassword("admin");
		user.setRole(role);
		Instances.userDao.add(user);
	}

}
