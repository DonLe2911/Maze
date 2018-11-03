var websocket = new WebSocket(_path_websocket);

var ws_send_timer = {
    [_code] : 3,
    [_success] : 4,
    [_failure] : 0
};

window.onbeforeunload = function() {
    websocket.onclose = function(){};
    websocket.close();
}

function websocket_send(object) {
    var json_string = JSON.stringify(object);
    websocket.send(json_string);
}

// RECEIVE

websocket.onmessage = function process_message(content){
	var container1	= ".info_panel";
	var object 		= JSON.parse(content.data);
	var code		= object[_code];
	
	switch(code){ 
	/* general response */
	case ws_send_timer[_failure]:
		$(container1).prepend(_get_template(template_alert, _notif_store_time_error)); break;
	case _failure:
		$(container1).prepend(_get_template(template_alert, _notif_unexpected)); break;
	}
}

