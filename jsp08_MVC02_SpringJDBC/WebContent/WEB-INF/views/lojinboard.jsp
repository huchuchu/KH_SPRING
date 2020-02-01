<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8");%>
<% response.setContentType("text/html; charset=UTF-8"); %>   
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<fieldset style="width: 300px">
<legend>로그인</legend>
<table>
	<tr>
	<th>I D</th>
	<td></td>
	<td>
	<input type="text" name="id">
	</td>
	</tr>
	<tr></tr><tr></tr>
	<tr>
	<th>P W</th>
	<td></td>
	<td>
	<input type="text" name="pw">
	</td>
	</tr>
	<tr></tr><tr></tr>
	<tr>
	<td colspan="3">
	<input type="submit" value="로그인">
	<input type="button" value="회원가입">
	</td>
	</tr>

</table>
</fieldset>



</body>
</html>