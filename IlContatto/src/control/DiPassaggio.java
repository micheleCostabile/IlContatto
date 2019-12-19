package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductBean;
import model.ProductDAO;

/**
 * Servlet implementation class DiPassaggio
 */
@WebServlet("/DiPassaggio")
public class DiPassaggio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiPassaggio() {
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
		int codice = Integer.parseInt(request.getParameter("modifica"));
		try {
			ProductDAO access= new ProductDAO();
			ProductBean prod= new ProductBean();
			prod= access.doRetrieveByKey(codice);
			request.getSession().setAttribute("modifica", prod);
			RequestDispatcher view = request.getRequestDispatcher("ModificaProdotto.jsp");
			view.forward(request,response);
			
		} 
		
		catch (SQLException e) {
			
			e.printStackTrace();
		}

	
	}

}
