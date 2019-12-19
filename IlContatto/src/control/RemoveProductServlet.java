package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductDAO;

@WebServlet("/RemoveProductServlet")

public class RemoveProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codice = Integer.parseInt(request.getParameter("prodcode"));
		
		ProductDAO access = new ProductDAO();
		
		
		try {
			access.deleteProduct(codice);
			RequestDispatcher view = request.getRequestDispatcher("Protected.jsp");
			view.forward(request,response);
			
		} 
		
		catch (SQLException e) {
			
			e.printStackTrace();
		}
			
	}
	
	
	
}


