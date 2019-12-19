<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1" /> <!--serve per far essere responsive anche la versione mobile-->
    
</head>
<body>

<%Cookie[] cookies=request.getCookies();
String usern="";
if (cookies != null) {
     for (Cookie cookie : cookies) {
       if (cookie.getName().equals("user")) {
           usern=cookie.getValue();
       }
    }
} %>

<%@ include file="Header.jsp" %>
<%@ include file="FacebookSDK.jsp" %>
<!--login form-->
        <div class="container">
        <hr>
                <form id="formlogin" method="post" onsubmit="return login(this)">
                        <div class="form-group">
                          <label for="user" id="userlabel"><h4>Username</h4> </label>
                          <input type="text" class="form-control" name="user" value="<%=usern%>" id="user" placeholder="Username" onclick="blankLabel()">
                          <small id="emailHelp" class="form-text text-muted">Non verrà condiviso da nessuna parte.</small>
                        </div>
                        <div class="form-group">
                          <label for="password" id="pwlabel"><h4>Password</h4></label>
                          <input type="password" class="form-control" id="password" placeholder="Password" name="pw" onclick="blankLabel()">  
                        </div>
                        <div class="form-group form-check" id="rememberform">
                          <input type="checkbox" class="form-check-input" name="check">
                          <label class="form-check-label" for="exampleCheck1" >Ricordami</label>
                        </div>
                        <button type="submit" class="btn btn-warning" id="send">Entra</button>
                        <h6 id="regUtenteH">Nuovo utente? <a id="regUtente" href="registrazione.jsp">REGISTRATI SUBITO!</a></h6>
                        <div>
                        
                        <h6 id="error"> </h6>
                        </div>
                      </form>
                      <hr>

        </div>
        
   <%@ include file="Footer.jsp" %>

	
	<script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/login.js"></script>
</body>
</html>