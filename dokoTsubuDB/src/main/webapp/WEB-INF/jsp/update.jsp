<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<form action="Update" method="post">
<input type="text" name="text" value="${mutter.userText }">
<input type="hidden" name="id" value="${mutter.id }">
<input type="submit" value="更新する">
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>