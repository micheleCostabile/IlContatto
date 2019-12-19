<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Fattura</title>
    <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">

    <%@ page import = "model.FatturaBean" %>
    <%@ page import = "model.ProductBean" %>
    <%@ page import = "model.CarrelloBean" %>
    <%@	page import = "java.util.ArrayList" %>
    
</head>

<body>
	<%FatturaBean f= (FatturaBean) session.getAttribute("fattura"); %>
    <div id="invoice-box" class="invoice-box">
        <table cellpadding="0" cellspacing="0">
            <tr class="top">
                <td colspan="2">
                    <table>
                        <tr>
                            <td class="title">
                                <img src="img/logodef.png" style="width:100%; max-width:300px;">
                            </td>
                            
                            <td>
                                Fattura #: <%=f.getNf() %><br>
                                Creata: <%=f.getDa() %><br>
                                
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            
            <tr class="information">
                <td colspan="2">
                    <table>
                        <tr>
                            <td>
								IlContatto, Srl.<br>
                                Via Duomo, 13<br>
                                Salerno, SA 84100<br>
                                P.IVA 15177548628
                            </td>
                            
                            <td>
                            	<h4 id="intestatario">Intestata a:</h4>
                                <%=f.getNc()%>.<br>
                                <%if(f.getIva().equals("")){%>
                                <%} else { %>
                                P.IVA <%=f.getIva()%><br>
                                <%} %>
                                <%=f.getMail()%><br>
                               	<%=f.getCf() %>
                            </td>
                            
                            
                            
                            
                        </tr>
                    </table>
                </td>
            </tr>
            
            <tr class="heading">
                <td>
                    Metodo di pagamento
                </td>
                
                <td>
                    Validità
                </td>
            </tr>
            
            <tr class="details">
                <td>
                    N. Carta <%=f.getCn()%>
                </td>
                
                <td>
                    Valida
                </td>
            </tr>
            <table cellspacing="0" border="1">
            <tr class="heading">
                <td align="center">
                    Prodotti
                </td>
                
                <td align="center">
                	Quantità
                </td>
                
                <td align="center">
                    Prezzo Unitario
                </td>
                
                <td align="center">
                	Prezzo Complessivo
                </td>
                
            </tr>
            <%float totivap=0;
            float totiva=0;
            float pr;
            CarrelloBean carrTemp= (CarrelloBean) session.getAttribute("carrelloTemp");
            for(int i=0;i<carrTemp.getCarrello().size();i++){
            	ProductBean p= carrTemp.getCarrello().get(i); 
            	int iv=p.getIva();
            	if(p.getPrezzoScontato()==0){
            		pr= p.getPrezzo();
            	}
            	else { 
            	 	pr=p.getPrezzoScontato();
            	}
            totivap=(pr*iv)/100;
           	totiva=totiva+totivap;
            	
            	%>
            <tr>
                <td align="center">
                    <%=p.getNome() %>
                </td>
                
                <td align="center">
                	<%=p.getQty() %>	
                </td>
                
                <td align="center">
                   &#8364 <%=pr %>
                </td>
                
                <td align="center">
                	&#8364 <%=p.getSub() %>
                </td>
            </tr>
            <%} %>
            
		</table>
		<div id="resoconto">
		<tr>
		<%float m= (float)session.getAttribute("totale"); %>
		<strong>Subtotale:</strong> &#8364 <%=m-totiva %>
		</tr>
		<br>
		<tr>
		<strong>Imposta iva:</strong> &#8364 <%=totiva %>
		</tr>
		<br>
            <tr>
             <strong style="margin-right: 4px;">Totale:  &#8364 <%=session.getAttribute("totale") %></strong>
                
            </tr>
            </div>
        </table>
    </div>
    <br>
    <div style="text-align: center;">
    <div id="editor"></div>
   <a href="Fattura.jsp" download="Fattura.html">Download Fattura</a>
   <div id="bottoneWish"><button type="button" class="btn  btn-outline-warning" onclick="window.location.href='MieiOrdini.jsp'"> Visualizza i tuoi ordini </button></div>
      <div id="bottoneWish"><button type="button" class="btn  btn-outline-warning" onclick="window.location.href='index.jsp'">Torna alla home </button></div>
   
   </div>
