<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    
    
    <title>Pagamento</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    
    <meta name="viewport" content="width=device-width, initial-scale=1" /> <!--serve per far essere responsive anche la versione mobile-->
	
 <body>
 	<%@ include file="Header.jsp" %>
 	<%@ include file="FacebookSDK.jsp" %>
 	<%@	page import = "model.ClienteBean" %>
 	
 	
 	<div class="container">
 	<hr>
  <form class="form-horizontal" id="pagaform" name="pagaform">
    <fieldset>
      <legend> Paga <img alt="card" src="img/cards.svg"></legend> 
      <div class="form-group">
        <label class="col-sm-3 control-label" for="card-holder-name">Nome e Cognome dell'intestatario della carta *</label>
        <div class="col-sm-9">
          <input type="text" class="form-control" name="nc" id="card-holder-name" placeholder="" onclick="blanks()">
           <h6 id="errorNc"> </h6>
        </div>
      </div>
      <div class="form-group">
        <label class="col-sm-3 control-label" for="card-number">Numero carta *</label>
        <div class="col-sm-9">
          <input type="text" class="form-control" name="card-number" id="card-number" placeholder="" onclick="blanks()">
           <h6 id="errorCard"> </h6>
        </div>
      </div>
      <div class="form-group">
        <label class="col-sm-3 control-label" for="expiry-month">Scadenza *</label>
        <div class="col-sm-9">
          <div class="row">
            <div class="col-sm-2">
              <select class="form-control" name="expiry-month" id="expiry-month">
                
                <option value="01">Gen (01)</option>
                <option value="02">Feb (02)</option>
                <option value="03">Mar (03)</option>
                <option value="04">Apr (04)</option>
                <option value="05">Mag (05)</option>
                <option value="06">Giu (06)</option>
                <option value="07">Lug (07)</option>
                <option value="08">Ago (08)</option>
                <option value="09">Set (09)</option>
                <option value="10">Ott (10)</option>
                <option value="11">Nov (11)</option>
                <option value="12">Dic (12)</option>
              </select>
            </div>
            <div class="col-xs-3">
              <select class="form-control" name="expiry-year">
                <option value="13">2019</option>
                <option value="14">2020</option>
                <option value="15">2021</option>
                <option value="16">2022</option>
                <option value="17">2023</option>
                <option value="18">2024</option>
                <option value="19">2025</option>
                <option value="20">2026</option>
                <option value="21">2027</option>
                <option value="22">2028</option>
                <option value="23">2029</option>
                <option value="23">2030</option>
              </select>
            </div>
          </div>
        </div>
      </div>
      <div class="form-group">
        <label class="col-sm-3 control-label" for="cvv">CVV *</label>
        <div class="col-sm-3">
          <input type="text" class="form-control" name="cvv" id="cvv" placeholder="Codice di Sicurezza" onclick="blanks()">
          <h6 id="errorCvv"> </h6>
        </div>
      </div>
      
       <div class="form-group">
        <label class="col-sm-3 control-label" for="codFis">Codice Fiscale *</label>
        <div class="col-sm-3">
          <input type="text" class="form-control" name="codFis" id="codFis" value="<%=session.getAttribute("cf") %>" placeholder="Codice Fiscale" readonly>
        </div>
      </div>
      <div class="form-group">
        <label class="col-sm-3 control-label" for="iva">Partita Iva </label>
        <div class="col-sm-3">
          <input type="text" class="form-control" name="iva" id="iva" placeholder="Codice P.Iva" onclick="blanks()">
        </div>
      </div>
      
      <div class="form-group">
        <div class="col-sm-offset-3 col-sm-9">
       
          <button type="button" onclick="controlliPag(pagaform)" class="btn btn-success">Paga Ora</button>
        </div>
      </div>
    </fieldset>
  </form>
</div>
 	<%@ include file="Footer.jsp" %>
 	
 	<script src="js/controlliPagamento.js"></script>
 	<script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
 </body>
 
 </html>


