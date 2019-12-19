<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import = "model.ProductBean" %>
    <%@ page import = "model.CarrelloBean" %>
	<%@	page import = "model.ProductDAO" %>
	<%@	page import = "model.ClienteDAO" %>
	<%@	page import = "java.util.ArrayList" %>
	
	<%
	
	ProductDAO pd = new ProductDAO();
	int cod = Integer.parseInt(request.getParameter("codice"));
	ProductBean prodotto = pd.doRetrieveByKey(cod);
	%>
<!DOCTYPE html>
<html >
<head>

    <meta charset="UTF-8">
    
    
    <title>IlContatto</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
   
    
    <meta name="viewport" content="width=device-width, initial-scale=1" /> <!--serve per far essere responsive anche la versione mobile-->
<script>	
function magnify(imgID, zoom) {
  var img, glass, w, h, bw;
  img = document.getElementById(imgID);
  /*create magnifier glass:*/
  glass = document.createElement("DIV");
  glass.setAttribute("class", "img-magnifier-glass");
  /*insert magnifier glass:*/
  img.parentElement.insertBefore(glass, img);
  /*set background properties for the magnifier glass:*/
  glass.style.backgroundImage = "url('" + img.src + "')";
  glass.style.backgroundRepeat = "no-repeat";
  glass.style.backgroundSize = (img.width * zoom) + "px " + (img.height * zoom) + "px";
  bw = 3;
  w = glass.offsetWidth / 2;
  h = glass.offsetHeight / 2;
  /*execute a function when someone moves the magnifier glass over the image:*/
  glass.addEventListener("mousemove", moveMagnifier);
  img.addEventListener("mousemove", moveMagnifier);
  /*and also for touch screens:*/
  glass.addEventListener("touchmove", moveMagnifier);
  img.addEventListener("touchmove", moveMagnifier);
  function moveMagnifier(e) {
    var pos, x, y;
    /*prevent any other actions that may occur when moving over the image*/
    e.preventDefault();
    /*get the cursor's x and y positions:*/
    pos = getCursorPos(e);
    x = pos.x;
    y = pos.y;
    /*prevent the magnifier glass from being positioned outside the image:*/
    if (x > img.width - (w / zoom)) {x = img.width - (w / zoom);}
    if (x < w / zoom) {x = w / zoom;}
    if (y > img.height - (h / zoom)) {y = img.height - (h / zoom);}
    if (y < h / zoom) {y = h / zoom;}
    /*set the position of the magnifier glass:*/
    glass.style.left = (x - w) + "px";
    glass.style.top = (y - h) + "px";
    /*display what the magnifier glass "sees":*/
    glass.style.backgroundPosition = "-" + ((x * zoom) - w + bw) + "px -" + ((y * zoom) - h + bw) + "px";
  }
  function getCursorPos(e) {
    var a, x = 0, y = 0;
    e = e || window.event;
    /*get the x and y positions of the image:*/
    a = img.getBoundingClientRect();
    /*calculate the cursor's x and y coordinates, relative to the image:*/
    x = e.pageX - a.left;
    y = e.pageY - a.top;
    /*consider any page scrolling:*/
    x = x - window.pageXOffset;
    y = y - window.pageYOffset;
    return {x : x, y : y};
  }
}
</script>
</head>










	
 <body> 

 	<%@ include file="Header.jsp" %>
 	<section class="section-content bg padding-y-sm">
<div class="container">
<nav class="mb-3">
<ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
    <li class="breadcrumb-item"><a href="<% String conf=(String) prodotto.getMarca();
    										String conf2=(String) prodotto.getTipologia();
    										if(conf.equalsIgnoreCase("Apple") && conf2.equalsIgnoreCase("Smartphone") ) out.println("Apple"); 
    
    										else 
    											{	if(conf2.equalsIgnoreCase("Smartphone")) out.println("Android");
    										else if(conf2.equalsIgnoreCase("Accessori")) out.println("Accessori");
    											if(conf2.equalsIgnoreCase("Cover")) out.println("Cover");
    										else if(conf2.equalsIgnoreCase("Auricolari")) out.println("Auricolari");
    											}%>.jsp"><%
    										if(conf.equalsIgnoreCase("Apple")&& conf2.equalsIgnoreCase("Smartphone")) out.println("iOS"); 
    										else {
    											if(conf2.equalsIgnoreCase("Cover")) out.println("Cover");
    											else if(conf2.equalsIgnoreCase("Accessori")) out.println("Accessori");
    											else if(conf2.equalsIgnoreCase("Auricolari")) out.println("Auricolari");
    											else out.println("Android");} %>
    										
    										</a></li>
    <li class="breadcrumb-item active" aria-current="page"><%=prodotto.getNome() %></li>
