package control;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ClienteBean;
import model.ClienteDAO;

/**
 * Servlet implementation class ModDatiServlet
 */
@WebServlet("/ModDatiServlet")
public class ModDatiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModDatiServlet() {
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
		String un = request.getParameter("user");
        String pass = request.getParameter("pw");
        String cogn = request.getParameter("cogn");
        String nome = request.getParameter("nom");
        String eta1= (String) request.getParameter("eta");
        int eta = Integer.parseInt(eta1);
        String indirizzo = request.getParameter("ind1");
        String city = request.getParameter("city");
        String cap1= (String) request.getParameter("cap");
        int cap = Integer.parseInt(cap1);
        String stato = request.getParameter("stato");
        String mail = request.getParameter("mail");
        String tipo1= (String) request.getParameter("tipo");
        int tipo= Integer.parseInt(tipo1);
        ClienteBean nuovo = new ClienteBean(un,pass,nome,cogn,mail,eta,tipo,city,cap,stato,indirizzo);
        ClienteDAO check = new ClienteDAO();
		
try {
			
        	check.aggiornaUtente(nuovo);
			
		} 
        
        catch (Exception e) {
			e.printStackTrace();
		}
				HttpSession session = request.getSession();
				
				session.setMaxInactiveInterval(600);
				 session.setAttribute("nome", nome);
				 session.setAttribute("cognome", cogn);
				 session.setAttribute("eta", eta);
				 session.setAttribute("mail", mail);
				 session.setAttribute("user", un);
				 session.setAttribute("address", indirizzo);
			//	 session.setAttribute("address2", nome);
				 session.setAttribute("pw", pass);
				 session.setAttribute("state", stato);
				 session.setAttribute("city", city);
				 session.setAttribute("cap", cap);




				RequestDispatcher view = request.getRequestDispatcher("IlMioProfilo.jsp");
		        view.forward(request, response);		
			
				
	
		
        
    }  
}