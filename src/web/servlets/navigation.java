package web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/navigation")
public class navigation extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cabinet = request.getParameter( "cabinet" );
		System.out.println(" from navigation -----> " + cabinet);
		request.setAttribute("allez", cabinet);
		HttpSession session = request.getSession();
		session.setAttribute("cab", cabinet);
		this.getServletContext().getRequestDispatcher("/WEB-INF/Cabinet.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
