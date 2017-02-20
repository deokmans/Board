<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/write.css" />

<title>Insert title here</title>
</head>
<body>

	<div class=div_inputForm>
		<form action="updateArticle.do?idx=${article.idx}" method="post"
			onsubmit="return formCheck();">
			<table>
				<tr>
					<td><label for="title">제목 : </label></td>
					<td><input id="title" type="text" name="title" tabindex="1" value="${article.title}"/></td>
				</tr>
				<tr>
					<td><label for="writer">작성자 : </label></td>
					<td><input id="writer" type="text" name="writer" tabindex="2" value="${article.writer}"/></td>
				</tr>
				<tr>
					<td><label for="password">비밀번호 : </label></td>
					<td><input id="password" type="password" name="password" tabindex="3"/></td>
				</tr>
				<tr>
					<td><label for="content">내용 : </label></td>
					<td><textarea id="content" name="content">${article.content}</textarea></td>
				</tr>
			</table>
			<input type="submit" value="수정">
		</form>
	</div>
	
	<script type="text/javascript">
	
		function formCheck() {
			var title = document.forms[0].title.value;
			var writer = document.forms[0].writer.value;
			var password = document.forms[0].password.value;
			
			if(title == null || title == "") {
				alert('제목을 입력하세요');
				document.forms[0].title.focus();
				return false;
			}
			
			if(writer == null || writer == "") {
				alert('작성자를 입력하세요');
				document.forms[0].writer.focus();
				return false;
			}
			
			if(${article.password} != password) {
				alert('비밀번호가 틀렸습니다.')
				document.forms[0].password.value = '';
				return false;
			}
		}
		
	</script>
</body>
</html>