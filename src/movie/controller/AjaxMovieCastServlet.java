package movie.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import movie.model.AdminMovieModel;

@WebServlet("/adminMovieCast")
public class AjaxMovieCastServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
												throws ServletException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		String id = request.getParameter("id");

		List<String> list = null;

		AdminMovieModel model = new AdminMovieModel();
		try {
			list = model.getCast(id);
			String resJson = mapper.writeValueAsString(list);

			response.setContentType("application/json");
			response.setHeader("Cache-Control", "nocache");
			response.setCharacterEncoding("utf-8");

			PrintWriter out = response.getWriter();
			out.print(resJson);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
