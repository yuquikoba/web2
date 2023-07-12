package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Mutter;
import model.PostMutterLogic;
import model.User;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//つぶやきリストをアプリケーションスコープから取得
		ServletContext application=this.getServletContext();
		List<Mutter> attribute = (List<Mutter>)application.getAttribute("mutterList");
		List<Mutter> mutterList=attribute;
		//取得できなかった場合、つぶやきリストを新規作成して
		//アプリケーションスコープに保存
		if(mutterList==null) {
			mutterList=new ArrayList<>();
			application.setAttribute("mutterList",mutterList);
		}
		
		//セッションスコープからユーザー情報を取得し
		//ユーザーのログイン状況を確認
		HttpSession session=request.getSession();
		User loginUser=(User)session.getAttribute("loginUser");
		
		if(loginUser==null) {
			//リダイレクト(ログインしていない場合)
			response.sendRedirect("index.jsp");
		}else {
			//フォワード（ログイン時)
			RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
			dispatcher.forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String text=request.getParameter("text");

		if(text !=null && text.length() !=0) {
			ServletContext application=this.getServletContext();
			List<Mutter> mutterList=(List<Mutter>)application.getAttribute("mutterList");
			
			HttpSession session=request.getSession();
			User loginUser=(User)session.getAttribute("loginUser");

			Mutter mutter=new Mutter(loginUser.getName(),text);
			PostMutterLogic postMutterLogic=new PostMutterLogic();
			postMutterLogic.execute(mutter,mutterList);
			
			application.setAttribute("mutterList",mutterList);
		}else {
			request.setAttribute("errorMsg", "つぶやきが入力されていません");
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
		
		
		

		
		
		
	}

}
