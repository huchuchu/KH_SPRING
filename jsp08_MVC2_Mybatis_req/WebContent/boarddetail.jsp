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
<!-- request로 담았기때문에 scope를 request로 설정해준다! -->
<!-- dto객체를 생성하는게 아니라!!! dto객체를 받은거!! -->
<!-- 따라서 setproperty를 해줄필요 없다!! -->
<!-- textarea에 유즈빈 넣을 때 엔터치면 공백들어가니까 엔터 없이 쓰기!! -->
<jsp:useBean id="dto" class="com.mvc.dto.MyMvcDto" scope="request"></jsp:useBean>

		<h1>선택 글 읽기</h1>

		<table border="1">
			<tr>
				<th>번호</th>
				<td>
				<jsp:getProperty property="seq" name="dto"/>
				</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>
				<jsp:getProperty property="regdate" name="dto"/>
				</td>
			</tr>		
			<tr>
				<th>작성자</th>
				<td>
				<jsp:getProperty property="writer" name="dto"/>
				</td>			
			</tr>
			<tr>
				<th>제목</th>
				<td>
				<jsp:getProperty property="title" name="dto"/>
				</td>			
			</tr>
			<tr>
				<th>내용</th>
				<td>
				<textarea rows="10" cols="60" readonly="readonly"><jsp:getProperty property="content" name="dto"/></textarea>
				</td>			
			</tr>
			<tr>
			<td colspan="2">
				<input type="submit" value="수정" onclick="location.href='updateform?seq=<jsp:getProperty property="seq" name="dto"/>'"/>
				<input type="button" value="삭제" onclick="location.href='delete?seq=<jsp:getProperty property="seq" name="dto"/>'"/>
				<input type="button" value="목록" onclick="location.href='controller.do?command=list'"/>
				
			</td>
			</tr>
		</table>

</body>
</html>