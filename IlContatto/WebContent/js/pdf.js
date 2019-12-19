function genPDF() {
	
	var doc = new jsPDF();
	  
    doc.addHTML($('body'),20,20,{
                 'width':500,
    });
	
	doc.save('Test.pdf');
	
}