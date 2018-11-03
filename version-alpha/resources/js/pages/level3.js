$(document).ready(function(){ 
    init_grid(_grid_level3);
    init_execution();
    init_run_new_game();
    _init_timer();
    _timer_interval = setInterval(_init_timer, 1000);
});
