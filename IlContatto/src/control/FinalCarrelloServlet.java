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
 * Servlet implementation class FinalCarrelloServlet
 */
@WebServlet("/FinalCarrelloServlet")
public class FinalCarrelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String qty = request.getParameter("num");
		String idx = request.getParameter("indice");
		String tot = request.getParameter("tot");
		float t = Float.parseFloat(tot);
		int q = Integer.parseInt(qty);
		int i = Integer.parseInt(idx);
		CarrelloBean carrello =(CarrelloBean)request.getSession().getAttribute("carrello");
		
		carrello.getCarrello().get(i).setQty(q);
		carrello.getCarrello().get(i).setSub(carrello.getCarrello().get(i).getPrezzo()*q);
		request.getSession().setAttribute("carrello", carrello);
		request.getSession().setAttribute("totale", t);
		
		
		
		
		
		
	}

}
