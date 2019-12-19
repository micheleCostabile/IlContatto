package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.google.gson.Gson;

import model.ClienteBean;
import model.ClienteDAO;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String un = (String) request.getParameter("user");
        String pass = (String) request.getParameter("pw");
        String value = (String) request.getParameter("check");
        boolean rememberMe = false;
        if(value != null && value.equalsIgnoreCase("on")){
            rememberMe = true;
        }
        
        ClienteBean c = new ClienteBean(un,pass);
        ClienteDAO check = new ClienteDAO();
        
        try {
			
        	c=(ClienteBean)check.Login(c);
			
		} 
        
        catch (Exception e) {
			e.printStackTrace();
		}
   
        
		HttpSession session = request.getSession();

		
		if(c!= null) {
			int admin;
			admin=c.getTipo();
			if (admin==1) {
				session.setAttribute("user", c.getUn());
				session.setAttribute("pw", c.getPw());
				session.setAttribute("nome", c.getNome());
				session.setAttribute("cognome", c.getCognome());
				session.setAttribute("eta", c.getEta());
				session.setAttribute("mail", c.getMail());
				session.setAttribute("city", c.getCity());
				session.setAttribute("state", c.getState());
				session.setAttribute("cap", c.getCap());
				session.setAttribute("address", c.getAddress());
				session.setAttribute("tipo", c.getTipo());
				boolean logged = true;
				session.setAttribute("log", logged);
				session.setMaxInactiveInterval(600);
				Gson gson = new Gson();
				String ok = gson.toJson("200");
				response.getWriter().print(ok);
			
		
			}
			
			else {
	
			if (rememberMe) {
				Cookie cookie = new Cookie("user",c.getUn());
				cookie.setMaxAge(60*60*24*365);
				response.addCookie(cookie);
				session.setAttribute("user", c.getUn());
				session.setAttribute("pw", c.getPw());
				session.setAttribute("nome", c.getNome());
				session.setAttribute("cognome", c.getCognome());
				session.setAttribute("eta", c.getEta());
				session.setAttribute("mail", c.getMail());
				session.setAttribute("city", c.getCity());
				session.setAttribute("state", c.getState());
				session.setAttribute("cap", c.getCap());
				session.setAttribute("address", c.getAddress());
				session.setAttribute("tipo", c.getTipo());
				session.setAttribute("cf", c.getCf());
				boolean logged = true;
				session.setAttribute("log", logged);
				session.setMaxInactiveInterval(600);
				Gson gson = new Gson();
				String ok = gson.toJson("200");
				response.getWriter().print(ok);
				

			}
					
			else {
				session.setAttribute("user", c.getUn());
				session.setAttribute("pw", c.getPw());
				session.setAttribute("nome", c.getNome());
				session.setAttribute("cognome", c.getCognome());
				session.setAttribute("eta", c.getEta());
				session.setAttribute("mail", c.getMail());
				session.setAttribute("city", c.getCity());
				session.setAttribute("state", c.getState());
				session.setAttribute("cap", c.getCap());
				session.setAttribute("address", c.getAddress());
				session.setAttribute("tipo", c.getTipo());
				session.setAttribute("cf", c.getCf());
				boolean logged = true;
				session.setAttribute("log", logged);
				session.setAttribute("error",false);
				session.setMaxInactiveInterval(600);
				Gson gson = new Gson();
				String ok = gson.toJson("200");
				response.getWriter().print(ok);
				
			

					  
			}
		}
			
		
		}
	     
		else {
			
			Gson gson = new Gson();
			String err = gson.toJson("Username o password errati");
			response.getWriter().print(err);
			
		}
		
	}
}