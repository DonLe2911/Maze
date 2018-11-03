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

@WebServlet("/level3")
public class Route_level3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Route_level3() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute(Tag.username) != null) {
			Model_info_level model = new Model_info_level((String) session.getAttribute(Tag.username), 3);
			request.setAttribute(Tag.object, model.get_data());
			request.getRequestDispatcher(Tag.route_level3).forward(request, response);
		}
		else {
			response.sendRedirect(Tag.path_root);
		}
	}

}
