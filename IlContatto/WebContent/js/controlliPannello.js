/**
 * 
 */

function controlla(form){
	
	if(validation()){
		
		add(form);
		
		
	}
	
}

function controlla2(form){
	
	if(validation()){
		
		add2(form);
		
		
	}
	
}


function add(form){
	$.post("AddProductServlet",$(form).serialize(),function(msg){
		
		if(msg == 200){
			$(window.location).attr('href', 'Protected.jsp');
		}
		else{
			$("#erroreIns").text('Prodotto già esistente').css({"color":"red","padding-top":"10px",});
			
		}
	});
	
	return(false);
}

function add2(form){
	$.post("ModProductServlet",$(form).serialize(),function(msg){
		
		if(msg == 200){
			$(window.location).attr('href', 'Protected.jsp');
		}
		else{
			$("#erroreIns").text('Prodotto già esistente').css({"color":"red","padding-top":"10px",});
			
		}
	});
	
	return(false);
}


function validationNom(){
	var c= $("#NomProdott").val();
	var regex= /^.{1,45}$/;
	if(c.match(regex)){
		return true
		
	}
	else{
		$("#errorNome").text('Troppo lungo, lunghezza massima 45').css({"color":"red"
			});
		return false;
		
	}
	
}


function validationMarca(){
	var c= $("#marca").val();
	var regex1= /^([^0-9]*)$/;
	var regex2= /^[A-Za-z]{1,45}$/;
	if(c.match(regex1) && c.match(regex2)){
		return true
		
	}
	else{
		$("#errorMarca").text('Non può contenere numeri').css({"color":"red"
			});
		return false;
		
	}
}


function validationPrez(){
	var c= $("#prezz").val();
	var x=c.includes(".");
	if(x==true)
		return true
		
	
	else{
		
		x=c.includes(",");
		if(x==true) {
				$("#errorPrez").text('Devi usare il punto').css({"color":"red"
			});
		return false;
		
					}
		}
}

function validationModello(){
	var c= $("#modello").val();
	var regex=  /^.{1,45}$/;
	if(c.match(regex)){
		return true
		
	}
	else{
		$("#errorMod").text('Troppo lungo, lunghezza massima 45').css({"color":"red"
			});
		return false;
		
	}
}


function validationPath(){
	
	var c=$("#immagine").val();
	var regex= /^([A-z0-9-_+]+\/)*([A-z0-9]+\.(png|svg|jpeg|jpg))$/gm;
	if(c.match(regex)){
		return true
		
	}
	else{
		$("#errorImg").text('Che cazz e path e mis').css({"color":"red"
			});
		return false;
		
	}
}



function validation(){
	
	var cod =  $("#codProdot").val();
	var nom =  $("#NomProdott").val();
	var marca =  $("#marca").val();
	var modello =  $("#modello").val();
	var prez =  $("#prezz").val();
	var iva =  $("#iva").val();
	var pezzi =  $("#nPezzi").val();
	var immagine =  $("#immagine").val();
	var colore =  $("#colore").val();
	var desc = $("#form7").val();
	var verify= true;

	
	
	if(cod == "" || cod==" "){
		$("#errorCod").text('Campo obbligatorio').append("<br />").css({"color":"red"
			});
		verify= false;
	}
	
    
	if(nom == "" || nom==" "){
			$("#errorNome").text('Campo obbligatorio').append("<br />").css({"color":"red"
				});
			verify= false;
		}
	else{validationNom();}
		
	if(marca == "" || marca==" "){
		$("#errorMarca").text('Campo obbligatorio').append("<br />").css({"color":"red"
			});
		verify= false;
	}
	else{validationMarca();}
	
	if(modello == "" || modello==" "){
		$("#errorMod").text('Campo obbligatorio').append("<br />").css({"color":"red"
			});
		verify= false;
	}
	else{validationModello();}
		 			
						
	if(prez == "" || prez==" "){
							$("#errorPrez").text('Campo obbligatorio').append("<br />").css({"color":"red"
								});
							verify= false;
						}
	else{validationPrez();}
						
						
							
	if(iva == "" || iva==" "){
								$("#errorIva").text('Campo obbligatorio').append("<br />").css({"color":"red"
									});
								verify= false;
							}
							
							
	if(pezzi == "" || pezzi==" "){
									$("#errorNum").text('Campo obbligatorio').append("<br />").css({"color":"red"
										});
									verify= false;
								}
	
								
								
	if(immagine == "" || immagine==" "){
										$("#errorImg").text('Campo obbligatorio').append("<br />").css({"color":"red"
											});
										verify= false;
									}
	else{ validationPath();}
									
									
										
	if(colore == "" || colore==" "){
											$("#errorCol").text('Campo obbligatorio').append("<br />").css({"color":"red"
												});
											verify= false;
										}
	
	if(desc == "" || desc==" "){
		$("#errorDesc").text('Campo obbligatorio').append("<br />").css({"color":"red"
			});
		verify= false;
	}
										
												
		return verify;										
											
		
	}
	
	






function blankLabel2(id1){
	$('#'+id1).text(' ');
	
}



