package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProductBean;
import model.ProductDAO;

/**
 * Servlet implementation class ModProductServlet
 */
@WebServlet("/ModProductServlet")
public class ModProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModProductServlet() {
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
		int codice = Integer.parseInt(request.getParameter("codProdot"));
		String marca = (String) request.getParameter("marca");
		String modello= (String) request.getParameter("modello");
		float prezzoAttuale= Float.parseFloat(request.getParameter("prezzo"));
		int iva= Integer.parseInt(request.getParameter("iva"));
		String descr= (String) request.getParameter("desc");
		int nPezzi= Integer.parseInt(request.getParameter("nPezzi"));
		String img = (String) request.getParameter("immagine");
		String nome = (String) request.getParameter("NomProdott");
		String tipo= (String) request.getParameter("tipo");
		float prezzoScontato=  Float.parseFloat(request.getParameter("ps"));
		String colore= (String) request.getParameter("colore");
		boolean m= false;
		try {
			ProductDAO access= new ProductDAO();
			ProductBean prod= new ProductBean (codice,iva,nPezzi,marca,modello,descr,img,nome,prezzoAttuale,tipo,prezzoScontato,colore);
			m = access.ModProduct(prod);
			
		} 
		
		catch (SQLException e) {
			
			e.printStackTrace();
			}
		
		if(m==true) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(1000);
			response.getWriter().print(200);
			}
	}

}
