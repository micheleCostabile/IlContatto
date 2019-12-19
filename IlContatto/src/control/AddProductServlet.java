package control;

import java.io.IOException;

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
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
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
			String codi= (String) request.getParameter("codProdot");
			int cod=Integer.parseInt(codi);
			String nome= (String) request.getParameter("NomProdott");
			String marca= (String) request.getParameter("marca");
			String modello= (String) request.getParameter("modello");
			String prez= (String) request.getParameter("prezzo");
			float prezzo= Float.parseFloat(prez);
			String iv= (String) request.getParameter("iva");
			int iva= Integer.parseInt(iv);
			String numP= (String) request.getParameter("nPezzi");
			int npezzi= Integer.parseInt(numP);
			String immagine= (String) request.getParameter("immagine");
			String tipologia= (String) request.getParameter("tipologia");
			String colore= (String) request.getParameter("colore"); 
			String descrizione= (String) request.getParameter("descrizione");
			
			ProductBean p= new ProductBean(cod,iva,npezzi,marca,modello,descrizione,immagine,nome,prezzo,tipologia,colore);
			boolean x = false;
			ProductDAO check= new ProductDAO();
			try {
				
			 	
			 	x=check.AddProduct(p);
			 	
				
			} 
	        
	        catch (Exception e) {
				e.printStackTrace();
			}
			
			if(x==true) {
						HttpSession session = request.getSession();
						session.setMaxInactiveInterval(1000);
						response.getWriter().print(200);
						}
			else {
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(1000);
				response.getWriter().print(400);
				
			}
	}
		}