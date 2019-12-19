package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ComposizioneDAO;
import model.OrdineBean;
import model.OrdineDAO;
import model.ProductBean;
import model.ProductDAO;

/**
 * Servlet implementation class visOrdServlet
 */
@WebServlet("/visOrdServlet")
public class visOrdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public visOrdServlet() {
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
		String co= (String) request.getParameter("occhio");
		int cod= Integer.parseInt(co);
		
		try {
			ComposizioneDAO check = new ComposizioneDAO();
			ArrayList<ProductBean> lista= check.doRetrieveAll(cod);
			request.getSession().setAttribute("listaprod", lista);
			
			
			request.getSession().setAttribute("codOrd", cod);
			response.sendRedirect("VisOrdine.jsp");
		} catch  (Exception e) {
			e.printStackTrace();
		}
	}

}
