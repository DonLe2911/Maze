package models;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import libs.Lib_utils;
import libs.SQLiteDriverConnection;
import variables.Tag;
import variables.User_object;

public class Model_info_leaderboard {
	private SQLiteDriverConnection conn;
	private List<User_object> users;
	
	public Model_info_leaderboard() {
		this.conn		= new SQLiteDriverConnection(Lib_utils.getPath(Tag.db_file));
		this.users		= new ArrayList<User_object>();
	}
	
	public List<User_object> get_data() {
		try {
			CachedRowSet rowSet = conn.selectUsersCompletedAllLevelsTimeSum();
			while(rowSet.next()) {
				User_object object = new User_object();
				object.addTimeForLevel(Lib_utils.secsToMins(rowSet.getInt(Tag.level+"1")));
				object.addTimeForLevel(Lib_utils.secsToMins(rowSet.getInt(Tag.level+"2")));
				object.addTimeForLevel(Lib_utils.secsToMins(rowSet.getInt(Tag.level+"3")));
				object.setTotalTime(Lib_utils.secsToMins(rowSet.getInt(Tag.totalTime)));
				object.setUsername(rowSet.getString(Tag.userid));
				users.add(object);		
			}
			return users;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		} finally {conn.closeConnection();}
	}
}
