package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Num;
import model.NumLogic;

@WebServlet("/NumMain")
public class NumMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//jspに処理を転送するフォワード処理
		RequestDispatcher rd=
				request.getRequestDispatcher("/WEB-INF/view/form.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ユーザーが入力した文字列を取得
		String org=request.getParameter("org");
		//その文字列を引数にいれてインスタンスをnew
		Num num=new Num(org);
		//ロジッククラスのインスタンスをnew
		NumLogic logic=new NumLogic();
		//executeすることでnumインスタンスはすべての情報を持つ
		logic.execute(num);
		//インスタンスをリクエストスコープにセット
		request.setAttribute("num", num);
		//result.jspにフォワード
		RequestDispatcher rd=
				request.getRequestDispatcher("/WEB-INF/view/result.jsp");
		rd.forward(request, response);
	}

}