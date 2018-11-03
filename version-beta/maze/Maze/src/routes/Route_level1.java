package routes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Model_info_level;
import variables.Tag;

@WebServlet("/level1")
public class Route_level1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Route_level1() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute(Tag.username) != null) {
			Model_info_level model = new Model_info_level((String) session.getAttribute(Tag.username), 1);
			request.setAttribute(Tag.object, model.get_data());
			request.getRequestDispatcher(Tag.route_level1).forward(request, response);
		}
		else {
			response.sendRedirect(Tag.path_root);
		}
	}

}
