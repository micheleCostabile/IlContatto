<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <% Cookie[] gibb=request.getCookies();
		String log="";
		if (gibb != null) {
	     	for (Cookie c : gibb) {
	       		if (c.getName().equals("log")) {
	           	log=c.getValue();
	       }
    }
}%>
    
<nav id="navbartop" class="navbar navbar-expand-lg">
  <div class="d-flex flex-grow-1">
      <span class="w-100 d-lg-none d-block"><!-- hidden spacer to center brand on mobile --></span>
      <a class="navbar-brand" href="index.jsp">
         <img id="logo" src="img/logodef.png" alt="IlContatto">
      </a>
      <div class="w-100 text-right">
          <button id="tastino1" class="navbar-toggler" type="button" data-toggle="collapse" data-target="#myNavbar7"><img src="img/collapse.svg" id="collassopic">
              
          </button>
      </div>
  </div>
  <div class="collapse navbar-collapse flex-grow-1 text-right" id="myNavbar7">
      <ul class="navbar-nav ml-auto flex-nowrap">
      	 
          <% 
           if(session.getAttribute("log") != null && (Integer)session.getAttribute("tipo")==1){ %>
          <% String nome= (String) session.getAttribute("nome");%>
          
          
          <li class="nav-item">
            <a id="toplink" href="IlMioProfilo.jsp" class="nav-link"><id="saluto"><img src="img/userPieno.svg" id="userpic">Ciao Admin <%=nome%>   <img alt="mm" src="img/linea.svg" id="lineapic"></a>
          </li>
          
          <li class="nav-item">
          <a id="toplink" href="Protected.jsp" class="nav-link">Pannello di controllo <img alt="mm" src="img/linea.svg" id="lineapic"></a>
          </li>
          
 		 <form id="formLogout" method="get" action="LogoutServlet">
          <li class="nav-item" id="logoutli">
              <button type="submit" id="logout" class="nav-link">Logout   <img alt="mm" src="img/linea.svg" id="lineapic"></button>
          </li>
           </form>
          <%} 
          		if(session.getAttribute("log") != null && (Integer)session.getAttribute("tipo")==0 ){%>
          
           <% String nome= (String) session.getAttribute("nome");%>
          
          
          <li class="nav-item">
            <a id="toplink" href="IlMioProfilo.jsp" class="nav-link"><id="saluto"><img src="img/userPieno.svg" id="userpic">Ciao <%=nome%>   <img alt="mm" src="img/linea.svg" id="lineapic"></a>
          </li>
          
 		 <form id="formLogout" method="get" action="LogoutServlet">
          <li class="nav-item" id="logoutli">
              <button type="submit" id="logout" class="nav-link">Logout   <img alt="mm" src="img/linea.svg" id="lineapic"></button>
          </li>
           </form>
           
            <li class="nav-item">
            <a id="toplink" href="contattaci.jsp" class="nav-link"><img src="img/info.svg" id="infopic">Contattaci<img alt="mm" src="img/linea.svg" id="lineapic3"></a>
        </li>
        <li class="nav-item">
        <%String username= (String) session.getAttribute("user"); %>
        <form method="post" action="ViewWishServlet">
        <input type="hidden" id="hidden" name="user" value=<%=username%>>
           <button type="submit" class="btn  btn-outline-success" id="wish"><img src="img/cuore2.png" id="cuorepic"></button>
          </form>
          </li>
          <li class="nav-item">
          
            <button type="button"  onclick="window.location.href='Carrello.jsp'" class="btn btn-outline-success" id="carrello"><img src="img/cart2.png" id="carrellopic"></button>
       
      </ul>
           
          <%} if(session.getAttribute("log") == null){ %>
           <li class="nav-item">
              <a id="toplink" href="login.jsp" class="nav-link"><img src="img/user.svg" id="userpic">Login<img alt="mm" src="img/linea.svg" id="lineapic2"></a>
          </li>
          <li class="nav-item">
              <a id="toplink" href="registrazione.jsp" class="nav-link"><img src="img/newuser.svg" id="newuserpic">Registrati ora<img alt="mm" src="img/linea.svg" id="lineapic2"></a>
          </li>
           <li class="nav-item">
            <a id="toplink" href="contattaci.jsp" class="nav-link"><img src="img/info.svg" id="infopic">Contattaci<img alt="mm" src="img/linea.svg" id="lineapic3"></a>
        </li>
        <li class="nav-item">
        <%String username= (String) session.getAttribute("user"); %>
        <input type="hidden" id="hidden" name="user" value=<%=username%>>
           <button type="button"  onclick="window.location.href='login.jsp'" class="btn  btn-outline-success" id="wish"><img src="img/cuore2.png" id="cuorepic"></button>
    	   
          </li>
          <li class="nav-item">
            <button type="button" onclick="window.location.href='Carrello.jsp'" class="btn btn-outline-success" id="carrello"><img src="img/cart2.png" id="carrellopic"></button>
 		
 			
 			
          </li>
      </ul>
          <%} %>
         
  </div>
