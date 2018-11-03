package libs;

import javax.servlet.http.HttpServletResponse;

public final class Lib_http{
	public static void respond(HttpServletResponse response, String result){
		try{
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write(result);
		}catch(Exception e){}
	}
}
