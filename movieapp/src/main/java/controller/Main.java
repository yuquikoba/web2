package controller;

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

import model.Movie;
import model.PostMovieLogic;
import model.User;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext application = this.getServletContext();
		List<Movie> movieList = (List<Movie>) application.getAttribute("movieList");

		if (movieList == null) {
			movieList = new ArrayList<>();
			application.setAttribute("movieList", movieList);
		}

		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser == null) {
			// リダイレクト
			response.sendRedirect("index.jsp");
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/main.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String movieTitle = request.getParameter("movieTitle");
		String comment = request.getParameter("comment");

		if (movieTitle != null && movieTitle.length() != 0) {
			ServletContext application = this.getServletContext();
			List<Movie> movieList = (List<Movie>) application.getAttribute("movieList");

			HttpSession session = request.getSession();
			User loginUser = (User) session.getAttribute("loginUser");

			Movie movie = new Movie(loginUser.getName(), movieTitle, comment);
			PostMovieLogic postMovieLogic = new PostMovieLogic();
			postMovieLogic.execute(movie, movieList);

			application.setAttribute("movieList",movieList);
		}else {
			request.setAttribute("errorMsg", "タイトルが入力さていません");
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/view/main.jsp");
		dispatcher.forward(request,response);

	}

}
