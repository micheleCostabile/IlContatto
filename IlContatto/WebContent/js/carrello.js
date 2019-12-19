//Funzione per arrotondamento a due cifre decimali e aggiunta di zeri
function cifre_decimali(x) {
var c = String(Math.round(x*100));
while (c.length < 3) c = '0' + c;
return c.replace(/([0-9][0-9])$/,".$1");
}
//Funzione per l'aggiornamento in tempo reale del costo totale degli articoli



function calcola(indice){
	
	var sub = document.getElementsByClassName("subTot")[indice].value;

	var prezzo = document.getElementsByClassName("prezzo")[indice].value;

	var articoli = document.getElementsByClassName("articoli")[indice].value;

	sub = cifre_decimali(prezzo * articoli);
	
	document.getElementsByClassName("subTot")[indice].value = sub;
	
	var subs = 0.00;

	for(var i = 0; i < document.getElementsByClassName("subTot").length;i++){
		
		subs = parseFloat(document.getElementsByClassName("subTot")[i].value) + subs;
		
	}
	
	document.getElementById("tot").value = cifre_decimali(subs);		
	var tot = document.getElementById("tot").value;
	$.post("FinalCarrelloServlet", {num:articoli,indice:indice,tot:tot});
}


