package variables;

public final class Tag {
	
	// keys
	public static final String code			= "code";
	public static final String count		= "count";
	public static final String empty		= "empty";
	public static final String failure		= "failure";
	public static final String invalid		= "invalid";
	public static final String levelid		= "levelid";
	public static final String object		= "object";
	public static final String path			= "path";
	public static final String seconds		= "seconds";
	public static final String success		= "success";
	public static final String time			= "time";
	public static final String totalTime	= "totalTime";
	public static final String unexpected	= "unexpected";
	public static final String userid		= "userid";
	public static final String username		= "username";
	public static final String users		= "users";

	// directions (MUST BE KEPT AS IT IS FOR FONTAWESOME CLASS NAMES)
	public static final String down   = "down";
	public static final String left   = "left";
	public static final String right  = "right";
	public static final String up     = "up";

	// instructions 
	public static final String move           = "move";
	public static final String move_left      = move+" "+left;
	public static final String move_right     = move+" "+right;
	public static final String move_fw        = move+" forward";
	public static final String jump           = "jump";
	public static final String jump_left      = jump+" "+left;
	public static final String jump_right     = jump+" "+right;
	public static final String jump_fw        = jump+" forward";
	public static final String repeat         = "repeat";
	// settings
	public static final int repeat_count = 2;

	public static final int instruction_limit = 2;
	
	// pages
	public static final String extension	= ".jsp";
	public static final String level		= "level";
	public static final String page_level1	= level+"1"+extension;	
	public static final String page_level2	= level+"2"+extension;
	public static final String page_level3	= level+"3"+extension;
	
	// database
	public static final String db_file	= "leaderboard.db";
	
	// paths
	public static final String path_root	= "/Maze/";
	public static final String dir_web		= "WebContent";
	public static final String dir_pages	= "/pages/";
	public static final String path_level1	= path_root+"level1";
	public static final String path_level2	= path_root+"level2";
	public static final String path_level3	= path_root+"level3";
	public static final String path_board	= path_root+"leaderboard";
	
	public static final String route_level1	= dir_pages+"level1"+extension;
	public static final String route_level2	= dir_pages+"level2"+extension;
	public static final String route_level3	= dir_pages+"level3"+extension;
	public static final String route_board	= dir_pages+"leaderboard"+extension;
	
	// levels
	public static final int[] levels = {1,2,3};
}
