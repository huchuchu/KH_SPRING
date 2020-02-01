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

	<jsp:useBean id="abc" class="com.mvc.dto.MyMvcDto" scope="session"></jsp:useBean>
	
	작성자: <jsp:getProperty property="writer" name="abc"/>
	${abc.writer }
	
	


</body>
</html>