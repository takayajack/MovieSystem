package movie.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import movie.model.AdminMovieModel;

@WebServlet("/adminMovieList")
public class AjaxMovieListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
												throws ServletException, IOException {

		ObjectMapper mapper = new ObjectMapper();

		List<Map<String,String>> list = null;

		AdminMovieModel model = new AdminMovieModel();
		try {
			list = model.getList();
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
