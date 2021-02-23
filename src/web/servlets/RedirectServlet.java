package web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


<<<<<<< HEAD
@WebServlet("/aa")
=======
@WebServlet("/lldf")
>>>>>>> de47e0058861b3573f515933bebff237e51bd763
public class RedirectServlet extends HttpServlet {
	
	
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect( request.getContextPath() + "/Home");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
