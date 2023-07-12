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

import model.Product;
import model.RegisterLogic;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application=this.getServletContext();
		List<Product> productList=(List<Product>)application.getAttribute("List");
		if(productList==null) {
			productList=new ArrayList<>();
			application.setAttribute("List", productList);
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/view/main.jsp");
		dispatcher.forward(request, response);
			
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		String price=request.getParameter("price");
		String msg;
		if((name !=null && price.length()>0)&&(price !=null && price.length()>0)) {
			msg="1件登録しました";
			Product product=new Product();
			product.setName(name);
			product.setPrice(price);
			ServletContext application=this.getServletContext();
			List<Product> productList=(List<Product>)application.getAttribute("List");
			RegisterLogic logic=new RegisterLogic();
			logic.execute(product, productList);
			application.setAttribute("List", productList);
		}else {
			msg="未記入の項目があります!";
		}
		request.setAttribute("msg",msg);
		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/view/main.jsp");
		dispatcher.forward(request,response);
	}

}
