<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.muldel.dao.MDBoardDao" %>
<%@ page import="com.muldel.dto.MDBoardDto" %>
<%@ page import="java.util.List" %>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.0.min.js"></script>

<script type="text/javascript">

	$(function(){
		$("#muldelform").submit(function(){
			if($("#muldelform input:checked").length == 0){
				alert("뿅뿅");
				return false;//이벤트 전파 방지 
			}
		});
	})
	
	function allChk(bool){
		var chks=document.getElementsByName("chk");
		for(var i=0; i<chks.length; i++){
			chks[i].checked=bool;
		}
	}

</script>


</head>
<%
	MDBoardDao dao = new MDBoardDao();
	List<MDBoardDto> list = dao.selectList();
%>
<body>

	<%@ include file="./form/header.jsp" %>
	
	<h1>글 목록</h1>
	
	<form action="./muldel.jsp" method="post" id="muldelform">
		<table border="1">
			<col width="30px"/>
			<col width="50px"/>
			<col width="100px"/>
			<col width="300px"/>
			<col width="100px"/>
			<tr>
				<th>
				<input type="checkbox" name="all"onclick="allChk(this.checked)" />
				</th>
				<th>번호</th>
				<th>작성자</th>
				<th>제  목</th>
				<th>작성일</th>
			</tr>
<%
			if(list.size() == 0){
%>			
				<tr>
					<td colspan="5">---------글이 존재하지 않습니다---------</td>
				</tr>
<%
			} else {
				for(int i = 0; i < list.size(); i++){
%>
					<tr>
						<td><input type="checkbox" name="chk" value="<%=list.get(i).getSeq()%>"/></td>
						<td><%=list.get(i).getSeq() %></td>
						<td><%=list.get(i).getWriter() %></td>
						<td><a href="boarddetail.jsp?seq=<%=list.get(i).getSeq()%>"><%=list.get(i).getTitle() %></a></td>     
						<td><%=list.get(i).getRegdate() %></td>
					</tr>
<%
				}
			}
%>
			<tr>
				<td colspan="5">
					<input type="button" value="글쓰기" onclick="location.href='boardinsert.jsp'" />
					<input type="submit" value="선택삭제" />
				</td>
			</tr>
		</table>	
	</form>
	
	<%@ include file="./form/footer.jsp" %>

</body>
</html>









