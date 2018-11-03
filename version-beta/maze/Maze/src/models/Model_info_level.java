package models;

import libs.Lib_utils;
import libs.SQLiteDriverConnection;
import variables.User_object;
import variables.Tag;

public class Model_info_level {
	private SQLiteDriverConnection conn;
	private User_object object;
	private int levelid;
	private String username;
	
	public Model_info_level(String username, int levelid) {
		this.conn		= new SQLiteDriverConnection(Lib_utils.getPath(Tag.db_file));
		this.object		= new User_object();
		this.levelid	= levelid;
		this.username 	= username;
	}
	
	public User_object get_data() {
		try {
			int current_best_time = 
					Lib_utils.get_int(conn.selectTimeForGivenUserAndLevel(username, levelid),Tag.time);
			object.setBestTimeForLevel(Lib_utils.secsToMins(current_best_time));
			return object;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		} finally {conn.closeConnection();}
	}
}
