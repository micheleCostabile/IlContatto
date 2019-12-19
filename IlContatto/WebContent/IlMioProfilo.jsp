<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
	<title>Area Utente</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/style.css">
	<meta name="viewport" content="width=device-width, initial-scale=1" /> <!--serve per far essere responsive anche la versione mobile-->
	<%@ include file="Header.jsp" %>
</head>
<body>
<%@ include file="FacebookSDK.jsp" %>

<hr>
<%String nome= (String) session.getAttribute("nome");
  String cognome= (String) session.getAttribute("cognome");
  int eta= (Integer) session.getAttribute("eta");
  String email= (String) session.getAttribute("mail");
  String userutente= (String) session.getAttribute("user");
  String indirizzo= (String) session.getAttribute("address");
  String ind2= (String) session.getAttribute("address2");
  String pssw= (String) session.getAttribute("pw");
  String stato= (String) session.getAttribute("state");
  String city = (String) session.getAttribute("city");
  int cap = (Integer) session.getAttribute("cap");
  int tipo =(Integer) session.getAttribute("tipo");%>
<div class="container">
	<h4>Dati personali</h4>
	 <div class="container">
        <hr>
                <div class="form-row">
          <div class="form-group col-md-6">
            <label for="nome">Nome</label>
            <input type="text" class="form-control" name="nom" id="nome" value=<%=nome%> readonly>
          </div>
          <div class="form-group col-md-6">
            <label for="cognome">Cognome</label>
            <input type="text" class="form-control" id="cognome" name="cogn" value="<%=cognome%>" readonly>
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="inputEmail4">Email</label>
            <input type="email" class="form-control" name="mail" id="inputEmail4" value=<%=email%> readonly>
          </div>
          <div class="form-group col-md-5">
            <label for="inputPassword4">Password</label>
            <input type="password" class="form-control" id="inputPassword4" name="pw" value=<%=pssw%> readonly>
          </div>
          <div class="form-group col-md-1">
            <label for="cambia">Modifica</label>
            <button onclick="window.location.href='cambiaPass.jsp'" type="button" class="btn btn-warning" id="cambia">Cambia</button>
          </div>
        </div>
        <div class="form-row">
        <div class="form-group col-md-6">
          <label for="inputAddress">Indirizzo</label>
          <input type="text" class="form-control" id="inputAddress" name="ind1" value="<%=indirizzo%>" readonly>
        </div>
        <div class="form-group col-md-6">
          <label for="inputusr">Username</label>
          <input type="text" class="form-control" id="inputusr" name="user" value=<%=userutente%> readonly>
        </div>
            </div>
           
             <div class="form-row">
             
        <div class="form-group col-md-6">
       
          <label for="YO">Età</label>
          <input type="text" class="form-control" id="YO" value=<%=eta%> readonly>
        </div>
        
        <div class="form-group col-md-6">
            <label for="inputState">Stato</label>
            <input type="text" class="form-control" id="inputState" value=<%=stato%> readonly>
            
          </div>
        
        </div>
        <div class="form-row">
          
          <div class="form-group col-md-6">
                <label for="inputCity">Città</label>
                <input type="text" class="form-control" id="inputCity" value=<%=city%> readonly>
              </div>
          <div class="form-group col-md-6">
            <label for="inputZip">Codice Postale</label>
            <input type="text" class="form-control" id="inputZip" value=<%=cap%> readonly>
          </div>
        </div>
       
        
        <hr>
        </div>
		 
		  <button onclick="window.location.href='ModificaItuoiDati.jsp'" type="button" class="btn btn-warning">Modifica dati</button>
</div>
<hr>

<%if(tipo == 1){ %>

<%} 

else{ %>
<div class="container">
	<h4>I miei ordini</h4>
	 <div class="container">
        <hr>
         <a href="MieiOrdini.jsp">Visualizza ordini</a>      
        </div>
		<hr>
</div>
<%} %>


<%@ include file="Footer.jsp" %>
 
 
 	<script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>