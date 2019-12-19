<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@ page import = "model.ProductBean" %>
<%@ page import = "model.OrdineBean" %>
<%@	page import = "model.ProductDAO" %>
<%@ page import = "model.ClienteBean" %>
<%@	page import = "model.ClienteDAO" %>
<%@	page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<%	if(session.getAttribute("log") == null){ %>
 	<meta http-equiv="refresh" content="0;URL=index.jsp">
	<%} else{%>
	<%if( (Integer) session.getAttribute("tipo")==1){ %>
<head>
    <meta charset="UTF-8">
    
    
    <title>Pannello di controllo</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    
    <meta name="viewport" content="width=device-width, initial-scale=1" /> <!--serve per far essere responsive anche la versione mobile-->
</head>
 <body>
 	<%@ include file="Header.jsp" %>
 	<hr>
 	<div id="pannelloAd" >
 <section id="tabs" class="project-tab">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <nav>
                            <div class="nav nav-tabs nav-fill" id="nav-tab" role="tablist">
                                <a class="nav-item nav-link active" id="nav-index-tab" data-toggle="tab" href="#nav-index" role="tab" aria-controls="nav-index" aria-selected="true">Gestione utenti</a>
                                <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false">Gestione prodotti</a>
                                <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-contact" role="tab" aria-controls="nav-contact" aria-selected="false">Gestione ordini</a>
                            </div>
                        </nav>
                        <div class="tab-content" id="nav-tabContent">
                            <div class="tab-pane fade show active" id="nav-index" role="tabpanel" aria-labelledby="nav-index-tab">
                                <table class="table" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Username</th>
                                            <th>E-mail</th>
                                            <th>Tipo Utente</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <%
 										ClienteDAO search = new ClienteDAO();
 										ArrayList <ClienteBean> result	= new ArrayList <ClienteBean>();
 										result=search.getAll();

										for(ClienteBean p : result){ %>
                                        <tr>
                                            <td><a href="#"><%=p.getUn()%></a></td>
                                            <td><%=p.getMail() %></td>
                                            <td><%if(p.getTipo()==1) out.println("Admin") ; else out.println("Utente");%></td>
                                        </tr>
                                        <%} %>
                                        
                                    </tbody>
                                </table>     
                            </div>
                            <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
                                <table class="table" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>ID Prodotto</th>
                                            <th>Nome</th>
                                            <th>Pezzi</th>
                                            <th>Modifica</th>
                                            <th>Elimina</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <%
 										ProductDAO search2 = new ProductDAO();
 										ArrayList <ProductBean> result2	= new ArrayList <ProductBean>();
 										result2=search2.getAll();

										for(ProductBean p2 : result2){ %>
                                    
                                    
                                        <tr>
                                            <td><a href="#"><%=p2.getCodice() %></a></td>
                                            <td><%=p2.getNome() %></td>
                                            <td><%=p2.getPezzi() %></td>
                                            <form method ="post" action="DiPassaggio">
                                            <input type ="hidden" value= <%=p2.getCodice()%> name="modifica" >
                                            <td><button  id="xDeleteB" type="submit" >	<img id="xDelete"alt="" src="img/pencil.svg"></button></td>
                                           	</form>
                                            <form method ="post" action="RemoveProductServlet">
                                            <input type ="hidden" value= <%=p2.getCodice()%> name="prodcode" >
                                            <td><button id="xDeleteB" type="submit" >	<img id="xDelete"alt="" src="img/x.svg"></button></td>
                                            </form>
                                        </tr>
                                       <%} %>
                                    </tbody>
                                </table>
                                <button onclick="window.location.href='InserisciProdotto.jsp'" type="button" class="btn btn-warning">Aggiungi prodotto</button>
                            </div>
                            <div class="tab-pane fade" id="nav-contact" role="tabpanel" name="ordini" aria-labelledby="nav-contact-tab">
                                <table class="table" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Codice Ordine</th>
                                            <th>Data</th>
                                            <th>Codice Fiscale</th>
                                            <th>Totale</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                     <%
                                    	 
                                    
                                     	if(request.getAttribute("vuota") == null && request.getAttribute("listaORD") == null){	
                                     		ClienteDAO search3 = new ClienteDAO();
 											ArrayList <OrdineBean> result3	= new ArrayList <OrdineBean>();
 											result3=search3.getAllOrdini();

											for(OrdineBean p3 : result3){ %>
                                        		<tr>
                                            		<td><a href="#"><%=p3.getCod() %></a></td>
                                            		<td><%=p3.getDataOrdine() %></td>
                                            		<td><%=p3.getCFUtente() %></td>
                                            		<td><%=p3.getCostoTot() %> </td>
                                        		</tr>
                                       <%}} else if(!(request.getAttribute("listaORD") == null)){
                                    	   
    										ArrayList <OrdineBean> result3	=  (ArrayList <OrdineBean>) request.getAttribute("listaORD");
									
											for(OrdineBean p3 : result3){ %>
	                                        <tr>
	                                            <td><a href="#"><%=p3.getCod() %></a></td>
	                                            <td><%=p3.getDataOrdine() %></td>
	                                            <td><%=p3.getCFUtente() %></td>
	                                            <td><%=p3.getCostoTot() %></td>
	                                        </tr>
                                    	   <%}} %>
                                    	   
                                     </tbody>
                                </table>
                                
                                <form method ="POST" action="GetOrdiniByDataServlet">
                                           	<label for="from">Da:</label>
                                           	<input type="date" id="from" name="da" value="YYYY-MM-GG" required>
											<label for="to">A:</label>
                                           	<input type="date" id="to" name="a" value="YYYY-MM-GG" required>
											<button id="reload" type="submit" class="btn btn-primary"> <img id="imgReload" alt="" src="img/reload.svg"> </button>
											
                                </form>
                                
 
                                
                                <p id="erroreData"></p>
                                
                                <form method="POST"   action="GetOrdiniByUtente">
                                
                                			<label>Seleziona utente: </label>
         									<select  name="utentePannello">
         									
         									 <% for(ClienteBean p : result){ %>
                                       		
                                            <option> <%=p.getUn()%> </option>ù
                                           
                                       		 <%} %>
         		
            								</select>
            								
            								<button id="reload" type="submit" class="btn btn-primary"> <img id="imgReload" alt="" src="img/reload.svg"> </button>
            								
                                
                                
                                
                                
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
 	</div>
 	<hr>
 	<%@ include file="FacebookSDK.jsp" %>
 	<%@ include file="Footer.jsp" %>
 
 
 	<script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
 </body>
 <%} else{ %>
 <meta http-equiv="refresh" content="0;URL=index.jsp">
 <%} }%>
 </html>