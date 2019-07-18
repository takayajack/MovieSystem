package movie.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import movie.beans.AdminLoginInfoBeans;
import movie.model.AdminLoginModel;

@WebServlet("/adminAuth")
public class AdminLoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
												throws ServletException,IOException{

		String id = request.getParameter("id");
		String pw = request.getParameter("password");

		AdminLoginModel model = new AdminLoginModel();

		AdminLoginInfoBeans loginInfo = model.AdminLogin(id, pw);

		if( loginInfo != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginInfo", loginInfo);
		}else {
			response.sendRedirect("adminLogin?errflg=1");
			return;
		}

		response.sendRedirect("adminTop");
	}
}
