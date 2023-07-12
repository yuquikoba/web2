<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*,java.util.*" %>
<%
List<Product> productList=(List<Product>)application.getAttribute("List");
String msg=(String)request.getAttribute("msg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>製品登録</title>
</head>
<body>
<% if(msg !=null){ %>
<p><%=msg %></p>
<%} %>
<form action="Main" method="post">
製品名:<br><input type="text" name="name"><br>
価格:<br><input type="text" name="price"><br>
<input type="submit" value="登録">
</form>
<% if(productList.size()>0){ %>
<table border="1">
<tr><th>製品名</th><th>価格</th><th>登録日</th></tr>
<% for(Product p:productList){ %>
<tr>
<td><%=p.getName() %></td>
<td><%=p.getPrice() %>円</td>
<td><%=p.getDateTime() %></td>
</tr>
<%} %>
</table>
<%} %>

</body>
</html>