
var _current_cell;
var _current_direction;
var _current_grid;
var _end_cell;
var _start_cell; 
var _game_speed     = 800; 
var _notif_delay    = 2000;
var _time           = {
    [_mins] : 0,
    [_secs] : 0
}
var _timer_interval; // function that updates the timer every second
var _timeout        = 60; //minutes
var _levelid;