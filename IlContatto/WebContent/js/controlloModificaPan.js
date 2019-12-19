/**
 * 
 */

function controllaMod(form){
	
	if(validationMod()){
		
		mod(form);
		
		
	}
	
}




function mod(form){
	$.post("ModProductServlet",$(form).serialize(),function(msg){
		
		if(msg == 200){
			$(window.location).attr('href', 'Protected.jsp');
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
		$("#errorNomeM").text('Troppo lungo, lunghezza massima 45').css({"color":"red"
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
				$("#errorPrezM").text('Devi usare il punto').css({"color":"red"
			});
		return false;
		
					}
		}
}


function validationPrezSc(){
	var c= $("#ps").val();
	var x=c.includes(".");
	if(x==true)
		return true
		
	
	else{
		
		x=c.includes(",");
		if(x==true) {
				$("#errorPrezzoScontatoM").text('Devi usare il punto').css({"color":"red"
			});
		return false;
		
					}
		}
}




function validationPath(){
	
	var c=$("#immagine").val();
	var regex= /^([A-z0-9-_+]+\/)*([A-z0-9]+\.(png|svg|jpeg|jpg))$/gm;
	if(c.match(regex)){
		return true
		
	}
	else{
		$("#errorImgM").text('Path errato, riprova').css({"color":"red"
			});
		return false;
		
	}
}



function validationMod(){
	
	var nom =  $("#NomProdott").val();
	var prez =  $("#prezz").val();
	var iva =  $("#iva").val();
	var pezzi =  $("#nPezzi").val();
	var immagine =  $("#immagine").val();
	var colore =  $("#colore").val();
	var prezzosc= $("#ps").val();
	var verify= true;

	
    
	if(nom == "" || nom==" "){
			$("#errorNomeM").text('Campo obbligatorio').append("<br />").css({"color":"red"
				});
			verify= false;
		}
	else{validationNom();}
		 			
						
	if(prez == "" || prez==" "){
							$("#errorPrezM").text('Campo obbligatorio').append("<br />").css({"color":"red"
								});
							verify= false;
						}
	else{validationPrez();}
						
						
							
	if(iva == "" || iva==" "){
								$("#errorIvaM").text('Campo obbligatorio').append("<br />").css({"color":"red"
									});
								verify= false;
							}
							
							
	if(pezzi == "" || pezzi==" "){
									$("#errorNumM").text('Campo obbligatorio').append("<br />").css({"color":"red"
										});
									verify= false;
								}
	
								
								
	if(immagine == "" || immagine==" "){
										$("#errorImgM").text('Campo obbligatorio').append("<br />").css({"color":"red"
											});
										verify= false;
									}
	else{ validationPath();}
									
									
										
	if(colore == "" || colore==" "){
											$("#errorColM").text('Campo obbligatorio').append("<br />").css({"color":"red"
												});
											verify= false;
										}
	
	if(prezzosc!= "" && prezzosc!=" " && prezzosc != "0.0"){
		
		validationPrezSc();

		
	}
										
												
	return verify;										
											
		
	}
	
	






function blankLabel2(id1){
	$('#'+id1).text(' ');
	
}



