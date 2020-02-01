<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글쓰기</h1>
	
	<form action="insert.do" method="post">
	<table border="1">
		<tr>
			<th>ID</th>
			<td>
			<input type="text" name="id">
			</td>
		</tr>
		<tr>
			<th>PW</th>
			<td>
			<input type="text" name="password">
			</td>
		</tr>
		<tr>
			<th>name</th>
			<td>
			<input type="text" name="name">
			</td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="submit" value="제출">
			<input type="button" value="취소">
			</td>
		</tr>
	
	</table>
	
	</form>
</body>
</html>