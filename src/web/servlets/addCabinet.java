package web.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.dao.Implementations.CabinetDao;
import metier.dao.Implementations.DocteurDao;
import metier.dao.beans.Cabinet;

@WebServlet("/addCabinet")
public class addCabinet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public static final String VUE              = "/WEB-INF/addCabinet.jsp";
	public static final String CHAMP_NAME = "name";
	public static final String CHAMP_ADRESSE = "adresse";
	public static final String ATT_CABINETS = "c";
    
    public addCabinet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( VUE ).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recuperer les données //
		String adresse = request.getParameter(CHAMP_ADRESSE);
		String name = request.getParameter(CHAMP_NAME);
		
		
		Cabinet cabinet = new Cabinet();
		DocteurDao dao = DocteurDao.getInstance();
		CabinetDao dao_cabinet = CabinetDao.getInsctance();
		
		cabinet.setAdresse(adresse);
		cabinet.setName(name);
		cabinet.setDocteur(dao.getById(1L));
		
		// Ajouter un cabinet
		Cabinet test = dao_cabinet.add(cabinet);
		
		// get All cabinet
		List<Cabinet> cbnts = dao_cabinet.getAll();
		
		request.setAttribute(ATT_CABINETS, cbnts );
		this.getServletContext().getRequestDispatcher( "/WEB-INF/affichage.jsp" ).forward(request, response);
		
	}

}
