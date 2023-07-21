package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TodoDAO;
import model.Todo;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s_id=request.getParameter("id");
		if(s_id==null) {
			response.sendRedirect("/todoapp/Read");
		}else {
			TodoDAO dao=new TodoDAO();
			Todo todo=dao.findOne(Integer.parseInt(s_id));
			request.setAttribute("todo",todo);
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/update.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title=request.getParameter("title");
		String importance=request.getParameter("importance");
		String id=request.getParameter("id");
		Todo todo=new Todo(Integer.parseInt(id),title,Integer.parseInt(importance));
		TodoDAO dao=new TodoDAO();
		dao.updateOne(todo);
		
		response.sendRedirect("/todoapp/Read");
		
		
		
	}

}
