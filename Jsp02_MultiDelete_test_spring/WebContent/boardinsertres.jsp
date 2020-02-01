<%@page import="com.muldel.dto.MDBoardDto"%>
<%@page import="com.muldel.dao.MDBoardDao"%>
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
<%
	String writer = request.getParameter("writer");
	String title = request.getParameter("title");
	String content = request.getParameter("content");

	MDBoardDao dao = new MDBoardDao();
	MDBoardDto dto = new MDBoardDto(writer,title,content);
	
	int res = dao.insert(dto);
	if(res > 0){
%>
	<script type="text/javascript">
		alert("글 작성 성공!");
		location.href="./boardlist.jsp";
	</script>
<%
	} else {
%>
	<script type="text/javascript">
		alert("글 작성 실패!");
		history.back();
	</script>
<%
	}
%>
	<h1>이거 보이면 안됨!</h1>

</body>
</html>









