package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ClienteBean;
import model.ClienteDAO;
import model.ProductBean;
import model.ProductDAO;

/**
 * Servlet implementation class WishServlet
 */
@WebServlet("/AddWishServlet")
public class AddWishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddWishServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codi = (Integer)request.getSession().getAttribute("codiceWish"); //codProdotto
		String user = (String) request.getSession().getAttribute("user");

		ClienteDAO check2 = new ClienteDAO();
		
		try {
	
		 	check2.insertPref(user,codi);
		 
		} 
        
        catch (Exception e) {
			e.printStackTrace();
		}
	
}
	}


