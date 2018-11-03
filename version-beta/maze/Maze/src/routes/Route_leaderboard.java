package routes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Model_info_leaderboard;
import variables.Tag;

@WebServlet("/leaderboard")
public class Route_leaderboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Route_leaderboard() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model_info_leaderboard model = new Model_info_leaderboard();
		request.setAttribute(Tag.users, model.get_data());
		request.setAttribute(Tag.count, 3);
		request.getRequestDispatcher(Tag.route_board).forward(request, response);
	}

}
