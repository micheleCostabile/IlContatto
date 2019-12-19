<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "model.ClienteBean" %>
<%@	page import = "model.ClienteDAO" %>
<%@	page import = "model.OrdineBean" %> 
<%@	page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    
    
    <title>I miei ordini</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    
    <meta name="viewport" content="width=device-width, initial-scale=1" /> <!--serve per far essere responsive anche la versione mobile-->
</head>
<body>
	<%@ include file="Header.jsp" %>
	<%@ include file="FacebookSDK.jsp" %>

<div class="container">
<hr>
<div >
<table id="tabOrdini" class="table table-hover shopping-cart-wrap">
<thead class="text-muted">
<tr id="proviamolo">
  <th  scope="col" width="120">Codice Ordine</th>
  <th scope="col" width="120">Data</th>
  <th scope="col" width="120">Costo Totale</th>
  <th scope="col" width="120">Codice Fiscale</th>
  <th scope="col" width="120"></th>
</tr>
</thead>
<tbody>
<%
 		ClienteDAO search = new ClienteDAO();
 		ArrayList <OrdineBean> result	= new ArrayList <OrdineBean>();
 		result=search.getOrdini((String) session.getAttribute("user"));
 		

		for(OrdineBean p : result){ %>
		
		


<tr>
	<td>
<figure class="media">
	<figcaption class="media-body">
		<h6 class="title text-truncate"><%=p.getCod() %></h6>
	</figcaption>
</figure> 
	</td>
	<td> 
		<a><%=p.getDataOrdine() %></a>
	</td>
	<td> 
		<div class="price-wrap"> 
			<var class="price"><%=p.getCostoTot() %></var> 
			<small class="text-muted">(Euro)</small> 
		</div> <!-- price-wrap .// -->
	</td>
	<td> 

	<a><%=p.getCFUtente() %></a>
	</td>
	
	<td>
	<form method="post" action="visOrdServlet">
	<input type="hidden" value="<%=p.getCod()%>" name="occhio">
	<button type="submit"  id="xDeleteB"><img  id="xDeleteB" src="img/eye.svg"></button>
	</form>
	</td>
</tr>


       
        
        
			
		<%} %>
	</tbody>
		</table>
</div> <!-- card.// -->
	<hr>	
</div>
		
<%@ include file="Footer.jsp" %>
 
 
 	<script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
 </body>
</html>