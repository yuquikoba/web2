<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/lunchapp/Create">新規追加</a>
<c:if test="${not empty list}" >
<table border="1">
<tr><th>id</th><th>name</th><th>menu</th><th></th></tr>
<c:forEach var="lunch" items="${list}">
<tr>
<td><c:out value="${lunch.id}"/></td>
<td><c:out value="${lunch.name}"/></td>
<td><c:out value="${lunch.menu}"/></td>
<td>
<a href="/lunchapp/Update?id=${lunch.id}">更新</a>
<a href="/lunchapp/Delete?id=${lunch.id}">onclick="return confirm('${lunch.id}を削除してよろしいですか?')">削除</a>
</td>
</tr>
</c:forEach>
</table>
</c:if>

</body>
</html>