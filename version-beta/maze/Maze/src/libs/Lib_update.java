package libs;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Lib_update {
	private Connection connection;
	public Lib_update(Connection connection){
		this.connection = connection;
	}

	public <A> void update(String table, String[] updates_col, A[] updates_val, String[] conditions_col, A[] conditions_val) throws Exception{
		String markers_1 = "";
		for(int i = 0; i< updates_col.length; i++){
			markers_1 += updates_col[i]+"= ? ";
			if(i != updates_col.length-1)
				markers_1 += ",";
		}
		String markers_2 = "";
		for(int i = 0; i< conditions_col.length; i++){
			if(i == 0){	markers_2 += "WHERE "+conditions_col[i]+"= ? ";}
			else{		markers_2 += "AND   "+conditions_col[i]+"= ? ";}
		}
		PreparedStatement p_statement = connection.prepareStatement("Update "+table+" "+
																	"Set    "+markers_1+" "+
																	markers_2);
		int i = 0;
		while(i < updates_val.length){
			p_statement.setObject(i+1, updates_val[i]);
			i++;
		}
		int j = 0;
		while(j < conditions_val.length){
			p_statement.setObject(i+1, conditions_val[j]);
			i++;
			j++;
		}
		p_statement.execute();
	}
}

