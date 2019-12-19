package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ClienteDAO;
import model.ProductBean;

/**
 * Servlet implementation class ViewWishServlet
 */
@WebServlet("/ViewWishServlet")
public class ViewWishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewWishServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = (String) /*request.getParameter("user");*/request.getSession().getAttribute("user");
		ClienteDAO check= new ClienteDAO();
		ArrayList<ProductBean> listone = new ArrayList<ProductBean>();
try {
			
		 	listone=check.getWList(user);
		 	request.setAttribute("listone", listone);
			RequestDispatcher view = request.getRequestDispatcher("Desideri.jsp");
	        view.forward(request, response);
		} 
        
        catch (Exception e) {
			e.printStackTrace();
		}
	
}
	}

