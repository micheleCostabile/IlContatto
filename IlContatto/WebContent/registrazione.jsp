<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Registrazione</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1" /> <!--serve per far essere responsive anche la versione mobile-->
</head>
<body>
	
<%@ include file="Header.jsp" %>
<%@ include file="FacebookSDK.jsp" %>
<%@	page import = "model.ClienteDAO" %>

	

<!--reg form-->
<form id="formReg" method="post" name="reg">
        <div class="container">
        <hr>
                <div class="form-row">
          <div class="form-group col-md-6">
            <label for="nome">Nome</label>
            <input type="text" class="form-control" name="nom" id="nome" placeholder="Nome" onClick="blankLabel('errorName')" required>
            <h6 class="messaggierrore"  id="errorName"></h6>
          </div>
          <div class="form-group col-md-6">
            <label for="cognome">Cognome</label>
            <input type="text" class="form-control" id="cognome" name="cogn" placeholder="Cognome" onClick="blankLabel('errorSurname')" required>
         <h6 class="messaggierrore" id="errorSurname"></h6>         
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="inputEmail4">Email</label>
            <input type="email" class="form-control" name="mail" id="inputEmail4" placeholder="fighixximo@gmail.com" onClick="blankLabel('errorEmail','errorEmailInvalida')" required>
          <h6 class="messaggierrore" id="errorEmail"></h6>
          </div>
          <div class="form-group col-md-6">
            <label for="inputPassword4">Password</label>
            <input type="password" class="form-control" id="inputPassword4" name="pw"  onClick="blankLabel('errorPW','errorPWInvalida')" placeholder="Una minuscola, una maiuscola, un simbolo, almeno lunga 8 caratteri" required>
            <h6 class="messaggierrore" id="errorPW"></h6>
            
          </div>
        </div>
        <div class="form-row">
        <div class="form-group col-md-6">
          <label for="inputAddress">Indirizzo</label>
          <input type="text" class="form-control" id="inputAddress" name="ind1" placeholder="Via Roma, 3 " onClick="blankLabel('errorAddress')" required>
        <h6 class="messaggierrore" id="errorAddress"></h6>
        </div>
        <div class="form-group col-md-6">
        
          <label for="inputusr">Username</label>
          <input type="text" class="form-control" id="inputusr" name="user" placeholder="Bellixximo97" onClick="blankLabel('errorus')" required>
          <h6 class="messaggierrore" id="errorus"></h6> 
        
        </div>
            </div>
           
             <div class="form-row">
             
        <div class="form-group col-md-4">
          <label for="inputDay">Giorno di nascita</label>
         <select id="inputDay" class="form-control" name="giorn" onClick="blankLabel()">
              <option selected>1</option>
              <% for(int i=2;i<32;i++){ %>
             <option><%=i%></option>
             <%} %>
            </select>
        </div>
        <div class="form-group col-md-4">
          <label for="inputMounth">Mese di nascita</label>
          <select id="inputMounth" class="form-control" name="mese" onClick="blankLabel()">
              <option selected>1</option>
              <% for(int i=2;i<13;i++){ %>
             <option><%=i%></option>
             <%} %>
            </select>
        </div>
        <div class="form-group col-md-4">
          <label for="inputYear">Anno di nascita</label>
          <select id="inputYear" name="anno" class="form-control" onClick="blankLabel()">
              <option selected>2001</option>
              <option>2000</option>
             <% for(int i=1999;i>1950;i--){ %>
             <option><%=i%></option>
             <%} %>
         
            </select>
        </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-4">
            <label for="inputState">Stato</label>
            <input type="text" class="form-control" name="stato" id="inputState" onClick="blankLabel('errorState')" placeholder="Italia, Svizzera,..." required>
            <h6 class="messaggierrore" id="errorState"></h6>
          </div>
          <div class="form-group col-md-6">
                <label for="inputCity">Città</label>
                <input type="text" class="form-control" name="city" id="inputCity" onClick="blankLabel('errorCity')" placeholder="La tua città di residenza" required>
                <h6 class="messaggierrore" id="errorCity"></h6>
              </div>
          <div class="form-group col-md-2">
            <label for="inputZip">Codice Postale</label>
            <input type="text" class="form-control" name="cap" id="inputZip" onClick="blankLabel('errorZip')" placeholder="84100" required>
          <h6 class="messaggierrore" id="errorZip"></h6>
          </div>
          <div class="form-group col-md-6">
                <label for="inputCf">Codice Fiscale</label>
                <input type="text" class="form-control" name="cf" id="inputCf" onClick="blankLabel('errorCF')" placeholder="Codice Fiscale" required>
                <h6 class="messaggierrore" id="errorCF"></h6>
              </div>
        </div>
         
        
        <div class="form-group">
          <div class="form-check">
                <input class="form-check-input" type="checkbox" id="gridCheck1" onClick="blankLabel('errorCheck1')" required>
                <label class="form-check-label" for="gridCheck">
                  Acconsento al trattamento dei miei dati
                </label>
                <h6 class="messaggierrore" id="errorCheck1"></h6>
              </div>
              
              
          <div class="form-check">
                <input class="form-check-input" type="checkbox" id="gridCheck2" onClick="blankLabel('errorCheck2')" required>
                <label class="form-check-label" for="gridCheck">
                  Accetto i <a href="http://www.google.it">termini di servizio</a></p>
                </label>
                <h6 class="messaggierrore" id="errorCheck2"></h6>
        </div>
        <button type="button" onClick="validate(reg)" class="btn btn-warning">Registrati</button>
        </div>
        </form>
        <hr>
        </div>
        
        
   <%@ include file="Footer.jsp" %>
<script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/registrazione.js"></script>
</body>
</html>