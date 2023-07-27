package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MutterDAO;
import model.Mutter;
import model.User;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("loginUser");
		
		if(id==null || user==null) {
			response.sendRedirect("index.jsp");
			return;
		}
			
			MutterDAO dao=new MutterDAO();
			Mutter mutter=dao.findOne(Integer.parseInt(id));
			request.setAttribute("mutter", mutter);
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/jsp/update.jsp");
			rd.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String text=request.getParameter("text");
		Mutter mutter=new Mutter(Integer.parseInt(id),text);
		MutterDAO dao=new MutterDAO();
		dao.updateOne(mutter);
		response.sendRedirect("Main");
		}

}
