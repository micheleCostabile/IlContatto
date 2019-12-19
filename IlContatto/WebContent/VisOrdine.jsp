<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ page import = "model.ProductBean" %>

<%@	page import = "java.util.ArrayList" %>
<title>Dettagli Ordine</title>
 <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
<body>
<%@ include file="Header.jsp" %>
	<%@ include file="FacebookSDK.jsp" %>
<%ArrayList<ProductBean> lista= (ArrayList<ProductBean>) session.getAttribute("listaprod"); 
float totale = 0;%>

<div class="container">
<hr>
<div >
<table id="tabOrdini" class="table shopping-cart-wrap">
<thead class="text-muted">
<tr id="proviamolo">
  <th scope="col" width="120">Prodotto</th>
  <th scope="col" width="120">Nome</th>
  <th scope="col" width="120">Quantità</th>
  <th scope="col" width="120">Prezzo</th>
  
 

</tr>
</thead>
<tbody>
<%
 		for(int i=0;i<lista.size();i++){
 		ProductBean p= lista.get(i);
 		%>
		
		


<tr>
	<td>
<figure class="media">
	<figcaption class="media-body">
		<a href= "ProductView.jsp?codice=<%=p.getCodice()%>"><img id="prodotto_carr" src="<%=p.getImmagine() %>" ></a>
	</figcaption>
</figure> 
	</td>
	<td> 
		<h5><strong><%=p.getNome() %></strong></h5>
		<p class="text-muted"><%=p.getMarca() %></p>
	</td>
	
	<td>
	
		<h6><%=p.getQty() %></h6>
	
	<td> 
		<div class="price-wrap"> 
		<%if(p.getPrezzoScontato()==0){ 
			totale = totale + p.getPrezzo()*p.getQty();
		%>
			<var class="price"><%=p.getPrezzo() %></var> 
			<% } else { totale = totale + p.getPrezzoScontato()*p.getQty();%>
			<var class="price"><%=p.getPrezzoScontato() %>
			
					
			</var> 
			<%} %>
			<small class="text-muted">(Euro)</small> 
		</div> <!-- price-wrap .// -->
	</td>

	
</tr>


       
        
        
			
		<%} %>
	</tbody>
		</table>
</div> <!-- card.// -->
	<hr>
	
	<div id ="fattTot">
	
	 <h4 class="mt-2">
	<strong>Totale &#8364 <input name="tot" type="text" value = <%=totale%> size="5" maxlength="5" id="tot" readonly></strong>
	</h4>
	</div>
	<hr>
		
</div>
		
<%@ include file="Footer.jsp" %>
 
 
 	<script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
 </body>
</html>