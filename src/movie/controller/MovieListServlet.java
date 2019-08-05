package movie.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import movie.beans.LoginInfoBeans;
import movie.beans.MovieListBeans;
import movie.model.MovieModel;

@WebServlet("/list")
public class MovieListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MovieModel movieModel = new MovieModel();

		HttpSession session = request.getSession();

		LoginInfoBeans loginInfo = (LoginInfoBeans)session.getAttribute("loginInfo");


		List<MovieListBeans> list = movieModel.getList(loginInfo);

		request.setAttribute("list", list);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/movielist.jsp");
		dispatcher.forward(request, response);
	}
}
