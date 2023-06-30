

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testenq")
public class Testenq extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String qtype=request.getParameter("qtype");
		String body=request.getParameter("body");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta cherset='utf-8'>");
		out.println("<title>お問い合わせ</title>");
		out.println("</head>");
		out.println("<body>");
		out.printf("<p>%s:%s</p>%n",name,qtype);
		out.printf("<p>%s</p>%n",body);
		out.println("</body>");
		out.println("</html>");
		
	}

}
