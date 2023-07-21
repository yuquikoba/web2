<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
<%
Mutter mutter=(Mutter)request.getAttribute("mutter");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<form action="Update" method="post">
<input type="text" name="text" value="<%=mutter.getUserText()%>">
<input type="hidden" name="id" value="<%=mutter.getId() %>">
<input type="hidden" name="name" value="<%=mutter.getUserName() %>">
<input type="submit" value="更新する">
</form>

</body>
</html>