<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contattaci</title>
 <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/animate.css">
    
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1" /> <!--serve per far essere responsive anche la versione mobile-->
</head>

<body>
<%@ include file="Header.jsp" %>


<div  class="container-fluid">
  <div  class="content">

		 <img id="fallout" src="img/fallout.jpg"> 
	
  <hr>
    <h2><span>Reso facile</span></h2>
    
    <ul>
		  <li>Hai cambiato idea? No problem! Il reso è facile e veloce</li>
		  <li>Puoi fare il reso online</li>
  		  <li>Puoi effettuare il reso tramite posta o corriere</li>
  		  <li>Quando riceviamo il tuo reso, vieni rimborsato automaticamente</li>
  		  
	</ul>
		
		
</div>


  <div class="breadcrumb">
    <h4>Informazioni generali</h4>
  </div>
  </div>
<hr>
  <div class="container">
    <div class="row">
     
        <div class="col-xl-4">
          <div class="wow bounceIn" data-wow-offset="0" data-wow-delay="0.8s">
            <div class="align-center">
              <h4>Modalità di contatto</h4>
              <div class="icon">
                <i class="fa fa-heart-o fa-3x"></i>
              </div>
              <h6>
                Puoi contattarci 24h tutti i giorni, i nostri operatori risponderanno dall'Italia nel tempo più rapido possibile.
                <br>
                <br>
               <b> Email: ilcontattosrl@gmail.com </b>
                <br>
                <b>Telefono: +39 3483209519 </b>
              </h6>
              
            </div>
          </div>
          <hr>
        </div>
        <div class="col-xl-4">
          <div class="wow bounceIn" data-wow-offset="0" data-wow-delay="1.3s">
            <div class="align-center">
              <h4>Spedizioni</h4>
              <div class="icon">
                <i class="fa fa-desktop fa-3x"></i>
              </div>
              <h6>
                Spedizioni sempre gratuite. Ordini in arrivo entro un max. di 5 giorni lavorativi.<br><br><br><br><br>
                
              </h6>
             
            </div>
          </div>
          <hr>
        </div>
        <div class="col-xl-4">
          <div class="wow bounceIn" data-wow-offset="0" data-wow-delay="1.3s">
            <div class="align-center">
              <h4>Garanzia</h4>
              <div class="icon">
                <i class="fa fa-location-arrow fa-3x"></i>
              </div>
              <h6>
                I nostri prodotti sono coperti da garanzia italiana per 2 anni: non esitare a contattarci in caso di problemi!
                <br>  <br> <br> <br> 
              </h6>
             
            </div>
          </div>
          <hr>
        </div>

  
    </div>
  </div>
  <div class="container">
    <div class="row">
     
        <div class="col-xl-4">
          <div class="wow bounceIn" data-wow-offset="0" data-wow-delay="0.8s">
            <div class="align-center">
              <h4>Resi</h4>
              <div class="icon">
                <i class="fa fa-heart-o fa-3x"></i>
              </div>
              <h6>
               	Resi gratuiti entro 14 giorni dall'acquisto, possibilità di reso anche oltre il limite dei 14 giorni ma con lieve sovraprezzo.
               	<br><br><br> 
              </h6>
             
            </div>
          </div>
          <hr>
        </div>
        <div class="col-xl-4">
          <div class="wow bounceIn" data-wow-offset="0" data-wow-delay="1.3s">
            <div class="align-center">
              <h4>Alta qualità del servizio</h4>
              <div class="icon">
                <i class="fa fa-laptop fa-3x"></i>
              </div>
              <h6>
                Servizio chiaro e di alta qualità volto alla soddisfazione del cliente. :)
                <br> <br>  <br> <br>
              </h6>
              
            </div>
          </div>
          <hr>
        </div>
        <div class="col-xl-4">
          <div class="wow bounceIn" data-wow-offset="0" data-wow-delay="1.3s">
            <div class="align-center">
              <h4>Assistenza Rapida</h4>
              <div class="icon">
                <i class="fa fa-cloud fa-3x"></i>
              </div>
              <h6>
                Per una richiesta rapida ai nostri operatori, clicca sul link qui sotto.
                <br><br>
              </h6>
              <div class="ficon" id="chiedi">
                <a href="" alt="">Chiedi qui</a>
              </div>
            </div>
          </div>
          <hr>
        </div>

    </div>
  </div>
<hr>
<div class="container-fluid">
  <div class="breadcrumb">
    <h4>About Us</h4>
    </div>
    <br>
    <div class="container-fluid">
    	
    	<div id="ammammdpic">
    	<img id ="ammammd" src="img/apazz.jpg">
    	</div>
    	<div id ="descrtxt">
    
    		<h6 id="textmu"> I tre creatori del sito: <br>Gianluca Spinelli, Michele Costabile, Fiorenzo Carino. <br>Studenti presso il dipartimento di informatica di UNISA</h6>
    
    	</div>
    
    
    
    </div>
   
  
    
  </div>
 <hr>

<%@ include file="FacebookSDK.jsp" %>
<%@ include file="Footer.jsp" %>
<script src="js/jquery.min.js"></script>
   <script src="js/bootstrap.min.js"></script>
<script src="js/wow.min.js"></script>
  <script>
    wow = new WOW({}).init();
  </script>
</body>
</html>