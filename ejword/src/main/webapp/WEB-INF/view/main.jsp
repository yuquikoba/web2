<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EJWord</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
<link rel="stylesheet" href="/ejword/css/main.css">
</head>
<body>
<div class="container">
<form action="/ejword/main" method="get" class="form-inline">
<input type="text" name="searchWord" value="${ejw.searchWord }" class="form-control" placeholder="検索語を入力" required>
<select name="mode" class="form-controll">
<option value="startsWith"${ejw.mode eq "startsWith" ? " selected":""}>で始まる</option>
<option value="contains"${ejw.mode eq "contains" ? " selected":""}>を含む</option>
<option value="endsWith"${ejw.mode eq "endsWith" ? " selected":""}>で終わる</option>
<option value="match"${ejw.mode eq "match" ? " selected":""}>と一致する</option>
</select>
<button type="submit" class="btn btn-primary">検索</button>
</form>
<c:if test="${not empty ejw.searchWord and empty ejw.list}">
<p>1件も一致しませんでした</p>
</c:if>
<c:if test="${not empty ejw.list }">
<%--件数表示部分 --%>
	<c:if test="${ejw.total le ejw.limit }">
		<p>全${ejw.total}件</p>
	</c:if>
<%--ページ番号を利用して何件から何件を表示しているかを表す --%>
	<c:if test="${ejw.total gt ejw.limit }">
		<p>全${ejw.total}件中
		${(ejw.pageNo-1)*ejw.imit+1}~
		${ejw.pageNo*ejw.limiti gt ejw.total ? ejw.total:ejw.pageNo*ejw.limit }件を表示
		</p>
		<ul class="pager">
		<c:if test="${ ejw.pageNo gt 1 }"> 
	<%--リンク文字列の作成 --%>
			<li><a href="/ejword/main?searchWord=${ejw.searchWord}&mode=${ejw.mode}&page=${ejw.pageNo-1 }"><span aria-hiddesn="true">&larr;</span>前へ</a></li>
		</c:if>
		<c:if test="${ejw.pageNo*ejw.limit lt ejw.total}">
			<li><a href="/ejword/main?searchWord=${ejw.searchWord}&mode=${ejw.mode}&page=${ejw.pageNo+1 }">次へ<span aria-hidden="true">&rarr;</span></a></li>
		</c:if>
		</ul>
	</c:if>
	<table class="table table-bordered table-striped">
		<c:forEach var="w" items="${ejw.list}">
			<tr><th>${w.title}</th><td>${w.body}</td></tr>
		</c:forEach>
	</table>
	<c:if test="{not empty ejw.pager}">
	<div class="paginationBox">
		<ul class="pagination">
		<c:forEach var="row" items="${ejw.pager}">
			<li class="${row[0] }">
			<a href="/ejword/main?searchWord=${ejw.searchWord}&mode=${ejw.mode}&page=${row[1]}">${row[2]}</a>
		</li>
		</c:forEach>
		</ul>
	</div>
	</c:if>
</c:if>
</div><!-- end container -->
<footer>
&copy;2023 Joytas.net
</footer>
</body>
</html>