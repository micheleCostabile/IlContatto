	function login(form){
		$.post("LoginServlet",$(form).serialize(),function(msg){
			
			var mess = JSON.parse(msg);
			
			if(mess.match("200")){
				$(window.location).attr('href', 'index.jsp');
			}
			else{
				$("#error").text(mess).css({"color":"red","padding-top":"20px",
					"margin-left":"30%"});
			}
		});
		
		return(false);
	}
	
	
	
	
	function blankLabel(){
		$("#error").text(' ');
	}