<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Num" %>
    <%
    Num num=(Num)request.getAttribute("num");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>入力された文字列</p>
<p>
<%=num.getNumber() %><br>
要素数:<%=num.getLength() %><br>
最大値:<%=num.getMax() %><br>
最小値:<%=num.getMin() %><br>
合計:<%=num.getSum() %>
</p>
<a href="NumMain">戻る</a>
</body>
</html>