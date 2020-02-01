<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
			if($("#muldelform input:checked").length==0){
				alert("한개이상 체크해주세요!!!");
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
<script type="text/javascript">
	$(function(){
		$("input[name=chk]").click(function(){
		if($("input[name=chk]").length == $("input[name=chk]:checked").length){
			$("input[name=all]").prop("checked", true);
		}else{
			$("input[name=all]").prop("checked",false);
		}
			
		});
	});

</script>



</head>
<body>
	<h1>전체목록</h1>
	
	<c:choose>
		<c:when test="${empty list }">
			<h3>고객 정보가 없습니다</h3>
		</c:when>
		<c:otherwise>
		<form action="muldel.do" method="post" id="muldelform">
			<table border="1">
				<col width="30">
				<col width="100">
				<col width="300">
				<col width="200">
				
				<tr>
				<th><input type="checkbox" name="all" onclick="allChk(this.checked)"></th>
				<th>ID</th>
				<th>PASSWORD</th>
				<th>NAME</th>
				</tr>
				
				<c:forEach items="${list }" var="dto">
					<tr>
						<td><input type="checkbox" name="chk" value="${dto.id }"></td>
						<td><a href="selectone.do?id=${dto.id }">${dto.id }</a></td>
						<td>${dto.password}</td>
						<td>${dto.name }</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4">
						<input type="button" value="처음으로" onclick="location.href='/webapp/index.jsp'">
						<input type="button" value="추가" onclick="location.href='insertform.do'">
						<input type="submit" value="삭제" >
					</td>
				</tr>
			</table>
			</form>
		</c:otherwise>
	</c:choose>


</body>
</html>