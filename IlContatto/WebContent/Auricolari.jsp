<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ page import = "model.ProductBean" %>
<%@	page import = "model.ProductDAO" %>
<%@	page import = "java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    
    
    <title>IlContatto</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">    
    
    
    <meta name="viewport" content="width=device-width, initial-scale=1" /> <!--serve per far essere responsive anche la versione mobile-->
	
 <body>
 	<%@ include file="Header.jsp" %>
 	
<meta charset="UTF-8">

<%@ page import = "model.ProductBean" %>
<%@	page import = "model.ProductDAO" %>
<%@ page import = "model.ClienteBean" %>
<%@	page import = "model.ClienteDAO" %>
<%@	page import = "java.util.ArrayList" %>


			
		<div class="container">
		<div class="row">
		<%String username2= (String) session.getAttribute("user"); %>
<%
 		ProductDAO search = new ProductDAO();
 		ArrayList <ProductBean> result	= new ArrayList <ProductBean>();
 		result=search.getAuricolari();

		for(ProductBean p : result){ %>
		<div class = "col-md-4" id="cardColumn">
       	<form id="ViewForm" method="get" action="ViewProductServlet">
        	<div id="cardProdotti" class="card">
				<div id="picc">
          			<a href= "ProductView.jsp?codice=<%=p.getCodice()%>"><img id="prodottoPic" src="<%=p.getImmagine()%>" class="card-img-top img-responsive" alt="..."></a>
          		</div>
			
			<div class="card-body" id="cards">
			  <h5 class="card-title"><%=p.getNome()%></h5>
			 <div id="stars" ><span class="fa fa-star checked" ></span>
			  <span class="fa fa-star checked"  ></span>
			  <span class="fa fa-star checked"  ></span>
			  <span class="fa fa-star"  ></span>
			  <span class="fa fa-star" ></span> </div> 
			  	<div class="card-bottom">
			  		
			  	<div id="prezzoID">
			  		<%
			  			if(p.getPrezzoScontato() > 0){
			  				
			  				%> <h5><del class="price-old">&#8364 <%=p.getPrezzo()%></del></h5>
			  				   <hr>
			  				   <h3>&#8364 <%=p.getPrezzoScontato()%></h3>
			  			<%} else{%>
			  		<hr>
			  		<h3>&#8364 <%=p.getPrezzo()%></h3>
					<%} %>
			  		</form>
			  		  
			  		  <%if(session.getAttribute("log")==null){ 
			  	    %>
			  	</div>
			  	<div id="cuoreID"> 
			  	  <button type="button" onclick="window.location.href='login.jsp'" id="cuorepicCards"><img src="img/cuoreNeroVuoto.svg"  id="cuorepicCards1"></button>
			  	  <form method="POST">
					<button type="button"  id="carrellopicCards"  onclick="addCart(<%=p.getCodice()%>)"><img src="img/cart2.png" id="carrellopicCards1"></button>
			  	    </form>			  	    <%} else {	int mu= (Integer)session.getAttribute("tipo");
			  		  if(mu!=1){%>
			  	    <% ClienteDAO pes = new ClienteDAO(); %>
					<%session.setAttribute("codiceWish", p.getCodice()); 
					if(session.getAttribute("log") != null && pes.controllaPref(username2,p.getCodice())==false) {%>
			  	    
			  	    <form method="POST">
			  	    <button type="button"  id="cuorepicCards" onclick="addPref(<%=p.getCodice()%>)" ><img src="img/cuoreNeroVuoto.svg"  id="cuorepicCards1V" onclick="cambiaMod(this)"></button>
			  	    
			  	   </form>
			  	   <%}
    				else if(session.getAttribute("log") != null && pes.controllaPref(username2,p.getCodice())==true) {%>
    				<form method="POST">
			  	    <button type="button"  id="cuorepicCards" onclick="addPref(<%=p.getCodice()%>)"><img src="img/cuoreNeroPieno.svg"  id="cuorepicCards1" onclick="cambiaMod(this)"></button>
			  	    
			  	   </form>
			  	   
			  	   <%} %>
			  	 </div>
			  	 <div id="carrelloID">
			  	  <form method="post">
			  		<button type="button"  id="carrellopicCards" onclick="addCart(<%=p.getCodice()%>)"><img src="img/cart2.png" id="carrellopicCards1"></button>
			  	    </form>
			  	   <%} %>
			  	   
			  	   <%} %>
			  	 </div>
			  	</div>
			</div>
		    </div>
		 
        </div>
			
		<%} %>

	
  <!-- Modal content -->
  

  <div id="myModal2" class="modal">
    <div class="modal-content">
    <span class="close">&times;</span>
    <div id="divApposto">
    <img alt="" id="apposto" src="img/spunta_v.svg">
    <h4 id="testoApposto">Aggiunto al carrello</h4>
    </div>
  </div>

 		</div>
 	    </div>
 	    
 	     <script src="js/card.js"></script>
 	  
 	  
 	 </div>
 	    </div>
  <hr>

 	
 
 	
 	<%@ include file="Footer.jsp" %>
	<script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
     <script src="js/card.js"></script>
     <script src="js/preferito.js"></script>
 </body>
 
 </html>