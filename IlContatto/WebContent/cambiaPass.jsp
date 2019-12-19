<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
<%	if(session.getAttribute("log") == null){ %>
 	<meta http-equiv="refresh" content="0;URL=index.jsp">
	<%} else{%>
<head>
    <meta charset="UTF-8">
    
    
    <title>Cambia Pass</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    
    <meta name="viewport" content="width=device-width, initial-scale=1" /> <!--serve per far essere responsive anche la versione mobile-->
</head>
 <body>
 	<%@ include file="Header.jsp" %>
 
 	<hr>
 	<div class="container">
	<form action="servletCambioPassword" method="post" onsubmit="return controlCambio(this)">
                        <p id="messaggio"></p>  
                            <div class="form-group row">
                                <label for="passwordVecchia" class="col-lg-3 col-form-label form-control-label titpar"><h5>Vecchia password</h5></label>
                                <div class="col-lg-9">
                                    <input class="form-control" name="passwordVecchia" id="passwordVecchia" type="password" value="" onclick="start1()" onkeyup="start1()">
                                </div>
                            </div>
                            <div class="form-group row">
                                    <label for="passwordNuova" class="col-lg-3 col-form-label form-control-label titpar"><h5>Nuova password</h5></label>
                                  
                                    <div class="col-lg-9">
                                        <input class="form-control" name="passwordNuova" id="passwordNuova" type="password" value="" onclick="start2()" onkeyup="start2()">
                                         <h6 id="error">La password deve avere almeno 8 caratteri, massimo 16 caratteri e deve contenere un valore numerico e una lettera maiuscola</h6>
                                    </div>
						 
                                    
                                </div>
                            <div class="form-group row">
                                <label class="col-lg-3 col-form-label form-control-label"></label>
                                <div class="col-lg-9">
                                    <input type="reset" class="btn btn-secondary" id="resetbottone" value="Reset">
                                    <input type="submit" class="btn btn-warning" id="inviobottone" value="Cambia">
                                </div>
                            </div>
                        </form> 
 		</div>
 		<hr>
 	<%@ include file="FacebookSDK.jsp" %>
 	
 	<%@ include file="Footer.jsp" %>
 
 
 	<script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/controlliCambioPassword.js"></script>
 </body>
 <%} %>
 </html>