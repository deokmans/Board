<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/board.css" />
<title>Insert title here</title>
</head>
<body>

	<div class=div_whole>
		<table>
			<colgroup>
				<col width="50" />
				<col />
				<col width="110" />
				<col width="100" />
				<col width="50" />
			</colgroup>

			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">제목</th>
					<th scope="col">작성자</th>
					<th scope="col">날짜</th>
					<th scope="col">조회수</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${articleList}" var="article">
					<tr>
						<td>${article.idx}</td>
						<td><a class="title" href='viewArticle.do?idx=${article.idx}'>${article.title}</a></td>
						<td>${article.writer}</td>
						<td>${article.regdate}</td>
						<td>${article.count}</td>
					</tr>
				</c:forEach>
			</tbody>


		</table>

		<a href="write.jsp">글쓰기</a>
	</div>



</body>
</html>