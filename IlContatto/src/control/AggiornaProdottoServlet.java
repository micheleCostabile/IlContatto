package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProductDAO;
import model.ProductBean;

/**
 * Servlet implementation class AggiornaProdottoServlet
 */
@WebServlet("/AggiornaProdottoServlet")
public class AggiornaProdottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
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
		String prezzos= (String) request.getParameter("prezzoScontato");
		float prezzoS= Float.parseFloat(prezzos);
		ProductBean p= new ProductBean(cod,iva,npezzi,marca,modello,descrizione,immagine,nome,prezzo,tipologia,prezzoS,colore);
		
		ProductDAO check= new ProductDAO();
		try {
			
		 	
		 	check.aggiornaProdotto(p);
		 	RequestDispatcher view = request.getRequestDispatcher("Protected.jsp");
		 	view.forward(request, response);
			
		} 
        
        catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}

}
