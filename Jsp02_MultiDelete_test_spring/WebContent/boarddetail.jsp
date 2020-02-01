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
<title>boarddetail.jsp</title>

<style type="text/css">

	#updateform{
		display: none;
	}

</style>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.0.min.js"></script>

<script type="text/javascript">

	function updateformView(){
		$("#detailform").hide();
		$("#updateform").show();
	}
	
	function detailformView(){
		$("#detailform").show();
		$("#updateform").hide();
	}

</script>

</head>
<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	MDBoardDao dao = new MDBoardDao();
	MDBoardDto dto = dao.selectOne(seq);
%>
<body>

	<%@ include file="form/header.jsp" %>

	<div id="detailform">
		<h1>게시글 상세보기</h1>
		
		<table border="1">
			<tr>
				<th>번호</th>
				<td><%=dto.getSeq() %></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%=dto.getWriter() %></td>
			</tr>
			<tr>
				<th>작성일</th>
				<td><%=dto.getRegdate()%></td>
			</tr>
			<tr>
				<th>제  목</th>
				<td><%=dto.getTitle() %></td>
			</tr>
			<tr>
				<th>내  용</th>
				<td>
					<textarea rows="10" cols="60" 
						readonly="readonly"><%=dto.getContent() %></textarea>            
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="수정" onclick="updateformView()"/>
					<input type="button" value="삭제" onclick="location.href='./boarddelete.jsp?seq=<%=dto.getSeq()%>'"/>
					<input type="button" value="목록" onclick="location.href='./boardlist.jsp'"/>
				</td>
			</tr>
		</table>
	</div>

	<div id="updateform">
		<h1>글 수정</h1>
		
		<form action="boardupdateres.jsp" method="post">
			<input type="hidden" name="seq" value="<%=dto.getSeq()%>">
			<table border="1">
				<tr>
					<th>번호</th>
					<td><%=dto.getSeq() %></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><%=dto.getWriter() %></td>
				</tr>
				<tr>
					<th>작성일</th>
					<td><%=dto.getRegdate() %></td>
				</tr>
				<tr>
					<th>제  목</th>
					<td><input type="text" name="title" 
							value="<%=dto.getTitle()%>"></td>
				</tr>
				<tr>
					<th>내  용</th>
					<td><textarea rows="10" cols="60"
						name="content"><%=dto.getContent()%></textarea></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="수정"/>
						<input type="button" value="취소" onclick="detailformView()" />
						<input type="button" value="목록" onclick="location.href='./boardlist.jsp'"/>	
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<%@ include file="form/footer.jsp" %>

</body>
</html>










