<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="model.User,model.Mutter,java.util.List" %>
 <%
 User loginUser=(User)session.getAttribute("loginUser");
 List<Mutter> mutterList=(List<Mutter>)request.getAttribute("mutterList");
 String errorMsg=(String)request.getAttribute("errorMsg");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶメイン</h1>
<p>
<%=loginUser.getName() %>さん、ログイン中
<a href="Logout">ログアウト</a>
</p>
<p><a href="Main">更新</a></p>
<form action="Main" method="post">
<input type="text" name="text">
<input type="submit" value="つぶやく">
</form>
<% if(errorMsg !=null){ %>
<p><%=errorMsg %>
<%} %>
<table class="table table-striped mt-4">
<tr><th class="user" style="width:200px;">ユーザー</th><th class="mutter">つぶやき</th></tr>
<% for(Mutter mutter:mutterList){ %>
<tr><td><%=mutter.getUserName() %></td><td><%=mutter.getUserText() %></td></tr>
<%if(mutter.getUserName().equals(loginUser.getName())){ %>
<td><button><a href="/dokoTsubuDB/Update?id=<%=mutter.getId()%>">更新</a></button>
<button><a href="/dokoTsubuDB/Delete?id=<%=mutter.getId()%>" onclick="return confirm('id=<%=mutter.getId()%>を削除してよろしいですか？');">削除</a>
</button>
<%} %>
</td>
<%} %>
</table>
</body>
</html>