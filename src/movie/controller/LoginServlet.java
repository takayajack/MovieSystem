package movie.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import movie.beans.LoginInfoBeans;
import movie.model.LoginModel;

@WebServlet("/auth")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		System.out.print(email+password);

		///////////////////////////////////////////
		//Modelを呼び出しDBの値をメール、パスワードを照合する
		LoginModel loginModel = new LoginModel();

		LoginInfoBeans loginInfo = loginModel.login(email, password);

		String err = "";

		if( loginInfo != null ){
			///////////////////////////////////////////
			//ログイン結果をセッションに保存する
			HttpSession session = request.getSession(true);

			session.setAttribute("loginInfo", loginInfo);

		}else{
			//ログイン結果がnullの場合はログイン画面に戻す
			err = "正しいメールアドレスまたはパスワードを入力してください";
			HttpSession session = request.getSession(true);
			session.setAttribute("err", err);
			response.sendRedirect("login");
			return;
		}
		response.sendRedirect("top");
	}
}