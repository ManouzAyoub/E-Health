package web.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import metier.dao.beans.Docteur;
import metier.dao.util.Instances;

@WebServlet("/ChangeImageDoctor")
public class ChangeImageDoctorServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("d");
		Part part = request.getPart("image");
		
		Docteur docteur = Instances.docteurDao.getById(Long.valueOf(id));
		System.out.println(docteur.toString());
		
		InputStream inputStream = null;
		byte[] bite = null;
		
		inputStream = part.getInputStream();
		bite = convert(inputStream);
		
		docteur.setProfile_image(bite);
		
		Docteur d = Instances.docteurDao.edit(docteur);
		HttpSession session = request.getSession(false);
		
		session.setAttribute("docteur", d);
		this.getServletContext().getRequestDispatcher("/DataDoctor").forward(request, response);
	}
	
	private byte[] convert(InputStream inputstream) throws IOException {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		int nRead;
		byte[] data = new byte[16384];

		while ((nRead = inputstream.read(data, 0, data.length)) != -1) {
		  buffer.write(data, 0, nRead);
		}

		return buffer.toByteArray();
    }

}