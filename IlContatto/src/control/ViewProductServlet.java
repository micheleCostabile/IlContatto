package control;

import java.io.IOException;

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
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewProductServlet")
public class ViewProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codi = (String) request.getParameter("codice");
		int cod= Integer.parseInt(codi);
		ProductDAO check = new ProductDAO();
		ProductBean prod= new ProductBean();
		 try {
			 	prod= check.doRetrieveByKey(cod);
				request.getSession().setAttribute("prodotto", prod);
			} 
	        
	        catch (Exception e) {
				e.printStackTrace();
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
