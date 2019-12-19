package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProductBean;


@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			HttpSession session = request.getSession();
			
			session.removeAttribute("user");
			session.removeAttribute("pw");
			session.removeAttribute("error");
			
			Cookie[] cookies=request.getCookies();
		
			if (cookies != null) {
				
			     for (Cookie cookie : cookies) {
			       if (cookie.getName().equals("log")) {
			    	   System.out.println(cookie.getValue());
			           cookie.setValue("no");
			           response.addCookie(cookie);
			     
			       }
			    }
			}
			
			
			String redirectpage= "index.jsp";
			response.sendRedirect(redirectpage);
			session.invalidate();
			
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		doGet(request,response);
        
	}
}