</body>

	<style>
	 .invoice-box {
        max-width: 800px;
        margin: auto;
        padding: 30px;
        border: 1px solid #eee;
        box-shadow: 0 0 10px rgba(0, 0, 0, .15);
        font-size: 16px;
        line-height: 24px;
        font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;
        color: #555;
    }
    
    .invoice-box table {
        width: 100%;
        line-height: inherit;
        text-align: left;
    }
    
    .invoice-box table td {
        padding: 5px;
        vertical-align: top;
    }
    
    .invoice-box table tr td:nth-child(2) {
        text-align: right;
    }
    
    .invoice-box table tr.top table td {
        padding-bottom: 20px;
    }
    
    .invoice-box table tr.top table td.title {
        font-size: 45px;
        line-height: 45px;
        color: #333;
    }
    
    .invoice-box table tr.information table td {
        padding-bottom: 40px;
    }
    
    .invoice-box table tr.heading td {
        background: #eee;
        border-bottom: 1px solid #ddd;
        font-weight: bold;
    }
    
    .invoice-box table tr.details td {
        padding-bottom: 20px;
    }
    
    .invoice-box table tr.item td{
        border-bottom: 1px solid #eee;
    }
    
    .invoice-box table tr.item.last td {
        border-bottom: none;
    }
    
    .invoice-box table tr.total td:nth-child(2) {
        border-top: 2px solid #eee;
        font-weight: bold;
    }
    
    @media only screen and (max-width: 600px) {
        .invoice-box table tr.top table td {
            width: 100%;
            display: block;
            text-align: center;
        }
        
        .invoice-box table tr.information table td {
            width: 100%;
            display: block;
            text-align: center;
        }
    }
    
    /** RTL **/
    .rtl {
        direction: rtl;
        font-family: Tahoma, 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;
    }
    
    .rtl table {
        text-align: right;
    }
    
    .rtl table tr td:nth-child(2) {
        text-align: left;
    } .invoice-box {
        max-width: 800px;
        margin: auto;
        padding: 30px;
        border: 1px solid #eee;
        box-shadow: 0 0 10px rgba(0, 0, 0, .15);
        font-size: 16px;
        line-height: 24px;
        font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;
        color: #555;
    }
    
    .invoice-box table {
        width: 100%;
        line-height: inherit;
        text-align: left;
    }
    
    .invoice-box table td {
        padding: 5px;
        vertical-align: top;
    }
    
    .invoice-box table tr td:nth-child(2) {
        text-align: right;
    }
    
    .invoice-box table tr.top table td {
        padding-bottom: 20px;
    }
    
    .invoice-box table tr.top table td.title {
        font-size: 45px;
        line-height: 45px;
        color: #333;
    }
    
    .invoice-box table tr.information table td {
        padding-bottom: 40px;
    }
    
    .invoice-box table tr.heading td {
        background: #eee;
        border-bottom: 1px solid #ddd;
        font-weight: bold;
    }
    
    .invoice-box table tr.details td {
        padding-bottom: 20px;
    }
    
    .invoice-box table tr.item td{
        border-bottom: 1px solid #eee;
    }
    
    .invoice-box table tr.item.last td {
        border-bottom: none;
    }
    
    .invoice-box table tr.total td:nth-child(2) {
        border-top: 2px solid #eee;
        font-weight: bold;
    }
    
    @media only screen and (max-width: 600px) {
        .invoice-box table tr.top table td {
            width: 100%;
            display: block;
            text-align: center;
        }
        
        .invoice-box table tr.information table td {
            width: 100%;
            display: block;
            text-align: center;
        }
    }
    
    /** RTL **/
    .rtl {
        direction: rtl;
        font-family: Tahoma, 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;
    }
    
    .rtl table {
        text-align: right;
    }
    
    .rtl table tr td:nth-child(2) {
        text-align: left;
    }
	
	</style>


    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.5.3/jspdf.debug.js" ></script>
    <script src="js/jquery.min.js"></script>
    <script src="js/pdf.js"></script>
   
    
</html>