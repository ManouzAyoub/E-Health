package web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.dao.beans.Docteur;
import metier.dao.beans.Pharmacie;
import metier.dao.util.Instances;

@WebServlet("/ToggleGarde")
public class ToggleGarde extends HttpServlet {
	
    public static final String VUE              = "/toAdminData";


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
      
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String id = request.getParameter("idd");
	       String checkbox=request.getParameter("checkgarde");
	       Pharmacie pharmacie= Instances.pharmacieDao.getById(Long.valueOf(id));
	       if(checkbox!=null) {
	    	   System.out.println("true");
	    	   pharmacie.setEn_garde(true);
	       }
	       else{
	    	  System.out.println("false");
	    	  pharmacie.setEn_garde(false); 
	       }
	       Pharmacie pharmaci = Instances.pharmacieDao.edit(pharmacie);
	       
	       this.getServletContext().getRequestDispatcher( "/toAdminData" ).forward( request, response );
	}

}
