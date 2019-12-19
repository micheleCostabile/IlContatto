<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <%@ page import = "model.ProductBean" %>
    
    <title>Modifica</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    
    <meta name="viewport" content="width=device-width, initial-scale=1" /> <!--serve per far essere responsive anche la versione mobile-->
</head>
 <body>
 	<%@ include file="Header.jsp" %>
	
	<form id="modprod" method="post" name="modprod">
        <div class="container">
        <hr>
                <div class="form-row">
          <div class="form-group col-md-6">
            <label for="codProdot">Codice Prodotto</label>
            <%	ProductBean p= (ProductBean) session.getAttribute("modifica");%>
            <input type="text" class="form-control" name="codProdot" id="codProdot" value="<%=p.getCodice() %>" onClick="blankLabel2('errorCod')" readonly>
            <h6 class="messaggierrore" id="errorCod"></h6>
          </div>
          <div class="form-group col-md-6">
            <label for="NomProdott">Nome Prodotto</label>
            <input type="text" class="form-control" id="NomProdott" name="NomProdott" value="<%=p.getNome()%>"  onClick="blankLabel2('errorNome')">
            <h6 class="messaggierrore" id="errorNomeM"></h6>
          </div>
        </div>
        
        <div class="form-row">
        <div class="form-group col-md-2">
          <label for="prezzo">Prezzo</label>
          <input type="text" class="form-control" id="prezz" name="prezzo" value="<%=p.getPrezzo()%>"  onClick="blankLabel2('errorPrez')">
          <h6 class="messaggierrore" id="errorPrezM"></h6>
        </div>
        <div class="form-group col-md-2">
          <label for="iva">Iva Attuale</label>
          <input type="number" class="form-control" id="iva" name="iva" value="<%=p.getIva()%>"  onClick="blankLabel2('errorIva')">
          <h6 class="messaggierrore" id="errorIvaM"></h6>
        </div>
        <div class="form-group col-md-2">
          <label for="nPezzi">Num Pezzi</label>
          <input type="number" class="form-control" id="nPezzi" name="nPezzi" value="<%=p.getPezzi()%>"  onClick="blankLabel2('errorNum')">
          <h6 class="messaggierrore" id="errorNumM"></h6>
        </div>
        <div class="form-group col-md-3">
          <label for="immagine">Immagine</label>
          <input type="text" class="form-control" id="immagine" name="immagine" value="<%=p.getImmagine()%>"  onClick="blankLabel2('errorImg')">
          <h6 class="messaggierrore" id="errorImgM"></h6>
        </div>
        <div class="form-group col-md-3">
          <label for="colore">Colore</label>
          <input type="text" class="form-control" id="colore" name="colore" value="<%=p.getColore()%>"  onClick="blankLabel2('errorCol')">
          <h6 class="messaggierrore" id="errorColM"></h6>
        </div>
            </div>
           
             
        <div class="form-row">
          <div class="form-group col-md-3">
          <label for="ps">Prezzo Scontato</label>
          <input type="text" class="form-control" id="ps" name="ps" value="<%=p.getPrezzoScontato()%>"  onClick="blankLabel2('errorCol')">
          <h6 class="messaggierrore" id="errorPrezzoScontatoM"></h6>
        </div>
          
          
        </div>
        
        <input type="hidden" name="marca" value="<%=p.getMarca() %>">
        <input type="hidden" name="modello" value="<%=p.getModello() %>">
        <input type="hidden" name="desc" value="<%= p.getDescrizione()%>">
        <input type="hidden" name="tipo" value="<%=p.getTipologia() %>">
        
        <button type="button"  onClick="controllaMod(modprod)" class="btn btn-warning">Modifica</button>
        </div>
        </form>
        <h6 id="erroreIns"></h6>
        <hr>
        </div>

	<%@ include file="FacebookSDK.jsp" %>
 	<%@ include file="Footer.jsp" %>
 
 
 	<script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/controlloModificaPan.js"></script>
 </body>
 
 </html>