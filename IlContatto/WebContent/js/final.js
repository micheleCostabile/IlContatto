

function finalCart(size){
	var articoli = new Array();
	var i;
	var nam;
	var val;
	var elm = document.getElementsByClassName("articoli").length;
	for (i=0;i<elm;i++) {
		nam = document.getElementsByClassName("articoli")[i].name;
		val = document.getElementsByClassName("articoli")[i].value;
		console.log(val);
		articoli[i] = '"'+nam+'":"'+val+'"';
		console.log(articoli[i]);
	}
	
	var xxx = articoli.join();
	console.log(xxx)
	param = '{'+xxx+'}';
	
		$.post("FinalCarrelloServlet", {articoli:param});
}