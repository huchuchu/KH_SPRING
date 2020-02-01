<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="./form/header.jsp" %>
	<form action="./boardinsertres.jsp" method="get">
		<table border="1">
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<th>제  목</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>내  용</th>
				<td><textarea rows="10" cols="60" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="작성"/>
					<input type="button" value="취소" onclick="./boardlist.jsp">
				</td>
			</tr>
		</table>
	</form>

	<%@ include file="./form/footer.jsp" %>
</body>
</html>