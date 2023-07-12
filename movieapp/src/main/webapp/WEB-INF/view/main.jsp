<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.User,model.Movie,java.util.List"%>
<%
User loginUser = (User) session.getAttribute("loginUser");
List<Movie> movieList=(List<Movie>)application.getAttribute("movieList");
String errorMsg=(String)request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>おすすめ映画</title>
</head>
<body>
<p><%=loginUser.getName() %>さん、ログイン中
<a href="Logout">ログアウト</a>
</p>
<p><a href="Main">更新</a></p>
<form action="Main" method="post">
タイトル:<input type="text" name="movieTitle"><br>
コメント:<textarea name="comment"></textarea><br>
<input type="submit" value="送信">
</form>
<% if(errorMsg !=null){ %>
<p><%=errorMsg %>
<%} %>
<%if(movieList.size()>0){ %>
<table border="1">
<% for(Movie movie:movieList){ %>
<tr>
<td><%=movie.getUserName() %></td>
<td><%=movie.getMovieTitle() %></td>
<td><%=movie.getComment() %></td>
</tr>
<%} %>
</table>
<%} %>
</body>
</html>