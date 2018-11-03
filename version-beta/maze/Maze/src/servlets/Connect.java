package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import libs.Lib_http;
import models.Model_connect;
import variables.Tag;

@WebServlet("/Connect")
public class Connect extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Connect() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String username = request.getParameter(Tag.username);
			
			Model_connect model	= new Model_connect(request, username, getServletContext());
			String result		= model.run();
			Lib_http.respond(response, result);
		} catch(Exception e) {
			e.printStackTrace();
			Lib_http.respond(response, Tag.unexpected);
		}
	}

}
