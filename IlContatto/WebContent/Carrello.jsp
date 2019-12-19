<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <%@ page import = "model.ProductBean" %>
    <%@ page import = "model.CarrelloBean" %>
	<%@	page import = "model.ProductDAO" %>
	<%@	page import = "java.util.ArrayList" %>
    
    <title>IlContatto</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    
    <meta name="viewport" content="width=device-width, initial-scale=1" /> <!--serve per far essere responsive anche la versione mobile-->
	<%		CarrelloBean lista =(CarrelloBean)request.getSession().getAttribute("carrello");
%>
 <body>
 	<%@ include file="Header.jsp" %>
 	<%if(lista==null){ %>

	<div class = "container">
	<h6 class="noRes">Nessun prodotto nel carrello</h6>
	<hr>
	</div>
	
	
	<% } else {%>
	<div class = "container">
	<form name="tot">
 	<div class="card">
  <div class="card-body">

    <!-- Shopping Cart table -->
    <div class="table-responsive">

      <table class="table product-table">

        <!-- Table head -->
        <thead class="mdb-color lighten-5">
          <tr>
            <th></th>
            <th style="vertical-align: middle" class="font-weight-bold">
              <strong>Prodotto</strong>
            </th>
            <th style="vertical-align: middle" class="font-weight-bold">
              <strong>Colore</strong>
            </th>

            <th style="vertical-align: middle" class="font-weight-bold" width="15%">
              <strong>Prezzo unitario</strong>
            </th>
            <th style="vertical-align: middle" class="font-weight-bold">
              <strong>Quantità</strong>
            </th>
            <th style="vertical-align: middle" class="font-weight-bold">
              <strong>Ammontare</strong>
            </th>
            <th></th>
          </tr>
        </thead>
        <!-- /.Table head -->

        <!-- Table body -->
        <tbody>
        <%float totale = 0;
        for(int i=0;i<lista.getCarrello().size();i++){ 
        ProductBean p=lista.getCarrello().get(i); %>
		 
          <!-- First row -->
          <tr>
          
            <th scope="row">
              <a href= "ProductView.jsp?codice=<%=p.getCodice()%>"> <img id="prodotto_carr" src="<%=p.getImmagine() %>" alt=""> </a>
            </th>
            <td>
              <h5>
                <strong><%=p.getNome() %></strong>
              </h5>
              <p class="text-muted"><%=p.getMarca() %></p>
            </td>
            <td><%=p.getColore() %></td>
            <form name="modulo" method="get" action=""> 
            <%
            	float y=0;
            	if(p.getPrezzoScontato()==0){
            								 y=p.getPrezzo();	
            } 
            else{ 
            								 y=p.getPrezzoScontato();
            }	%>
            <td>&#8364 <input name="prezzo" type="text" value="<%=y %>" size="5" maxlength="5" readonly id="prezzo" class="prezzo"></td>
            <td>
			  <select style="width: 60px" name="articoli" id="articoli" onChange="calcola(<%=i %>)" class="articoli">
			  <%int x= p.getQty();
			  
			  int q = p.getPezzi();
			  
			  
			  if(x==1 || x==0){
			  	if(q == 1){%>
				<option value="1" selected>1</option>
				<%} else if (q == 2){ %>
					<option value="1" selected>1</option>
					<option value="2" >2</option>
					
			  <%} else if(q > 2){ %>
				  <option value="1" selected>1</option>
				  <option value="2" >2</option>
				  <option value="3" >3</option>
			  <%}}
				else if(x==2){
					if(q == 2){
					%>
				<option value="1" >1</option>
				<option value="2" selected>2</option>
				<%} else if(q > 2){ %>
 					<option value="1" >1</option>
					<option value="2" selected>2</option>
					<option value="3" >3</option>
				<%}} else if(x == 3) { %>
				<option value="1" >1</option>
				<option value="2" >2</option>
				<option value="3" selected>3</option>
				<%}%>
			  </select>	
            </td>
            <td>
              &#8364 <input name="somma" type="text" value="<%=p.getSub()%>" size="5" maxlength="5" id="subtot" class="subTot" readonly>
            </td>
            </form>
            <td>
            <form method ="post" action="RemoveFromCartServlet">
	 					<input type="hidden" name="posProdo" value=<%=lista.getCarrello().indexOf(p) %>>
	 					
             <button id="xDeleteB" type="submit" >	<img id="xDelete"alt="" src="img/x.svg"></button> </form>
            </td>
          </tr>
     	  <%totale =  totale + p.getSub();} %>
          <!-- Fourth row -->
          <div id ="finCart">
          <tr>
            <td colspan="3"></td>
            <td>
              <h4 class="mt-2">
                <strong>Totale   &#8364</strong>
              </h4>
            </td>
            <td class="text-right">
              <h4 class="mt-2">
                <strong> <input name="tot" type="text" value = "<%=totale%>" size="3" maxlength="3" id="tot" readonly></strong>
              </h4>
            </td>
            <%if(session.getAttribute("log")==null){%>
              <td colspan="3" class="text-right">
                <button type="button" onclick="location.href='login.jsp'" class="btn btn-warning btn-rounded">Completa acquisto
                  <i class="fas fa-angle-right right"></i>
                </button>
                </form>
              </td>
            </tr>
            
            <%} else{ %>
            <%session.setAttribute("totale", totale); %>
            <td colspan="3" class="text-right">
                <button type="button" onclick="window.location.href='Pagamento.jsp'" class="btn btn-warning btn-rounded">Completa acquisto
                  <i class="fas fa-angle-right right"></i>
                </button>
                </form>
              </td>
            </tr>
         <%} %>
            
          </tr>
          </div>
          <!-- Fourth row -->

        </tbody>
        <!-- /.Table body -->

      </table>

    </div>
    <!-- /.Shopping Cart table -->

  </div>

</div>
</form>
</div>
<%} %>
 	<%@ include file="FacebookSDK.jsp" %>
 	<%@ include file="Footer.jsp" %>
 	<script src="js/card.js"></script>
 	<script src="js/carrello.js"></script>
 	<script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
 </body>
 
 </html>
 