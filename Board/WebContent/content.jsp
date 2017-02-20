<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/content.css" />
<title>Insert title here</title>
</head>
<body>
	<div class=div_whole>
		<table>
			<tr>
				<td>제목 :</td>
				<td colspan="3">${article.title}</td>
			</tr>
			<tr>
				<td>글쓴이 :</td>
				<td colspan="3">${article.writer}</td>
			</tr>
			<tr>
				<td>작성시간 :</td>
				<td colspan="3">${article.regdate}</td>
			</tr>
			<tr>
				<td>내용 :</td>
				<td colspan="3"><textarea readonly="readonly">${article.content}</textarea></td>
			</tr>
		</table>

		<div>
			<a href="changeArticle.do?idx=${article.idx}">게시글 수정</a> 
			<a href="deleteArticle.do?idx=${article.idx}">게시글 삭제</a> 
			<a href="list.do">목록으로</a>
		</div>

	</div>

</body>
</html>