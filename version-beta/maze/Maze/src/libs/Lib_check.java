package libs;

import java.util.stream.IntStream;

import variables.Tag;

public final class Lib_check {

	public static Object[] is_valid_username(String username){
		/*boolean not_null 		= is_not_null(username);
		boolean alpha_numerical	= is_alpha_numerical(username);
		if(!not_null){ return new Object[]{false, Tag.empty};}
		if(!alpha_numerical){ return new Object[] {false, Tag.invalid};}*/
		return new Object[] {true, ""};
	}
	 
	public static boolean is_alpha_numerical(String value){
		String regex = "^[0-9a-zA-Z]+$";
		return value.matches(regex);
	}

	public static boolean is_not_null(String value){
		return value != null && !value.equals("");
	}
	
	public static boolean is_level_valid(Integer levelid) {
		return IntStream.of(Tag.levels).anyMatch(x -> x == levelid);
	}
}
 