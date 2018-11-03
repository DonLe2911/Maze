$(document).ready(function(){ 
    init_grid(_grid_level1);
    init_execution();
    init_run_new_game();
    init_signout(".info_panel");
    _timer_interval = setInterval(_init_timer, 1000);
    success.next_level = "level2"
    _levelid = 1;
});
