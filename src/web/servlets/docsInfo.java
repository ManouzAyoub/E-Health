package web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.dao.Implementations.DocteurDao;
import metier.dao.beans.Docteur;

@WebServlet("/docsInfo")
public class docsInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DocteurDao docdao=DocteurDao.getInstance();
	public static final String VUE              = "/WEB-INF/docsInfo.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		Docteur doc=docdao.getById(Long.valueOf(id));
		request.setAttribute("doc", doc);
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
            
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
	}

}
