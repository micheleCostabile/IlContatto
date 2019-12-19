package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ClienteBean;
import model.ClienteDAO;
@SuppressWarnings("deprecation")

@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String un = request.getParameter("user");
        
        String pass = request.getParameter("pw");
        String cogn = request.getParameter("cogn");
        String nome = request.getParameter("nom");
        Date x= new Date();
        boolean f=false;
        String url=null;
       
		int annoCorrente=x.getYear()+1900;
        int annoNascita = Integer.parseInt(request.getParameter("anno"));
        int eta=annoCorrente-annoNascita;
        String indirizzo = request.getParameter("ind1");
        String city = request.getParameter("city");
        int cap = Integer.parseInt(request.getParameter("cap"));
        String stato = request.getParameter("stato");
        String mail = request.getParameter("mail");
        String cf = request.getParameter("cf");
        ClienteBean nuovo = new ClienteBean(un,pass,nome,cogn,mail,eta,0,city,cap,stato,indirizzo,cf);
        ClienteDAO check = new ClienteDAO();
        
        
        
        try {
			
        	f=check.doSave(nuovo);
			
		} 
        
        catch (Exception e) {
			e.printStackTrace();
		}
				
		
			
		if(f==false) {
			PrintWriter out = response.getWriter(); 
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(1000);
			response.getWriter().print(400);

        	
		}
		else {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(1000);
			response.getWriter().print(200);
		}
	
		
		
        
    }  
}
