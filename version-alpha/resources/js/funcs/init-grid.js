
function init_grid(grid){
    // get grid dimensions
    _current_grid   = grid;
    var grid_width  = grid[_width];
    var grid_height = grid[_height]; 

    // get grid container
    var grid_container  = $("#grid_container")[0];

    // create grid using dimensions and path info
    for(var j= 0; j< grid_width; j++){
        for(var i= 0; i< grid_height; i++){
            var button = document.createElement("button");
            $(button).attr(_x_coord, i);
            $(button).attr(_y_coord, j);
            $(button).attr("class", "btn");
            button.disabled = true;
            // is a path
            if(_is_in_paths(grid, i, j)){
                $(button).addClass("btn-info "+[_path]);
            }
            // is a wall
            else{
                $(button).addClass("btn-default "+[_wall]);
            }
            // set width and height
            $(button).css("width", eval(100/grid_width)+"%");
            $(button).css("height", eval(100/grid_height)+"%");
            // is the start position
            if(_is_start(grid, i, j)){
                // add icon
                _add_icon(button, grid[_start][_direction]);
                // set game variables
                _current_cell = { 
                    [_x_coord]: i,
                    [_y_coord]: j
                }
                _current_direction = grid[_start][_direction];
                _start_cell ={
                    [_x_coord]: i,
                    [_y_coord]: j
                };
            }
            // is the end position
            if(_is_end(grid, i, j)){
                // add icon
                _add_icon_ending(button);
                // set game variables
                _end_cell ={
                    [_x_coord]: i,
                    [_y_coord]: j
                };
            }
            // append to container
            grid_container.appendChild(button);
        }
    }
}