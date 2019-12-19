package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ClienteDAO;

/**
 * Servlet implementation class AddWishCardServlet
 */
@WebServlet("/AddWishCardServlet")
public class AddWishCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddWishCardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codi = Integer.parseInt(request.getParameter("codiceWish")); //codProdotto
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
