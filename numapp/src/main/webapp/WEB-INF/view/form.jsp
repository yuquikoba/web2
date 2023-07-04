<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Num" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>数字をカンマ区切りで入力</h1>
<form action="NumMain" method="post">
<input type="text" name="number">
<input type="submit" value="送信">
</form>

</body>
</html>