$(document).ready(function(){ 
    init_connect();
    init_signout("#welcome");
});

function init_connect(){
	$("#play").click(function(){
		attempt_connect();
	});
}
 
function attempt_connect(){
	var username 			= $.trim($("input[name="+_username+"]").val());
	connect({[_username]:username});
	/*
	var [is_valid, message]	= is_valid_username(username);
	
	if(is_valid){
		connect({[_username]:username});
	}
	else{
		$(".run").prepend(_get_template(template_alert, message));
	}*/
}

function connect(object){
	var root = ".run";
	$.ajax({ 
        type	: "POST",
        url		: _path_connect,
        data	: object,
        success : function (result){
        	switch(result){
        	case _empty: 
        		$(root).prepend(_get_template(template_alert, _notif_empty)); break;
        	case _invalid: 
        		$(root).prepend(_get_template(template_alert, _notif_invalid_username)); break;
        	case _unexpected: 
        		$(root).prepend(_get_template(template_alert, _notif_unexpected)); break;
        	case _success:
        		window.open(_path_level1, "_self"); break;
        	}
        }
   });

}