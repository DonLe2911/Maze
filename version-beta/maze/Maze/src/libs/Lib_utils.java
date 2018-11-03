package libs;

import java.io.File;
import java.net.URLDecoder;

import javax.sql.rowset.CachedRowSet;

public final class Lib_utils {
	public static String getPath(String file_name){
		try {
			String path = Lib_utils.class.getClassLoader().getResource("").getPath();
			String fullPath = URLDecoder.decode(path, "UTF-8");
			String pathArr[] = fullPath.split("/WEB-INF/classes/");
			fullPath = pathArr[0];
			String reponsePath = "";
			// to read a file from webcontent
			reponsePath = new File(fullPath).getPath() + File.separatorChar + file_name;
			return reponsePath;
		} catch(Exception e) {
			return "";
		}
	}
	
	public static String secsToMins(int time_seconds) {
		int mins		= time_seconds /60;
		int secs		= time_seconds % 60;
		String minutes	= mins > 9 ? ""+mins : "0"+mins;
		String seconds	= secs > 9 ? ""+secs : "0"+secs;
		return minutes+":"+seconds;
	}
	
	public static Integer get_int(CachedRowSet rowSet, String tag) throws Exception {
		if(rowSet.next()){return rowSet.getInt(tag);}
		return null;
	}
}
