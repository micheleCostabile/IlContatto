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

<hr><div class="container">
	<h4>Dati personali</h4>
	<form method="post" action="ModDatiServlet">
	 <div class="container">
        <hr>
                <div class="form-row">
          <div class="form-group col-md-6">
            <label for="nome">Nome</label>
            <input type="text" class="form-control" name="nom" id="nome" value=<%=nome%> >
          </div>
          <div class="form-group col-md-6">
            <label for="cognome">Cognome</label>
            <input type="text" class="form-control" id="cognome" name="cogn" value=<%=cognome %> >
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="inputEmail4">Email</label>
            <input type="email" class="form-control" name="mail" id="inputEmail4" value=<%=email %> >
          </div>
          <div class="form-group col-md-6">
            <label for="inputPassword4">Password</label>
            <input type="password" class="form-control" id="inputPassword4" name="pw" value=<%=pssw %> readonly >
          </div>
        </div>
        <div class="form-row">
        <div class="form-group col-md-6">
          <label for="inputAddress">Indirizzo</label>
          <input type="text" class="form-control" id="inputAddress" name="ind1" value=<%=indirizzo %> >
        </div>
        <div class="form-group col-md-6">
          <label for="inputusr">Username</label>
          <input type="text" class="form-control" id="inputusr" name="user" value=<%=userutente %> >
        </div>
            </div>
           
             <div class="form-row">
             <div class="form-group col-md-6">
          <label for="inputAddress2">Indirizzo 2(facoltativo)</label>
          <input type="text" class="form-control" id="inputAddress2" name="ind2" value=<%=ind2 %> >
        </div>
        <div class="form-group col-md-6">
          <label for="YO">Età</label>
          <input type="text" class="form-control" id="YO" name="eta"  value=<%=eta %> >
        </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-4">
            <label for="inputState">Stato</label>
            <input type="text" class="form-control" name="stato" id="inputState" value=<%=stato %> >
            
          </div>
          <div class="form-group col-md-6">
                <label for="inputCity">Città</label>
                <input type="text" class="form-control" name="city" id="inputCity" value=<%=city %> >
              </div>
          <div class="form-group col-md-2">
            <label for="inputZip">Codice Postale</label>
            <input type="text" class="form-control" id="inputZip" name="cap" value=<%=cap %>>
          </div>
        </div>
       
        
        <hr>
        </div>
		 
		 <input type="hidden" name="tipo" value=<%=tipo %>>
		  <button  type="submit" class="btn btn-warning">Salva</button>
		  </form>
</div>
<hr>