<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>수정하기</h1>
	
	<form action="update.do" method="post">
		<table border="1">
		<tr>
		<th>ID</th>
		<td><input type="text" readonly="readonly" value="${dto.id }" name="id"></td>
		</tr>
		<tr>
		<th>PW</th>
		<td><input type="text" value="${dto.password }" name="password"></td>
		</tr>
		<tr>
		<th>NAME</th>
		<td><input type="text" readonly="readonly" value="${dto.name }" name="name"></td>
		</tr>
		<tr>
		<td colspan="2">
		<input type="button" value="취소" onclick="">
		<input type="submit" value="수정" >
		</td>
		</tr>	
		
		</table>
	
	</form>
</body>
</html>