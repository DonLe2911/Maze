

function _add_icon(button, direction){
    var icon = document.createElement("i");
    $(icon).addClass("fas fa-chevron-"+direction);
    $(button).append(icon);
}

function _add_icon_ending(button){
    var icon = document.createElement("i");
    $(icon).addClass("fas fa-star");
    $(button).append(icon);
}

function _change_icon(button, direction, new_direction){
    $(button).find("i").removeClass("fas fa-chevron-"+direction);
    $(button).find("i").addClass("fas fa-chevron-"+new_direction);
}

function _clean_icon(button){
    $(button).find("i").remove();
}
 
function _disable_game_controls(){
    $("#execute").prop("disabled", true);
    $("#new_game").prop("disabled", true);
}

function _enable_game_controls(){
    $("#execute").prop("disabled", false);
    $("#new_game").prop("disabled", false);
}

function _get_instruction_type(instruction){
    switch(instruction){
        case _move_left:
        case _move_right:
        case _move_fw:
            return _move; break;
        case _jump_left:
        case _jump_right:
        case _jump_fw:
            return _jump; break;
    }
}

function _get_next_direction(instruction, direction){
    switch(instruction){
        case _move_left:
        case _jump_left:
            if(direction == _down)      return _right;
            else if(direction == _left) return _down;
            else if(direction == _right)return _up;
            else if(direction == _up)   return _left;
            break;
        case _move_right:
        case _jump_right:
            if(direction == _down)      return _left;
            else if(direction == _left) return _up;
            else if(direction == _right)return _down;
            else if(direction == _up)   return _right;
            break;
    }
    return direction;
}

function _get_repeat_instructions(instructions){
    // return everything (except instructions already included in another repeat instruction)
    for(var i= instructions.length; i> 0; i--){
        if(instructions[i] == _repeat && instructions.length != 1){
            return instructions.slice(i+1, instructions.length);
        }
    }
    return instructions;
}

// dispose of notification on close
function _init_notification_close(selector){
    $(selector).on('hidden.bs.modal', function (e) {
        $(selector).remove();
    });
}

function _init_timer(){
    if(_time[_mins] < _timeout){
        _update_timer(_time[_mins], _time[_secs]);
        if(_time[_secs] < 59){
            _time[_secs] += 1;
        }
        else{
            _time[_secs]  = 0;
            _time[_mins] += 1;
        }
    }
    else{
        clearInterval(_timer_interval);
    }
}

function _is_end(grid, x_coord, y_coord){
    return grid[_end][_x_coord] == x_coord && grid[_end][_y_coord] == y_coord;
}

function _is_in_paths(grid, x_coord, y_coord){
    return grid[_paths].some(item => item[_x_coord] == x_coord && item[_y_coord] == y_coord);
}

function _is_start(grid, x_coord, y_coord){
    return grid[_start][_x_coord] == x_coord && grid[_start][_y_coord] == y_coord;
}

function _move_coordinates(instruction_type, direction, x_coord, y_coord){
    var step = 0;
    if(instruction_type == _move) step = 1;
    else if(instruction_type == _jump) step = 2;
    switch(direction.toString()){
        case _down:
            return [x_coord, y_coord+step]; 
        case _left:
            return [x_coord-step, y_coord]; 
        case _right:
            return [x_coord+step, y_coord]; 
        case _up:
            return [x_coord, y_coord-step]; 
    }
    return [x_coord, y_coord];
}

function _reset_game(){
    // reset current position on the grid
    var button  = $("button["+_x_coord+"="+_current_cell[_x_coord]+"]"+
                          "["+_y_coord+"="+_current_cell[_y_coord]+"]");
    _clean_icon(button);
    var start_btn  = $("button["+_x_coord+"="+_current_grid[_start][_x_coord]+"]"+
                             "["+_y_coord+"="+_current_grid[_start][_y_coord]+"]");
    _add_icon(start_btn, _current_grid[_start][_direction]);
    // reset game variables
    _current_cell = { 
        [_x_coord]: _current_grid[_start][_x_coord],
        [_y_coord]: _current_grid[_start][_y_coord]
    };
    _current_direction = _current_grid[_start][_direction];
    // enable execute button again
    $("#execute").prop("disabled", false);
}

function _reset_timer(){
    clearInterval(_timer_interval);
    _time[_mins]    = 0;
    _time[_secs]    = 0;
    _init_timer();
    _timer_interval = setInterval(_init_timer, 1000);
}

function _show_notification(selector){
    $(selector).modal({
        keyboard: false,
        backdrop: 'static'
      });
    
    _init_notification_close(selector);
}

function _show_failure(notif_type){
    setTimeout(function(){
        $("body").append(Handlebars.templates[template_notification](notif_type));
        _show_notification("#notification-modal");
        _reset_game();
    }, _notif_delay);
}

function _show_success(){
    setTimeout(function(){
        $("body").append(Handlebars.templates[template_notification](success));
        _show_notification("#notification-modal");
    }, _notif_delay);
    clearInterval(_timer_interval); // stop timer
    // enable new game button
    $("#new_game").prop("disabled", false);
}

function _sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

function _update_timer(mins, secs){
    var mins_val = mins;
    var secs_val = secs;
    if(mins < 10){mins_val = "0"+mins;}
    if(secs < 10){secs_val = "0"+secs;}
    $("#timer").text(mins_val+":"+secs_val);
}

function countInArray(array, item) {
    var count = 0;
    for (var i = 0; i < array.length; i++) {
        if (array[i] === item) {
            count++;
        }
    }
    return count;
}