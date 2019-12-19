package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ClienteBean;
import model.ClienteDAO;




@SuppressWarnings("serial")
@WebServlet("/servletCambioPassword")


	
		

public class ServletCambioPassword extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request,response);
		
	}	
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pwdV = request.getParameter("passwordVecchia").trim();
		String pwdN = request.getParameter("passwordNuova").trim();
		String ut= (String)request.getSession().getAttribute("user");
		String attuale= (String)request.getSession().getAttribute("pw");
	
		if(pwdV.equals(attuale))
		{
			request.getSession().setAttribute("pw",pwdN);
			
			try {
				ClienteDAO check = new ClienteDAO();
				check.cambioPass(ut,pwdN);
			} catch (SQLException e) {
				e.printStackTrace();
				e.getMessage();
			}

				response.getWriter().println("Password cambiata con successo.");
		
		}
		else 
		{
			response.getWriter().println("Impossibile cambiare la password, hai sbagliato l'attuale.");
		}
	  }
}