package libs;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Lib_insert{
	private Connection connection;
	public Lib_insert(Connection connection){
		this.connection = connection;
	}
	public <A> void insert(String table, String[] inserts_col, A[] inserts_val) throws Exception{
		String markers					= "";
		String the_inserts_col				= "";
		for(int i = 0; i< inserts_col.length; i++){
			the_inserts_col += inserts_col[i];
			markers		+= "?";
			if(i != inserts_col.length-1){
				the_inserts_col += ",";
				markers		+= ",";
			}
		}
		PreparedStatement p_statement = connection.prepareStatement("INSERT INTO "+table+"("+the_inserts_col+") "+
                 						 "VALUES("+markers+")");
		for(int i = 0; i < inserts_val.length; i++){
			p_statement.setObject(i+1, inserts_val[i]);
		}
		p_statement.execute();
	}
}