</nav>

<!-- example 8 - center logo on mobile, search right -->
<nav id="navbarbot" class="navbar navbar-expand-md">
  <div class="navbar-collapse collapse w-100 order-4 order-md-0 collapsenav">
      <ul class="navbar-nav mr-auto">
          <li class="nav-item">
              <a id="botlink" class="nav-link" href="Android.jsp">ANDROID</a>
          </li>
          <li class="nav-item">
              <a id="botlink" class="nav-link" href="Apple.jsp">iOS</a>
          </li>
          <li class="nav-item">
            <a id="botlink" class="nav-link" href="Cover.jsp">COVER</a>
          </li>
          <li class="nav-item">
            <a id="botlink" class="nav-link" href="Accessori.jsp">ACCESSORI</a>
          </li>
          <li class="nav-item">
            <a id="botlink" class="nav-link" href="Auricolari.jsp">AURICOLARI</a>
          </li>
          <li class="nav-item">
            <a id="botlink" class="nav-link" href="Offerte.jsp">OFFERTE</a>
          </li>
      </ul>
  </div>
  <div class="look">
  <form method='post' name='ricerca' action='CercaServlet'>
    <table border="0">
  
  <div class="w-100 d-flex flex-nowrap" id="cerca"> 
      <div class="w-100 d-md-none" id="sex">
          <button id="tastino2" class="navbar-toggler" type="button" data-toggle="collapse" data-target=".collapsenav"><img src="img/collapse.svg" id="collassopic">
          </button>
      </div>
      <div class="d-flex w-100 justify-content-end order-3">
          <class="d-flex flex-nowrap align-items-center">
             
              <svg style="display: none">
                <symbol id="magnify" viewBox="0 0 18 18" height="100%" width="100%">
                  <path d="M12.5 11h-.8l-.3-.3c1-1.1 1.6-2.6 1.6-4.2C13 2.9 10.1 0          6.5 0S0 2.9 0 6.5 2.9 13 6.5 13c1.6 0 3.1-.6 4.2-1.6l.3.3v.8l5 5          1.5-1.5-5-5zm-6 0C4 11 2 9 2 6.5S4 2 6.5 2 11 4 11 6.5 9 11 6.5            11z" fill="#fff" fill-rule="evenodd"/>
                </symbol>
              </svg>
              
              <div class="search-bar">
                
                <input type="text" class="input" placeholder="&nbsp;" name="barra">
                <span class="label">Cerca</span>
                <span class="highlight"></span>
                
                <div class="search-btn" id="lenteIng">
                <button type ="submit" id="bottoneRicerca"><svg class="icon icon-18">
                       <use xlink:href="#magnify"></use>
                      </svg></button>    
                  </div>
                  </form>
                </div>
                
              </div>
  </div>
  <tr><td></td><td><div id='box'

    style="width:300px"></div><td></td></tr>
    </table>
</form>
</div>
  
</nav>