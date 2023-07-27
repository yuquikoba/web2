<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<c:out value="${loginUser.name}"/>さん、ログイン中
<a href="Logout">ログアウト</a>
</p>
<p><a href="Main">更新</a></p>
<form action="Main" method="post">
<input type="text" name="text">
<input type="submit" value="つぶやく">
</form>
<c:if test="${not empty errorMsg}">
<p><c:out value="${errorMsg}"/></p>
</c:if>
<c:if test="${not empty mutterList}">
<table class="table table-striped mt-4">
<tr><th class="user" style="width:200px;">ユーザー</th><th class="mutter">つぶやき</th></tr>
<c:forEach var="mutter" items="${mutterList}">
<tr>
<td><c:out value="${mutter.userName}"/></td>
<td><c:out value="${mutter.userText}"/></td>
<td>
<c:if test="${mutter.userName eq loginUser.name}">
	<button><a href="/dokoTsubuDB/Update?id=${mutter.id}">更新</a></button>
	<button><a href="/dokoTsubuDB/Delete?id=${mutter.id}" onclick="return confirm('このつぶやきを削除してよろしいですか？')">削除</a></button>
</c:if>
</td>
</tr>
</c:forEach>
</table>
</c:if>
<jsp:include page="footer.jsp"/>
</body>
</html>