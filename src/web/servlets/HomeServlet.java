package web.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.dao.Implementations.RoleDao;
import metier.dao.beans.Role;


@WebServlet("/Home")
public class HomeServlet extends HttpServlet {
	
	
	private static final String VUE            = "/WEB-INF/Home.jsp";
	RoleDao roledao                            = RoleDao.getInstance();
	List<Role> roles                           = new ArrayList<Role>();
    
    @Override
    public void init() throws ServletException {
    	roles = roledao.getAll();
    	if (roles.size() == 0) {
    		AjouterLesRoles("admin","desc");
    		AjouterLesRoles("docteur","desc");
    		AjouterLesRoles("clinique","desc");
    		AjouterLesRoles("utiliseur","desc");
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

}