</ol> 
</nav>

<div class="row">
<div class="col-xl-10 col-md-9 col-sm-12">


<main class="card">
	<div class="row no-gutters">
		<aside class="col-md-6 border-right">
<article class="gallery-wrap"> 
<div class="img-big-wrap">
  <div class="img-magnifier-container"> <a href="<%=prodotto.getImmagine() %>" data-fancybox=""><img id="imgPrincProdotto" src=<%=prodotto.getImmagine() %>></a></div>
</div>
	
	<script>
	magnify("imgPrincProdotto", 3);
	</script>


<div class="img-small-wrap">
  <div class="item-gallery"> <img src="<%//=prodotto.getImmagine() %>"></div>
  <div class="item-gallery"> <img src="<%//=prodotto.getImmagine() %>"></div>
  <div class="item-gallery"> <img src="<%//=prodotto.getImmagine() %>"></div>
  <div class="item-gallery"> <img src="<%//=prodotto.getImmagine() %>"></div>
</div> <!-- slider-nav.// -->
</article> <!-- gallery-wrap .end// -->
		</aside>
		<aside class="col-md-6">
<article class="card-body">
<!-- short-info-wrap -->
	<h3 class="title mb-3"><%=prodotto.getNome() %></h3>

<div class="mb-3"> 
	<var class="price h3 text-warning"> 
		<%if(prodotto.getPrezzoScontato()>0){
			%>
			<h5><del class="price-old">&#8364 <%=prodotto.getPrezzo()%></del></h5>
			<span class="currency">&#8364 </span><span class="num"><%=prodotto.getPrezzoScontato()%></span>
		<%}else{%>
		
		<span class="currency">&#8364 </span><span class="num"><%=prodotto.getPrezzo()%></span>
		<%} %>
	</var> 
	<span>/l'uno</span> 
</div> <!-- price-detail-wrap .// -->
<dl>
  <dt></dt>
  <%boolean disp= true;
  if(prodotto.getPezzi()>0){ %>
  <dd><p><h4><b>Disponibili : <%=prodotto.getPezzi() %> pezzi</b></h4></p></dd>
  <%} else { disp=false;%>
  <dd><p><h4 style="color:red"><b>Non Disponibile al momento</b></h4></p></dd>
  <%} %>
</dl>
<dl class="row">
  <dt class="col-md-3">Marca</dt>
  <dd class="col-md-9"><%=prodotto.getMarca() %></dd>

  <dt class="col-md-3">Colore</dt>
  <dd class="col-md-9"><%=prodotto.getColore() %></dd>

  <dt class="col-md-3">Modello</dt>
  <dd class="col-md-9"><%=prodotto.getModello() %></dd>
</dl>
<div class="rating-wrap">


	<div class="label-rating"></div>
	<div class="label-rating"></div>
