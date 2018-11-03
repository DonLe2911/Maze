package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import libs.Lib_http;
import variables.Tag;

@WebServlet("/Signout")
public class Signout extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Signout() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			session.invalidate();
			Lib_http.respond(response, Tag.success);
		} catch(Exception e) {
			e.printStackTrace();
			Lib_http.respond(response, Tag.unexpected);
		}
	}

}
