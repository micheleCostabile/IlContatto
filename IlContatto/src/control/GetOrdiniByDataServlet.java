package control;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ClienteDAO;
import model.OrdineBean;
import model.ProductBean;

/**
 * Servlet implementation class GetOrdiniByDataServlet
 */
@WebServlet("/GetOrdiniByDataServlet")
public class GetOrdiniByDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Date from = Date.valueOf(request.getParameter("da"));
		Date to = Date.valueOf(request.getParameter("a"));
		
		
		ClienteDAO check= new ClienteDAO();
		ArrayList<OrdineBean> listaORD = new ArrayList<OrdineBean>();
		try {
			
		 	listaORD=check.getOrdiniByData(from,to);
		 	if(listaORD.isEmpty()) {
		 								request.setAttribute("vuota", true);
		 								RequestDispatcher view = request.getRequestDispatcher("Protected.jsp");
		 								view.forward(request, response);
		 	}
		 	else {		
		 				request.setAttribute("listaORD", listaORD);
		 				RequestDispatcher view = request.getRequestDispatcher("Protected.jsp");
		 				view.forward(request, response);
		 	}
			
		} 
        
        catch (Exception e) {
			e.printStackTrace();
		}
		
		
	
}
		
		
	}