</div> <!-- rating-wrap.// -->
<hr>
<form name="carr" method="post" action="AddCartServlet">
	<div class="row">
		<div class="col-md-5">
			<dl class="dlist-inline">
			  <dt>Quantità: </dt>
			  <dd> 
			  	<select name="qty1" onchange="aggiornaHidden(this)" class="form-control form-control-sm" style="width:70px;">
			  		<option>1</option>
			  		<option>2</option>
			  		<option>3</option>
			  	</select>
			  </dd>
			</dl>  <!-- item-property .// -->
		</div> <!-- col.// -->
		
	</div> <!-- row.// -->
	<hr>
	<div class="addList">
	
	<input type="hidden" id="hidden" name="cart" value=<%=prodotto.getCodice()%>>
	<input type="hidden" name="sel_value" value="1" id="selection">
	<%if(disp){ %>
	
	<%
		if(session.getAttribute("carrello")!= null){
			CarrelloBean carrello = (CarrelloBean)session.getAttribute("carrello");
			int i;
			for(i = 0 ; i < carrello.getCarrello().size() ; i++){
				ProductBean p = carrello.getCarrello().get(i);
				if(p.getCodice() == prodotto.getCodice()){%> 
					<div><button type="button" class="btn  btn-warning" id ="carrBott" onclick="checkCart(<%=p.getQty()%>,<%=p.getCodice()%>, <%=p.getPezzi()%>)" >  Aggiungi al carrello </button></div>
					<h6 id="void"></h6>
					
			<% break;}
			}if(i == carrello.getCarrello().size()){%>
				<div><button type="button" class="btn  btn-warning" id ="carrBott" onclick="checkCart2(<%=prodotto.getCodice()%>, <%=prodotto.getPezzi()%>)" >  Aggiungi al carrello </button></div>
			<%}
			
		} 
		
		else{ %>
			<div><button type="button" class="btn  btn-warning" id ="carrBott" onclick="checkCart2(<%=prodotto.getCodice()%>, <%=prodotto.getPezzi()%>)" >  Aggiungi al carrello </button></div>
		<%}} else{%>
		
		
	<div><button type="button" class="btn  btn-warning">  Impossibile acquistare </button></div>
    <%} %>
	</form>
    <form id="formWish" method="post" action="AddWishServlet">
	<%String username2= (String) request.getSession().getAttribute("user"); %>
	
	<input type="hidden" name="user" value=<%=username2%>>
	<input type="hidden" id="hidden" name="wish" value=<%=prodotto.getCodice()%>>
	<% ClienteDAO pes = new ClienteDAO(); %>
	<%session.setAttribute("codiceWish", prodotto.getCodice()); 
	if(session.getAttribute("log") != null && pes.controllaPref(username2,prodotto.getCodice())==false) {%>
		<div id="bottoneWish"><button type="button" class="btn  btn-outline-warning" id="addWishCard" onclick="cambiaScritta(this)">Aggiungi a lista desideri</button></div>
	<%}
    else if(session.getAttribute("log") != null && pes.controllaPref(username2,prodotto.getCodice())==true) {%>
	<div id="bottoneWish"><button type="button" class="btn  btn-outline-warning" id="addWishCard" onclick="cambiaScritta(this)">Aggiunto</button></div>
    <%}

	
	else{%>
		<div id="bottoneWish"><button type="button" class="btn  btn-outline-warning" onclick="window.location.href='login.jsp'"> Aggiungi a lista desideri </button></div>
	<%} %>
	
	</form>
	</div>
<!-- short-info-wrap .// -->
</article> <!-- card-body.// -->
		</aside> <!-- col.// -->
	</div> <!-- row.// -->
</main> <!-- card.// -->

<!-- PRODUCT DETAIL -->
<article class="card mt-3">
	<div class="card-body">
		<h4>Dettagli prodotto</h4>
	<p>	<%=prodotto.getDescrizione()%></p>
	</div> <!-- card-body.// -->
</article> <!-- card.// -->

<!-- PRODUCT DETAIL .// -->

</div> <!-- col // -->
<aside class="col-xl-2 col-md-3 col-sm-12">
<div class="card">
	<div class="card-header">
	    Informazioni spedizione
	</div>
	<div class="card-body small">
		 <span>Italia | Bartolini</span> 
		 <hr>
		 Sicurezza transazioni: Ottima <br> 
		 Supplemento spedizione: Nessuna  
		 <hr>
		 Reso entro 15 giorni
		 <hr>
		 Rispondiamo in 2h <br>
		 Valutazione risposte: 94%  <br> 
		 <hr>
		 
		 
	</div> <!-- card-body.// -->
</div> <!-- card.// -->

</aside> <!-- col // -->
</div> <!-- row.// -->


<hr>
</div><!-- container // -->
</section>
 	<%@ include file="FacebookSDK.jsp" %>
 	<%@ include file="Footer.jsp" %>
	  <script src="js/jquery.min.js"></script>
	  <script src ="js/card.js"></script>
	  <script src ="js/bootstrap.min.js"></script>
	  <SCRIPT type="text/javascript">
 function aggiornaHidden(sel){
  var f = document.carr;
  f.sel_value.value = sel.options[sel.selectedIndex].value;
 }
</SCRIPT>
  
 </body>
 
 </html>



