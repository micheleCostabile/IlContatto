<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import = "model.ProductBean" %>
	<%@	page import = "model.ProductDAO" %>
	<%@	page import = "java.util.ArrayList" %>	
	<%	ArrayList<ProductBean> lista = (ArrayList<ProductBean>) request.getAttribute("listone");%>
<!DOCTYPE html>
<html >
<%if((Integer)session.getAttribute("tipo")!=1){ %>

<head>
    <meta charset="UTF-8">
    
    
    <title>Lista desideri</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    
    <meta name="viewport" content="width=device-width, initial-scale=1" /> <!--serve per far essere responsive anche la versione mobile-->
</head>
 <body>

 	<%@ include file="Header.jsp" %>
 	
 	<%@ include file="FacebookSDK.jsp" %>
	<div class="container">
	
<% 	if(lista.size()>0){
		for(int i=0;i<lista.size();i++){
	 		ProductBean p= lista.get(i);
	%>
	
	<div class="card" id="prefCard">
  <div class="card-body">

    <!-- Shopping Cart table -->
    <div class="table-responsive">

      <table class="table product-table">

        <!-- Table head -->
        <thead class="mdb-color lighten-5">
          <tr>
            <th class="font-weight-bold">
            <h6><strong>Prodotto</strong></h6>
            </th>
            <th class="font-weight-bold">
            <h6><strong>Nome</strong></h6>
            </th>
            <th class="font-weight-bold">
              <h6><strong>Prezzo</strong></h6>
            </th>
            <th class="font-weight-bold">
              <h6><strong>Acquista</strong></h6>
            </th>
            <th class="font-weight-bold">
              <h6><strong>Elimina</strong></h6>
            </th>

          </tr>
        </thead>
        <!-- /.Table head -->

        <!-- Table body -->
        <tbody>
		
          <!-- First row -->
          <tr>
          
            <th scope="row">
              <a href= "ProductView.jsp?codice=<%=p.getCodice()%>"><img id="prodotto_carr" src="<%=p.getImmagine() %>" alt=""> </a>
            </th>
            <td>
              <h5>
                <strong><%=p.getNome() %></strong>
              </h5>
              <p class="text-muted"><%=p.getMarca() %></p>
            </td>
            
            <td>&#8364 <%=p.getPrezzo() %></td>

			 <td>
             
            
             <button id="xDeleteB" type="button" onclick="addCart(<%=p.getCodice()%>)"> <img id="xDelete"alt=""src="img/cart2.png"></button>
                                         
            </form>
              
            </td>


            <td>
             <form method ="post" action="RemoveFromWishServlet">
             <%String username3= (String) request.getSession().getAttribute("user"); %>
	 					<input type="hidden" name="codProdo" value=<%=p.getCodice()%>>
						<input type="hidden" name="nameUte" value=<%=username3%>>
            
             <button id="xDeleteB" type="submit" >	<img id="xDelete"alt="" src="img/x.svg"></button>
                                         
            </form>
              
            </td>
            
            
            
          </tr>
     	  
          <!-- Fourth row -->
         
          <!-- Fourth row -->

        </tbody>
        <!-- /.Table body -->

      </table>

    </div>
    <!-- /.Shopping Cart table -->

	
  </div>

	

</div>




<%}
		} else{		
	%>
		
		<h6 class="noRes">Nessun elemento nella lista desideri.</h6>
		
		
	
<%}%>
	</div>
<div id="myModal2" class="modal">
    	<div class="modal-content">
    	<span class="close">&times;</span>
    		<div id="divApposto">
    			<img alt="" id="apposto" src="img/spunta_v.svg">
    			<h4 id="testoApposto">Aggiunto al carrello</h4>
    		</div>
   		</div>
	</div>

<hr>
 	<%@ include file="Footer.jsp" %>
 
 
 	<script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/card.js"></script>
 </body>
 <%} else{ %>
  <meta http-equiv="refresh" content="0;URL=Protected.jsp">
 
 <%} %>
 </html>