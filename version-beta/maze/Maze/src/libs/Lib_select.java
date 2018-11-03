package libs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import variables.Tag;


/**
 * Imported from previous project (slightly modified)
 */
public class Lib_select {
	private Connection connection;
	public Lib_select(){}
	public Lib_select(Connection connection){
		this.connection = connection;
	}
	public <A> ResultSet select(String table, String selection, String[] join_tables, String[] join_ids, String[] conditions_col, A[] conditions_val, String...additional_data) throws Exception{
		PreparedStatement p_statement	= connection.prepareStatement(
			get_query_string(table, selection, join_tables, join_ids, conditions_col, additional_data)
		);
		for(int i = 0; i < conditions_val.length; i++){
			p_statement.setObject(i+1, conditions_val[i]);
		}
		return p_statement.executeQuery();
	}
	
	public <A> String get_query_string(String table, String selection, String[] join_tables, String[] join_ids, String[] conditions_col, String...additional_data) throws Exception{
		String markers					= "";
		String markers_2				= "";
		for(int i = 0; i< join_tables.length; i++){	// Tables to join
			String prev_t_name 	= "t"+i;
			String t_name 		= "t"+(i+1);
			markers 		   += "INNER JOIN "+join_tables[i]+" "+t_name+
								  " ON "+prev_t_name+"."+join_ids[i]+" = "+t_name+"."+join_ids[i]+" ";
		}
		for(int i = 0; i< conditions_col.length; i++){		// Conditions
			if(i == 0){	markers += "WHERE "+conditions_col[i]+"= ? ";}
			else{		markers += "AND   "+conditions_col[i]+"= ? ";}
		}
		String extra					= "";
		for(int i = 0; i< additional_data.length; i++){
			extra	+= additional_data[i]+" ";
		}
		return
			"SELECT "+selection+", COUNT(*) over (partition by 0) "+Tag.count+" "+
			"FROM 	"+table+" t0 "+markers+" "+
			markers_2+" "+
			extra;
	}
}
