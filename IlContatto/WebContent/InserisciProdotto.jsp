<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    
    
    <title>Inserisci prodotto</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    
    <meta name="viewport" content="width=device-width, initial-scale=1" /> <!--serve per far essere responsive anche la versione mobile-->
</head>
 <body>
 	<%@ include file="Header.jsp" %>
	
	<form id="formInserProd" method="post" name="ins">
        <div class="container">
        <hr>
                <div class="form-row">
          <div class="form-group col-md-6">
            <label for="codProdot">Codice Prodotto</label>
            <input type="text" class="form-control" name="codProdot" id="codProdot" placeholder="es 1" onClick="blankLabel2('errorCod')">
            <h6 class="messaggierrore" id="errorCod"></h6>
          </div>
          <div class="form-group col-md-6">
            <label for="NomProdott">Nome Prodotto</label>
            <input type="text" class="form-control" id="NomProdott" name="NomProdott" placeholder="es Apple iPhone 6 64GB - Nero" onClick="blankLabel2('errorNome')">
            <h6 class="messaggierrore" id="errorNome"></h6>
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="marca">Marca</label>
            <input type="text" class="form-control" name="marca" id="marca" placeholder="es Apple" onClick="blankLabel2('errorMarca')">
            <h6 class="messaggierrore" id="errorMarca"></h6>
          </div>
          <div class="form-group col-md-6">
            <label for="modello">Modello</label>
            <input type="text" class="form-control" id="modello" name="modello" placeholder="A1865" onClick="blankLabel2('errorMod')">
            <h6 class="messaggierrore" id="errorMod"></h6>
          </div>
        </div>
        <div class="form-row">
        <div class="form-group col-md-2">
          <label for="prezzo">Prezzo</label>
          <input type="text" class="form-control" id="prezz" name="prezzo" placeholder="600 " onClick="blankLabel2('errorPrez')">
          <h6 class="messaggierrore" id="errorPrez"></h6>
        </div>
        <div class="form-group col-md-2">
          <label for="iva">Iva Attuale</label>
          <input type="number" class="form-control" id="iva" name="iva" placeholder="22" onClick="blankLabel2('errorIva')">
          <h6 class="messaggierrore" id="errorIva"></h6>
        </div>
        <div class="form-group col-md-2">
          <label for="nPezzi">Num Pezzi</label>
          <input type="number" class="form-control" id="nPezzi" name="nPezzi" placeholder="10" onClick="blankLabel2('errorNum')">
          <h6 class="messaggierrore" id="errorNum"></h6>
        </div>
        <div class="form-group col-md-3">
          <label for="immagine">Immagine</label>
          <input type="text" class="form-control" id="immagine" name="immagine" placeholder="prodotti/iPhone.png" onClick="blankLabel2('errorImg')">
          <h6 class="messaggierrore" id="errorImg"></h6>
        </div>
        <div class="form-group col-md-3">
          <label for="colore">Colore</label>
          <input type="text" class="form-control" id="colore" name="colore" placeholder="Nero" onClick="blankLabel2('errorCol')">
          <h6 class="messaggierrore" id="errorCol"></h6>
        </div>
            </div>
           
             
        <div class="form-row">
          <div class="form-group col-md-3">
          <label for="tipologia">Tipologia</label>
         <select id="tipologia" class="form-control" name="tipologia" required>
                  
              <option>Smartphone</option>
              <option>Accessori</option>
           	  <option>Cover</option>
           	  <option>Auricolari</option>

            </select>
        </div>
          <div class="form-group col-md-9">
          <label for="form7">Descrizione</label>
                <textarea id="form7" name="descrizione" class="md-textarea form-control" rows="1" onClick="blankLabel2('errorDesc')"></textarea>
                <h6 class="messaggierrore" id="errorDesc"></h6>
  				
              </div>
          
        </div>
        
        <button type="button" onClick="controlla(ins)" class="btn btn-warning">Aggiungi</button>
        </div>
        </form>
        <h6 id="erroreIns"></h6>
        <hr>
        </div>
	
 	<%@ include file="FacebookSDK.jsp" %>
 	<%@ include file="Footer.jsp" %>
 
 	<script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/controlliPannello.js"></script>
 </body>
 
 </html>