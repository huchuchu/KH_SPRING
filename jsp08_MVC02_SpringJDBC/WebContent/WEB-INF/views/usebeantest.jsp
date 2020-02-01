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
	
	<h1>jsp:useBean을 통한 객체생성(bean을 만들어서 jsp에서 쓸거야 bean:객체)</h1>
	
	<jsp:useBean id="dtos" class="com.spr.mvc.dto.MyMvcDto" scope="page"></jsp:useBean>
	<jsp:setProperty property="seq" name="dtos" value="123"/>
	<jsp:setProperty property="writer" name="dtos" value="홍길동"/>
	
	<jsp:getProperty property="seq" name="dtos"/>
	<jsp:getProperty property="writer" name="dtos"/>
	
	<jsp:useBean id="abc" class="com.spr.mvc.dto.MyMvcDto" scope="session"></jsp:useBean>
	<jsp:setProperty property="writer" name="abc" value="김선달"/>
	
	<input type="button" value="값 전달" onclick="location.href='res.jsp'">
	
	


</body>
</html>