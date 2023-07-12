package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		
		User user=new User(name,pass);
		
		LoginLogic loginLogic=new LoginLogic();
		boolean isLogin=loginLogic.execute(user);
		
		//ログイン成功時
		//isLogin==true
		if(isLogin) {
			HttpSession session=request.getSession();
			session.setAttribute("loginUser", user);
		}
		//ログイン結果画面にフォワード
		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/view/loginResult.jsp");
		dispatcher.forward(request, response);
	}
}
