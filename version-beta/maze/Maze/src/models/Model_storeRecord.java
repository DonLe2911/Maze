package models;

import javax.websocket.Session;

import libs.Lib_check;
import libs.SQLiteDriverConnection;
import variables.Tag;
import variables.Ws;
import websocket.Ws_object;

public class Model_storeRecord {
	private Ws_object object;
	private Session session;

	public Model_storeRecord(Ws_object object, Session session) {
		this.object = object;
		this.session = session;

	}

	public void run() throws Exception {
		int user_sent_level = Integer.parseInt(object.get(Tag.levelid).toString());
		boolean is_valid = Lib_check.is_level_valid(user_sent_level);
		if (is_valid) {

			// insert user to leaderboard
			SQLiteDriverConnection conn = new SQLiteDriverConnection((String) session.getUserProperties().get(Tag.path));
			String username = (String) session.getUserProperties().get(Tag.username);
			int time = Integer.parseInt(object.get(Tag.seconds).toString());

			conn.insert(username, user_sent_level, time);
			conn.closeConnection();

			// set success code
			object.set(Tag.code, Ws.time_success);
		} else {
			// set failure code
			object.set(Tag.code, Ws.time_failure);
		}
		// send code
		session.getBasicRemote().sendObject(object);
	}
}
