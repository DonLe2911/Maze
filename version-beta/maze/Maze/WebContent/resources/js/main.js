function init_execution(){
    $("#execute").click(function(){
        var instructions = get_instructions();
        var [valid,error_msg] = are_valid_instructions(instructions);
        if(valid){
            run_instructions(instructions);
            _disable_game_controls();
        }
        else{
            _show_failure(error_msg);
        }
    });
}

function init_run_new_game(){
    $("#new_game").click(function(){
        _reset_game();
        // add icon ending cell
        var end_button = $("button["+_x_coord+"="+_current_grid[_end][_x_coord]+"]"+
                                 "["+_y_coord+"="+_current_grid[_end][_y_coord]+"]");
        _clean_icon(end_button); 
        _add_icon_ending(end_button);
        _reset_timer();
        $(this).prop("disabled", true);
    });
}

function init_signout(error_container){
	$("#signout").click(function(){
		$.ajax({
	        type	: "POST",
	        url		: _path_signout,
	        success : function (result){
	        	switch(result){
	        	case _unexpected: 
	        		$(error_container).prepend(_get_template(template_alert, _notif_unexpected)); break;
	        	case _success:
	        		window.open(_root, "_self"); break;
	        	}
	        }
	   });
	});
}

function get_instructions(){
    // return [_move_left, _move_right, _repeat, _move_left, _move_right, _repeat];
    var textBox = document.getElementById("input-instructions");
    // split by new line delimiter
    var lines = textBox.value.split("\n");
    // returns all including empty new lines
    lines.map(a => a.toLowerCase());
    // filter out empty string
    instructions = lines.filter(String);
    // remove whitespaces from beginning and end
    instructions = instructions.map(function(a) {return a.replace(/^\s+/g, ''); } ).map(function(a) {return a.replace(/\s*$/,''); } );
    
    return instructions;
}

function record_time() {
    var user_time = _get_time_in_secs(_time);
    websocket_send({
        [_code]: ws_send_timer[_code],
        [_secs]:user_time,
        [_level]: _levelid
    });
}
