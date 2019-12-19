package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductBean;
import model.ProductDAO;

@WebServlet("/CercaServlet")
public class CercaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String search = (String) request.getParameter("barra");
		
		ProductDAO check = new ProductDAO();
		ArrayList <ProductBean> res= new ArrayList <ProductBean>();
		 try {
				
			 	res= check.searchBar(search);
				request.getSession().setAttribute("result", res);
			
				RequestDispatcher view = request.getRequestDispatcher("SearchResult.jsp");
		        view.forward(request, response);
				
			} 
	        
	        catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}


