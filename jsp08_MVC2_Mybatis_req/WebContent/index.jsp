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

<a href="<%= request.getContextPath()%>/selectlist">list</a>
<br/>
<a href="selectlist">list</a>
<br/>
<a href="/selectlist">list</a>



<!-- 	<a href="controller.do?command=usebean">usebean test</a><br/> -->
	
<!-- 	<a href="controller.do?command=list">list</a><br/> -->

<!-- 	<a href="controller.do?command=loginform">login</a><br/> -->



</body>
</html>