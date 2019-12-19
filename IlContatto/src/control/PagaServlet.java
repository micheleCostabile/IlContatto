package control;

import java.io.IOException;
import java.text.SimpleDateFormat;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CarrelloBean;
import model.ComposizioneBean;
import model.FatturaBean;
import model.OrdineBean;
import model.OrdineDAO;
import model.ProductBean;

/**
 * Servlet implementation class PagaServlet
 */
@WebServlet("/PagaServlet")
public class PagaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagaServlet() {
        super();
        // 
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
			String cf= (String) request.getParameter("codFis");
			java.util.Date d = new java.util.Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String da= sdf.format(d);
			Date data = Date.valueOf(da);
			float totale= (float) request.getSession().getAttribute("totale");
			String usern= (String) request.getSession().getAttribute("user");
			String mail= (String) request.getSession().getAttribute("mail");
			Random r= new Random();
			int x= r.nextInt(((50-20)+1)+200);
			CarrelloBean carrello =(CarrelloBean)request.getSession().getAttribute("carrello");
			OrdineBean ordine = new OrdineBean(x,data,totale,usern,cf);
			String nc= request.getParameter("nc");
			String cn= request.getParameter("card-number");
			cn= "************"+cn.substring(cn.length()-4);
			String iva= (String) request.getParameter("iva");
			FatturaBean f= new FatturaBean(x,nc,cn,iva,mail,da,cf);
			request.getSession().setAttribute("fattura", f);
			request.getSession().setAttribute("carrelloTemp", carrello);
			try {
				OrdineDAO check= new OrdineDAO();
				check.doSave(ordine);
				for(int i=0;i<carrello.getCarrello().size();i++) {
					ComposizioneBean composizione = new ComposizioneBean (x,carrello.getCarrello().get(i).getCodice(),carrello.getCarrello().get(i).getIva(),totale,carrello.getCarrello().get(i).getQty());
						int Nqty= carrello.getCarrello().get(i).getQty();
						int cod= carrello.getCarrello().get(i).getCodice();
						check.decrementa(Nqty,cod);
						check.insComp(composizione);
						
						
				}
				
				
				carrello=null;
				request.getSession().setAttribute("carrello", carrello);
				
			}
			 catch (Exception e) {
					e.printStackTrace();
				}
	}

}
