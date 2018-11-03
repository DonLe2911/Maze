package libs;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import variables.Tag;

public class SQLiteDriverConnection {
	
	private String path;

	public SQLiteDriverConnection(String path) {
		this.path	  = path;
	}

	private Connection connect() {
		Connection conn = null;
		try {
			// get relative path to db file
			Class.forName("org.sqlite.JDBC");
			String url = "jdbc:sqlite:" + getPath();
			System.out.println(url);
			conn = DriverManager.getConnection(url);
			System.out.println("Connection established");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public void closeConnection() {
		Connection conn = this.connect();
		try {
			if (conn != null) {
				conn.close();
				System.out.println("Connection closed!");
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public String getPath() {
		return path;
	}

	/**
	 * Create a user table with the usernames, to be initialised first
	 */
	private void createUserTable() {
		PreparedStatement createStmt = null;

		String sqlcreate = "CREATE TABLE IF NOT EXISTS users (\n" + " userid text UNIQUE NOT NULL PRIMARY KEY \n "
				+ ");";

		try {
			Connection conn = this.connect();

			createStmt = conn.prepareStatement(sqlcreate);
			createStmt.executeUpdate();
			System.out.println("Users table created");
		} catch (SQLException ex) {
			System.out.println("Usert table creation Exception:" + ex.getMessage());
		}
	}

	/**
	 * Create a leaderboard table with columns as per the design
	 */
	private void createLeaderboardtable() {
		PreparedStatement createStmt = null;

		String sqlcreate = "CREATE TABLE IF NOT EXISTS leaderboard (\n" + " userid text NOT NULL, \n "
				+ " levelid integer NOT NULL, \n" + " time integer, \n "
				+ " CONSTRAINT pk_idlevel PRIMARY KEY(userid, levelid)" + ");";

		try {
			Connection conn = this.connect();

			createStmt = conn.prepareStatement(sqlcreate);
			createStmt.executeUpdate();
			System.out.println("Leaderboard table created");
		} catch (SQLException ex) {
			System.out.println("Leaderboard table creation Exception:" + ex.getMessage());
		}
	}

	/**
	 * Check if a user with the same name already exists
	 * 
	 * @param username the desired username
	 * @return user already in the database or successfully inserted (true), false if any other exception
	 */
	public boolean insertUser(String username) {
		String sql = "INSERT INTO users(userid) "
				+ "SELECT ? WHERE NOT EXISTS (SELECT 1 FROM users WHERE userid=?)";

		// additional validation for an empty username
		if (username.isEmpty()) {
			return false;
		}
		try (Connection conn = this.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, username);
			stmt.setString(2, username);
			stmt.executeUpdate();
			System.out.println("User added with username:" + username);
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false; // only if there's an exception
	}

	/**
	 * Insert a record for a user and a level with a given time in seconds in the
	 * database
	 * 
	 * @param username
	 * @param levelid  the level completed
	 * @param time     the time in seconds
	 */
	public void insert(String username, int levelid, int time) {
		String sql = "REPLACE INTO leaderboard(userid, levelid, time)\n " + 
				"SELECT ?, ?, ? WHERE NOT EXISTS (SELECT time from leaderboard where userid=? and levelid=?) "+
				"OR (SELECT time from leaderboard where userid=? and levelid=?) > ?";

		try (Connection conn = this.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, username);
			stmt.setInt(2, levelid);
			stmt.setInt(3, time);
			stmt.setString(4, username);
			stmt.setInt(5, levelid);
			stmt.setString(6, username);
			stmt.setInt(7, levelid);
			stmt.setInt(8, time);
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	/**
	 * Return a list of all users who
	 * have completed all levels along with the times for each level and the total time (the sum of all times). In order of the latter.
	 * @return A cached row set, so that the connection can be closed safely. 
	 * The column tags are as follows:
	 * userid, level1, level2, level3, totalTime
	 */
	public CachedRowSet selectUsersCompletedAllLevelsTimeSum() {
		CachedRowSet crs = null;
		
		String sql = "SELECT A.userid AS 'userid', A.time AS 'level1', B.time AS 'level2', C.time AS 'level3', A.time + B.time + C.time AS 'totalTime' "
				+ "FROM (SELECT userid, time FROM leaderboard WHERE levelid=1) AS A "
				+ "LEFT JOIN (SELECT userid, levelid, time FROM leaderboard WHERE levelid=2) AS B "
				+ "ON A.userid = B.userid "
				+ "LEFT JOIN (SELECT userid, levelid, time FROM leaderboard WHERE levelid=3) AS C "
				+ "ON B.userid = C.userid "
				+ "WHERE A.userid IN "
				+ "(SELECT l.userid FROM leaderboard l INNER JOIN leaderboard k ON (k.levelid = 2 AND l.userid = k.userid) INNER JOIN leaderboard o ON (o.levelid = 3 AND o.userid = k.userid) WHERE l.levelid=1) "
				+ "ORDER BY (A.time + B.time + C.time);";
		
		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet results = stmt.executeQuery(sql)) {
				
			crs = RowSetProvider.newFactory().createCachedRowSet();
			crs.populate(results);
			return crs;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return crs;
	}
	
	
	/**
	 * DEPRECATED - use selectUsersCompletedAllLevelsTimeSum() instead
	 * Return a list of all users who
	 * have completed all levels along with their total time (the sum of all times)
	 * @return a cached row set, so that the connection can be closed safely.
	 */
	private CachedRowSet _deprecatedSelectUsersCompletedAllLevelsTimeSum() {
		CachedRowSet crs = null;
		
		String sql = "SELECT A.userid, SUM(A.time) as totaltime " + "FROM leaderboard A "
				+ "WHERE A.userid IN (SELECT l.userid FROM leaderboard l INNER JOIN leaderboard k ON (k.levelid = 2 AND l.userid = k.userid) INNER JOIN leaderboard o ON (o.levelid = 3 AND o.userid = k.userid) WHERE l.levelid=1) GROUP BY A.userid;";
		
		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet results = stmt.executeQuery(sql)) {
				
			crs = RowSetProvider.newFactory().createCachedRowSet();
			crs.populate(results);
			return crs;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return crs;
	}
	
	// TODO above return all level times in addition to sum.
	
	public CachedRowSet selectTimeForGivenUserAndLevel(String username, int levelid) {
		CachedRowSet crs = null;
		String sql = "SELECT time FROM leaderboard WHERE userid=? AND levelid=?";
		try (Connection conn = this.connect(); 
			PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, username);
			stmt.setInt(2, levelid);
			ResultSet result = stmt.executeQuery();
			crs = RowSetProvider.newFactory().createCachedRowSet();
			crs.populate(result);
			return crs;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return crs;	
	}
	
	public void createTables() {
		this.connect();
		this.createUserTable();
		this.createLeaderboardtable();
	}

	// Main method to initialise creation of tables
	public static void main(String[] args) {
		Path currentPath = Paths.get(System.getProperty("user.dir")); // when compiling to WAR, remove Tags.dir_wed
		Path filePath = Paths.get(currentPath.toString(), Tag.db_file);
		SQLiteDriverConnection conn = new SQLiteDriverConnection(filePath.toString());
		System.out.println("DB File: " + Tag.db_file + " Path:" + filePath.toString());

		conn.createTables();
		conn.closeConnection();
	}

}
