package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CarrelloBean;
import model.ProductBean;

/**
 * Servlet implementation class RemoveFromCartServlet
 */
@WebServlet("/RemoveFromCartServlet")
public class RemoveFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CarrelloBean carrello =(CarrelloBean)request.getSession().getAttribute("carrello");
		String pos = request.getParameter("posProdo");
		int p = Integer.parseInt(pos);
		carrello.getCarrello().remove(p);
	    if(carrello.getCarrello().size()>0) {
	    	response.sendRedirect("Carrello.jsp");
	    	
	    }
	    else {
	    	request.getSession().removeAttribute("carrello");
	    	response.sendRedirect("Carrello.jsp");
	    	
	    }
		
		
	}

}
