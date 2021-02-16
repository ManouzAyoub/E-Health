package web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.dao.Implementations.DocteurDao;
import metier.dao.beans.Docteur;
import metier.dao.util.Instances;

@WebServlet("/docsInfo")
public class DoctorInfoConfirmation extends HttpServlet {
	
	public static final String VUE              = "/WEB-INF/docsInfo.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		Docteur doc= Instances.docteurDao.getById(Long.valueOf(id));
		request.setAttribute("doc", doc);
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
            
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
	}

}
