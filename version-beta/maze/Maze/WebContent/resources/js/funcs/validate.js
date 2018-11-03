
function are_valid_instructions(instructions){

    console.log(instructions);

    for (let index = 0; index < instructions.length; index++) {
        // check if input instructions are part of the list of possible instructions
        if (_instruction_ls.includes(instructions[index])) {
            // check for 2 consecutive repeats
            if(instructions[index]==_repeat && instructions[index+1]==_repeat) {
                return [false, consecutive_repeats];
            }
        } else {
            return [false, invalid_input];
        }  
    }
    // map function to each of the elements in _instruction_ls
    // it any of the outputs is >2 (by filtering) => return false
    var instruction_occurences = _instruction_ls.map(a => countInArray(instructions,a));
    console.log(instruction_occurences);

    // check if an instruction is used more than 2 times 
    for(let i=0; i<instruction_occurences.length; i++) {
        if(instruction_occurences[i] > 2) {
            return [false, instruction_limit_exceeded];
        }
    }

    return [true, ""];
}  

function is_valid_username(username){
	var not_null 		= is_not_null(username);
	var alpha_numerical	= is_alpha_numerical(username);
	if(!not_null){ return [false, _notif_empty];}
	if(!alpha_numerical){ return [false, _notif_invalid_username];}
	return [true, ""];
}
 
function is_alpha_numerical(value){
	var regex = /^[0-9a-zA-Z]+$/;
	return regex.test(value);
}

function is_not_null(value){
	return value != "" && value != "undefined" && value != null;
}