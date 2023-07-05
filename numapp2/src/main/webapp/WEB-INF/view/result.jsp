<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--インポートをする必要がある --%>
<%@ page import="model.Num" %>
<%
//リクエストスコープからインスタンスを取得。
//スコープにはオブジェクト型で格納されているのでダウンキャストの必要がある
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
<%=num.getOrg() %>
<p>要素数:<%=num.getSize() %></p>
<p>最大値:<%=num.getMax() %></p>
<p>要小値:<%=num.getMin() %></p>
<p>合計:<%=num.getSum() %></p>
<a href="/numapp/NumMain">戻る</a>
</body>
</html>