
// keys
var _code       = "code";
var _direction  = "direction";
var _empty		= "empty";
var _end        = "end";
var _failure    = "failure";
var _height     = "height";
var _invalid	= "invalid";
var _level      = "levelid"
var _mins       = "minutes";
var _path       = "path";
var _paths      = "paths";
var _secs       = "seconds";
var _start      = "start";
var _success    = "success";
var _unexpected	= "unexpected";
var _username	= "username";
var _wall       = "wall";
var _width      = "width";
var _x_coord    = "x";
var _y_coord    = "y";

// directions (MUST BE KEPT AS IT IS FOR FONTAWESOME CLASS NAMES)
var _down   = "down";
var _left   = "left";
var _right  = "right";
var _up     = "up";

// instructions 
var _move           = "move";
var _move_left      = _move+" "+_left;
var _move_right     = _move+" "+_right;
var _move_fw        = _move+" forward";
var _jump           = "jump";
var _jump_left      = _jump+" "+_left;
var _jump_right     = _jump+" "+_right;
var _jump_fw        = _jump+" forward";
var _repeat         = "repeat";
var _instruction_ls = [_move_left, _move_right, _move_fw, _jump_left, _jump_right, _jump_fw, _repeat];

// settings
var _repeat_count = 2;

var _instruction_limit = 2;

// templates
var template_notification = "notification.hbs";
var template_alert		  = "alert.hbs";

// Notifications
var invalid_input = {
    notification_title : "Invalid input",
    notification_body : "Please check your input uses only the instructions allowed",
    notification_btn : "Try Again"
}

var fail = {
    notification_title : "You lost",
    notification_body : "Your solution does not reach the end of the maze.",
    notification_btn : "Try Again"
}

var instruction_limit_exceeded = {
    notification_title : "Invalid input",
    notification_body : "Please check your input uses only the instructions allowed TWICE at most",
    notification_btn : "Try Again"
}

var consecutive_repeats = {
    notification_title : "Consecutive repeat instruction",
    notification_body : "Consecutive repeat instructions are not allowed 😢",
    notification_btn : "Try Again"
}

var success = {
    notification_title : "Well done",
    notification_body : "You managed to successfully escape from the maze!",
    notification_timer : "Your time was: ",
    notification_name_label : "Enter a name to appear on the leaderboard along with your time",
    notification_btn : "Next"
}

// general
var _notif_unexpected = {
		content: "Internal error. Something unexpected happened, please try again later.",
		error: "true"
}

// welcome page

var _notif_invalid_username = {
	content: "Invalid username. Only letters and numbers are allowed.",
	error: "true"
}

var _notif_empty = {
		content: "Empty username. Please insert a username.",
		error: "true"
}

// timer 
var _notif_store_time_error = {
		content: "There has been a problem trying to record your time. Please contact the game admin.",
		error: "true"
}

// paths
var _root			= "/Maze/";
var _path_connect	= _root+"Connect";
var _path_signout	= _root+"Signout";

var _path_level1	= _root+"level1"; 
var _path_websocket = "ws://"+window.location.hostname+":8080/Maze/Websocket";
if(window.location.hostname.includes("ngrok")){
	_path_websocket = "ws://"+window.location.hostname+"/Maze/Websocket";
}