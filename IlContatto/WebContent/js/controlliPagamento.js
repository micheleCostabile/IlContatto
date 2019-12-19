function controlliPag(form){
	
	if(validation()){
		
		pay(form);
		
		
	}
	
}

function pay(form){
	$.post("PagaServlet",$(form).serialize(),function(){
		
	
			$(window.location).attr('href', 'Fattura.jsp');
		
		
	});
	
	return(false);
}


function validationCvv(){
	var c= $("#cvv").val();
	var regex= /^[0-9]{3,4}$/;
	if(c.match(regex)){
		return true
		
	}
	else{
		$("#errorCvv").text('Il cvv è lungo 3 o 4 cifre').css({"color":"red"
			});
		return false;
		
	}
}


function validationCard(){
	var c= $("#card-number").val();
	var regex=  /^(?:4[0-9]{12}(?:[0-9]{3})?|[25][1-7][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\d{3})\d{11})$/;
	if(c.match(regex)){
		return true
		
	}
	else{
		$("#errorCard").text('Lunghezza massima 16. Scrivi correttamente il codice della card.').css({"color":"red"
			});
		return false;
		
	}
}



function validation(){
	
	var nomec =  $("#card-holder-name").val();
	var card =  $("#card-number").val();
	var cvv =  $("#cvv").val();
	var verify= true;

	
	
	if(nomec == "" || nomec==" "){
		$("#errorNc").text('Campo obbligatorio').append("<br />").css({"color":"red"
			});
		verify = false;
	}
	
    
	if(card == "" || card==" "){
			$("#errorCard").text('Campo obbligatorio').append("<br />").css({"color":"red"
				});
			verify = false;
		}
	
	else{validationCard();}
	
		
	if(cvv == "" || cvv==" "){
		$("#errorCvv").text('Campo obbligatorio').append("<br />").css({"color":"red"
			});
		verify = false;
	}
	else{validationCvv();}
	
	return verify;
	
}


function blanks(){
	$("#errorNc").text('');
	$("#errorCard").text('');
	$("#errorCvv").text('');
	
}



