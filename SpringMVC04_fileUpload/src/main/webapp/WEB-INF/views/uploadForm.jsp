<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%request.setCharacterEncoding("UTF-8");%>
<%response.setContentType("text/html; charset=UTF-8");%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
									<!-- file형태로 넘어감 -->	<!-- uploadFile객체에 담겨서 넘어감 -->
	<form:form method="post" enctype="multipart/form-data" modelAttribute="uploadFile" action="upload">
		<h3>업로드 할 파일 선택</h3>
		파일 : <input type="file" name="file" /><br/>
		<p style="color: red; font-weight: bold;">
			<form:errors path="file" /> <!-- file: uploadFile에 있는 file 필드이름/BindingResult와 암께 쓴다  -->
		</p><br/>
		설명 : <br/>
		<textarea rows="10" cols="40" name="desc" ></textarea><br/>
		<input type="submit" value="전송">
	</form:form>


	<!-- form:form
			spring form: tag
			form: form, form:input,...
			form: errors --- Errors, BindingResult를 사용할 때 command객체의 특정 field에서 발생하는 에러메세지 출력 가능	
	 -->
	 
	 <!-- 
	 		form tag의 enctype 속성
	 		1. application/www-form-url encoded : (default)문자들이 encoding 됨
	 		2. multipart/form-data : file-upload가능.(post)
	 		3. text/plain : encoding 안됨
	 
	  -->	
	

	


</body>
</html>