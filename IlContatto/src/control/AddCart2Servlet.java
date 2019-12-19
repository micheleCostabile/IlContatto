package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import model.CarrelloBean;
import model.ProductBean;
import model.ProductDAO;

/**
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/AddCart2Servlet")
public class AddCart2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCart2Servlet() {
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
		String codi= (String) request.getParameter("cart");
		int cod=Integer.parseInt(codi);
		ProductDAO check = new ProductDAO();
		ProductBean prodotto= new ProductBean();
		CarrelloBean carrello =(CarrelloBean)request.getSession().getAttribute("carrello");
		if(carrello==null) { 
			CarrelloBean lista = new CarrelloBean();
			HttpSession session = request.getSession();
			
			try {
				prodotto= check.doRetrieveByKey(cod);
			
				prodotto.setQty(prodotto.getQty()+1);
				if(prodotto.getPrezzoScontato()!=0) {
					float sub = (float) (prodotto.getPrezzoScontato()*prodotto.getQty());
					prodotto.setSub(sub);
				}
				else {
					
					float sub = (float) (prodotto.getPrezzo()*prodotto.getQty());
					prodotto.setSub(sub);
				}
				
			
				lista.getCarrello().add(prodotto);
				request.getSession().setAttribute("carrello", lista);
		
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		else {
			try {
				prodotto= check.doRetrieveByKey(cod);
				int i;
				for(i=0;i<carrello.getCarrello().size();i++) {
					if(carrello.getCarrello().get(i).getCodice()==prodotto.getCodice()) {
						
						int se=carrello.getCarrello().get(i).getQty();
						
						if(se + 1 <=3) {
					
							prodotto.setQty(1 + se);
							carrello.getCarrello().remove(i);
							carrello.getCarrello().add(prodotto);
							if(prodotto.getPrezzoScontato()!=0) {
								float sub = (float) (prodotto.getPrezzoScontato()*prodotto.getQty());
								prodotto.setSub(sub);
							}
							else {
								float sub = (float) (prodotto.getPrezzo()*prodotto.getQty());
								prodotto.setSub(sub);
							}
							request.getSession().setAttribute("carrello", carrello);
							break;
							}
						
						else {
							break;
						}	
						
						}
					
						
					}
				
				if(i == carrello.getCarrello().size()) {
					prodotto.setQty(prodotto.getQty()+1);
					if(prodotto.getPrezzoScontato()!=0) {
						float sub = (float) (prodotto.getPrezzoScontato()*prodotto.getQty());
						prodotto.setSub(sub);
					}
					else {
						float sub = (float) (prodotto.getPrezzo()*prodotto.getQty());
						prodotto.setSub(sub);
					}
					carrello.getCarrello().add(prodotto);
					request.getSession().setAttribute("carrello", carrello);
					
					}
				}
			
			
			catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		
			
			}
		
		
		}
		
	
	}


