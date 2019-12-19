
	$(document).ready(function(){
		  $("#addWishCard").click(function(){
		    $.ajax({
			url:"AddWishServlet",
			type: "POST",  	
			success:function(){} 
		     });
		  });
		});
	
	
	
	function addPref(codice){
		$.post("AddWishCardServlet", {codiceWish:codice}, function(){
			var modal = document.getElementById("myModal");
			var span = document.getElementsByClassName("close")[0];
			modal.style.display = "block";
			span.onclick = function() {
				  modal.style.display = "none";
				}
			window.onclick = function(event) {
				  if (event.target == modal) {
				    modal.style.display = "none";
				  }
				}
		});
		
	}
	
	
	function remPref(codice){
		$.post("RemoveFromWishServlet", {codProdo:codice}, function(){
			var modal = document.getElementById("myModal3");
			var span = document.getElementsByClassName("close")[2];
			
			modal.style.display = "block";
			
			span.onclick = function() {
				  modal.style.display = "none";
				  
				}
			
			window.onclick = function(event) {
				  if (event.target == modal) {
				    modal.style.display = "none";
				  }
				  
			}
			
			
	
		});
		
		
	}
	
	/* function gestisciPref(codice,i){
		 console.log(codice);
		if (i==2)	
			{
			addPref(codice);
			i=3;
			}
		else if(i==3) {
			remPref(codice);
			i=3
		}
		
		
	}*/
	
	
	function cambiaMod(img,i){
		var nome= $(img).context.currentSrc;
		if(nome.match("img/cuoreNeroVuoto.svg")) 
			{
				
				$(img).attr("src","img/cuoreNeroPieno.svg");
				i=3;
				return 0;
			}
		else if(nome.match("img/cuoreNeroPieno.svg")) 
			{
			
				$(img).attr("src","img/cuoreNeroVuoto.svg");
				i==2;
				return 1;
			}
		
		
	}
	
	
	function cambiaScritta(cod){
		var sc= $(cod).text();
		if(sc.match("Aggiungi a lista desideri")) {
		
			$(cod).html("Aggiunto");
		return 0;
		}
		else if(sc.match("Aggiunto")) { 
			$(cod).html("Aggiungi a lista desideri");
		return 1;
		}
		
	}
	
	function cuoreMod(img){
		
		$(img).attr("src","img/cuoreNeroPieno.svg");
		
		
	}
	
	
	function addCart(codice){
		$.post("AddCart2Servlet", {cart:codice}, function(){
			var modal = document.getElementById("myModal2");
			var span = document.getElementsByClassName("close")[0];
			modal.style.display = "block";
			span.onclick = function() {
				  modal.style.display = "none";
				}
			window.onclick = function(event) {
				  if (event.target == modal) {
				    modal.style.display = "none";
				  }
				}
		});
	}
	
	
	
	function openProduct(codice){
		$.get("ViewProductServlet",{codice:codice}, function(prod){
			$(window.location).attr('href', 'ProductView.jsp');
		});
	}

	
	function checkCart(qty, codice, qtyDb){
		
		var x = parseInt($("#selection").val());
		var res = x + qty;
		if(res > qtyDb){
			$("#void").text('Disponibilità massima superata').css({"color":"red"});
		}
		
		else if(res > 3) {
			$("#void").text('Quantità massima superata').css({"color":"red"});
		}
		
		else{
			$.post("AddCartServlet",{cart:codice,sel_value:x},function(){
				$(window.location).attr('href', 'Carrello.jsp');
			});
		}	
	}
	
	
function checkCart2(codice, qtyDb){
		
		var x = parseInt($("#selection").val());
		if(x > qtyDb){
			$("#void").text('Disponibilità massima superata').css({"color":"red"});
		}

		else{
			$.post("AddCartServlet",{cart:codice,sel_value:x},function(){
				$(window.location).attr('href', 'Carrello.jsp');
			});
		}	
	}
	
    
	