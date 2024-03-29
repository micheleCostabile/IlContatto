package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ClienteDAO;

/**
 * Servlet implementation class RemoveFromWishServlet
 */
@WebServlet("/RemoveFromWishServlet")
public class RemoveFromWishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFromWishServlet() {
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
		String codi = request.getParameter("codProdo"); //codProdotto
		String user = (String)request.getSession().getAttribute("user");
		int cod= Integer.parseInt(codi);
		ClienteDAO check2 = new ClienteDAO();
		
		try {
			
		 	
		 	check2.removePref(user,cod);
		 	RequestDispatcher view = request.getRequestDispatcher("ViewWishServlet");
		 	view.forward(request, response);
			
		} 
        
        catch (Exception e) {
			e.printStackTrace();
		}
	
}
	}
