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