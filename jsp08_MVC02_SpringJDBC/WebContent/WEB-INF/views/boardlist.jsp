<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8");%>
<% response.setContentType("text/html; charset=UTF-8"); %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">

	$(function(){
		$("#muldelform").submit(function(){
			
			if($("#muldelform input:checked").length ==0){
				alert("한개이상 체크해주세요");
				return false;
			}
		});
	});
	
	function allChk(bool){
		var chks = document.getElementsByName("chk");
		for(var i=0; i<chks.length; i++){
			chks[i].checked=bool;
		}
	}




</script>
</head>
<body>

	<h1>글 목록</h1>
	<form action="muldel.spr" method="post" id="muldelform">
	<table border="1">
		<col width="30"/>
		<col width="50"/>
		<col width="100"/>
		<col width="300"/>
		<col width="100"/>
		<tr>
			<th>
			<input type="checkbox" name="all" onclick="allChk(this.checked)">
			</th>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
		</tr>
		
		<c:choose>
		<c:when test="${empty list }">
			<tr>
			<td colspan="5" align="center">----작성된 글이 존재하지않습니다----</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${list }" var="dto">
				<tr>
					<td>
					<input type="checkbox" name="chk" value="${dto.seq }">
					</td>
					<td>${dto.seq }</td>
					<td>${dto.writer }</td>
					<td><a href="boarddetail.spr?seq=${dto.seq }">${dto.title }</a></td>
					<td>${dto.regdate }</td>
				</tr>
			
			</c:forEach>
			
		</c:otherwise>
		</c:choose>	
		
		<tr>
		<td colspan="5">
			<input type="button" value="글쓰기" onclick="location.href='insertform.spr'">
			<input type="submit" value="삭제"/>
		</td>
		</tr>	
	</table>
	</form>
</body>
</html>