package movie.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.beans.MovieListBeans;
import movie.model.MovieModel;

@WebServlet("/search")
public class MovieSearchServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
												throws ServletException, IOException {
		MovieModel movieModel = new MovieModel();

		String sitem = req.getParameter("sitem");
		System.out.println("s");

		List<MovieListBeans> list = movieModel.seachList(sitem);

		req.setAttribute("list", list);

		RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/jsp/movielist.jsp");
		dispatcher.forward(req, resp);



	}



}
