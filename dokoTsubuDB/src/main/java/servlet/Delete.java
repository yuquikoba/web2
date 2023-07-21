package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MutterDAO;

@WebServlet("/Delete")

public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		if(id!=null) {
			MutterDAO dao=new MutterDAO();
			dao.deleteOne(Integer.parseInt(id));
		}
		response.sendRedirect("Main");
	}


}
