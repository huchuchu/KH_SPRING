<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Outflearn</title>

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="resources/fonts/font-awesome/css/font-awesome.css">

<!-- Stylesheet
    ================================================== -->
<link rel="stylesheet" type="text/css" href="resources/css/style.css">

<!-- reference your copy Font Awesome here (from our Kits or by hosting yourself) -->
<script src="https://kit.fontawesome.com/27cb20e940.js"></script>

<!-- css -->
<link rel="stylesheet" href="resources/css/LectureList.css">
</head>
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">
	<!-- ==========================================Navigation==========================================-->
	<nav id="menu" class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" data-target="#bs-example-navbar-collapse-1" class="navbar-toggle collapsed bs-btn">
					<span class="sr-only">Toggle navigation</span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand page-scroll" href="home" style="color: #6372ff">OUTFLEARN</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-center">
					<li class="dropdown"><a href="void:0" class="dropdown-toggle"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">분야별
							강좌<i class="fas fa-chevron-down"></i></a>
							<ul class="dropdown-menu" role="menu">
								<li id="server" class="dropdown-submenu server">
									<a href="void:0" class="dropdown dropdown-toggle dropdown-item" data-toggle="dropdown">서버&nbsp;
									<i class="fas fa-chevron-right pull-right"></i></a>
									<ul class="dropdown-menu server_list">
										<li class="dropdown-item">
										<c:forEach items="${subList }" var="subDto">
										<c:if test="${mainDto.main_num eq subDto.main_num }">
											<li><a href="SubCategory?sub_num=${subDto.sub_num}" class="nav-link active sub_category">${subDto.sub_name}</a></li>
										</c:if>
									</c:forEach>
									</li>
									</ul>
								</li>
								<li class="dropdown-submenu server">
									<a href="void:0" class="dropdown dropdown-toggle dropdown-item" data-toggle="dropdown">웹 개발 <i class="fas fa-chevron-right pull-right"></i></a>
									<ul class="dropdown-menu server_list">
										<li class="dropdown-item"><a href="void:0">Front End</a></li>
										<li class="dropdown-item"><a href="void:0">html/css</a></li>
										<li class="dropdown-item"><a href="void:0">javascript</a></li>
										<li class="dropdown-item"><a href="void:0">Angular</a></li>
										<li class="dropdown-item"><a href="void:0">Reactjs</a></li>
										<li class="dropdown-item"><a href="void:0">Vuejs</a></li>
									</ul>
								</li>
								<li class="dropdown-submenu server">
									<a href="void:0" class="dropdown dropdown-toggle dropdown-item" data-toggle="dropdown">데이터베이스<i class="fas fa-chevron-right pull-right"></i></a>
									<ul class="dropdown-menu server_list">
										<li class="dropdown-item"><a href="void:0">Oracle</a></li>
										<li class="dropdown-item"><a href="void:0">PL/SQL</a></li>
										<li class="dropdown-item"><a href="void:0">MySQL</a></li>
										<li class="dropdown-item"><a href="void:0">MongoDB</a></li>
									</ul>
								</li>
							</ul>							
					</li>
					<li><a href="void:0">로드맵 학습</a></li>
					<li><a href="void:0">아웃프런 소개</a></li>
					<li><a href="void:0">라이브</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<sec:authorize access="isAnonymous()">
          				<li><a href="/Outflearn/loginform">로그인</a></li>
          				<li><a href="/Outflearn/registerform.do">회원가입</a></li>
          			</sec:authorize>
          			<sec:authorize access="isAuthenticated()">
            			<li><a href="/Outflearn/myPage">마이페이지</a></li>
            			<li><a href="/Outflearn/MemberInfoUpdateForm.do">회원정보 수정</a></li>
          			<li><a href="/Outflearn/logout">로그아웃</a></li>  
          			</sec:authorize>
				</ul>
			</div>
		</div>
	</nav>

	<script type="text/javascript" src="resources/js/template/jquery.1.11.1.js"></script>
	<script type="text/javascript" src="resources/js/template/header.js"></script>
	<script type="text/javascript" src="resources/js/template/bootstrap.js"></script>
	<script type="text/javascript" src="resources/js/template/jqBootstrapValidation.js"></script>
</body>
</html>