package models;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import libs.Lib_check;
import libs.SQLiteDriverConnection;
import variables.Tag;

public class Model_connect {
	private ServletContext context;
	private HttpServletRequest request;
	private String username;
	
	public Model_connect(HttpServletRequest request, String username, ServletContext context) {
		this.context	= context;
		this.request	= request;
		this.username 	= username;
	}

	public String run() throws Exception{
		Object[] is_valid = Lib_check.is_valid_username(username);
		if((boolean) is_valid[0]) {
			
			// insert user if not already registered
			SQLiteDriverConnection conn = new SQLiteDriverConnection(context.getRealPath(Tag.db_file));
			conn.insertUser(username);
			conn.closeConnection();
			
			// initialise session
			HttpSession session = request.getSession(true);
			session.setAttribute(Tag.username, username);
			return Tag.success;
		}
		return (String) is_valid[1];
	}

}
