package movie.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import movie.beans.UserInfoBeans;

@WebServlet("/Register")
public class ResistrationServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");
		String passConf = request.getParameter("passConf");

		HttpSession session = request.getSession();
		UserInfoBeans userInfo = new UserInfoBeans();

		userInfo.setMail(mail);
		userInfo.setPass(pass);
		userInfo.setPassConf(passConf);



		if("".equals(mail)) {

			response.sendRedirect("Register?errflg1=1");

			return;

		}else if("".equals(pass)) {

			response.sendRedirect("Register?errflg2=1");

			return;
		}else if("".equals(passConf)) {

			response.sendRedirect("Register?errflg3=1");

			return;
		}else if(pass != passConf) {

			response.sendRedirect("Register?errflg4=1");

			return;
		}

		session.setAttribute("userInfo",userInfo);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/userInfoChange.jsp");
		dispatcher.forward(request, response);
	}

}
