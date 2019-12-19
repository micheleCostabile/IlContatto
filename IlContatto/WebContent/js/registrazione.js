
function validate(form){
	
	if(required()){
		
		registrazione(form);
		
		
	}
	
}

function registrazione(form){
	$.post("RegServlet",$(form).serialize(),function(msg){
		
		if(msg == 200){
			$(window.location).attr('href', 'RegSuccesso.jsp');
		}
		else{
			$("#errorus").text('Utente già registrato').append(", "+"<a id="+"'accediUtenteFromReg'"+"href="+"login.jsp"+">ACCEDI</a>").css({"color":"red","padding-top":"10px",});
			
		}
	});
	
	return(false);
}


function validationPsw(){
	var password =  $("#inputPassword4").val();
	var regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[.!@#\$%\^&\*])(?=.{8,16})/ ;
	if(password.match(regex)){
		return true
		
	}
	else{
		$("#errorPW").text('Password non valida').css({"color":"red"
			});
		return false;
		
	}
}


function validationCF(){
	var cf =  $("#inputCf").val();
	var regex = /^.{16}$/;
	if(cf.match(regex)){
		return true;
	}
	else{
		$("#errorCF").text('CF non valido').css({"color":"red"
			});
		return false;
	}
}

function validationMail(){
	var password =  $("#inputEmail4").val();
	var regex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/ ;
	if(password.match(regex)){
		return true;
	}
	else{
		$("#errorEmail").text('Email non valida').css({"color":"red"
			});
		return false;
	}
}


function validationZip(){
	var zip =  $("#inputZip").val();
	var regex = /^\d{5}$/ ;
	if(zip.match(regex)){
		return true
		
	}
	else{
		$("#errorZip").text('Zip non rispetta i parametri').css({"color":"red"
			});
		return false;
		
	}
}


function required(){
	
	var nome =  $("#nome").val();
	var cognome =  $("#cognome").val();
	var email =  $("#inputEmail4").val();
	var password =  $("#inputPassword4").val();
	var indirizzo =  $("#inputAddress").val();
	var username =  $("#inputusr").val();
	var stato =  $("#inputState").val();
	var city =  $("#inputCity").val();
	var zip =  $("#inputZip").val();
	var cf =  $("#inputCf").val();
	var verify= true;

	
	
	if(nome == "" || nome==" "){
		$("#errorName").text('Campo obbligatorio').append("<br />").css({"color":"red"
			});
		verify= false;
	}

    
	if(cognome == "" || cognome==" "){
			$("#errorSurname").text('Campo obbligatorio').append("<br />").css({"color":"red"
				});
			verify= false;
		}
		
	if(password == "" || password==" "){
		$("#errorPW").text('Campo obbligatorio').append("<br />").css({"color":"red"
			});
		verify= false;
	}
	else{validationPsw();}
	
	if(email == "" || email==" "){
		$("#errorEmail").text('Campo obbligatorio').append("<br />").css({"color":"red"
			});
		verify= false;
	}
	else{validationMail();}
		 			
						
	if(indirizzo == "" || indirizzo==" "){
							$("#errorAddress").text('Campo obbligatorio').append("<br />").css({"color":"red"
								});
							verify= false;
						}
						
						
							
	if(username == "" || username==" "){
								$("#errorus").text('Campo obbligatorio').append("<br />").css({"color":"red"
									});
								verify= false;
							}
							
							
	if(stato == "" || stato==" "){
									$("#errorState").text('Campo obbligatorio').append("<br />").css({"color":"red"
										});
									verify= false;
								}
								
								
	if(city == "" || city==" "){
										$("#errorCity").text('Campo obbligatorio').append("<br />").css({"color":"red"
											});
										verify= false;
									}
									
									
										
	if(zip == "" || zip==" "){
											$("#errorZip").text('Campo obbligatorio').append("<br />").css({"color":"red"
												});
											verify= false;
										}
	
	else{validationZip();}
	
	
	if(cf == "" || cf== " "){
		$("#errorCF").text('Campo obbligatorio').append("<br />").css({"color":"red"
			});
		verify= false;
	}

	else{validationCF(cf);}
										
										
	if($('#gridCheck1').prop("checked") == false){
												$("#errorCheck1").text('È necessario spuntare questa casella').css({"color":"red","padding-top":"10px"
													});
												verify= false;
											}
											
										
	if($('#gridCheck2').prop("checked") == false){
											$("#errorCheck2").text('È necessario spuntare questa casella').css({"color":"red","padding-bottom":"15px"
														});
													verify= false;
												}
												
		return verify;										
											
		
	}
	
	






function blankLabel(id1,id2){
	$('#'+id1).text(' ');
	$('#'+id2).text(' ');
}


