<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<!--   <meta name="viewport" content="width=device-width, initial-scale=1"> -->
	<!--   <meta name="description" content=""> -->
	<!--   <meta name="author" content=""> -->

	<title>Outflearn</title>
	<!-- Bootstrap -->
	<!--   <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css"> -->
	<!--   <link rel="stylesheet" type="text/css" href="resources/fonts/font-awesome/css/font-awesome.css"> -->

	<!-- Stylesheet
    ================================================== -->
	<!--   <link rel="stylesheet" type="text/css" href="resources/css/style.css"> -->
	<!--   <link rel="stylesheet" type="text/css" href="resources/css/nivo-lightbox/nivo-lightbox.css"> -->
	<!--   <link rel="stylesheet" type="text/css" href="resources/css/nivo-lightbox/default.css"> -->
	<!--   <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet"> -->
	<!--   <link href="https://fonts.googleapis.com/css?family=Lato:400,700" rel="stylesheet"> -->
	<!--   <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,500,600,700,800,900" rel="stylesheet"> -->

	<!-- reference your copy Font Awesome here (from our Kits or by hosting yourself) -->
	<!--   <script src="https://kit.fontawesome.com/27cb20e940.js"></script> -->

</head>

<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">
	<!-- Contact Section -->
	<div id="contact">
		<div class="container">
			<div class="col-md-8">
				<div class="row">
					<div class="section-title">
						<h2>SiteMap</h2>
						<div id="contact-category" class="row">
							<div class="col-md-8">
								<div class="row">
									<p>분야별 강좌</p>
								
								
									<div class="col-md-4">
									
										<c:forEach items="${mainList }" var="mainDto">
											<div style="float: left">
										<p>${mainDto.main_name}</p>
										<ul class="sitemap-list">
										  <c:forEach items="${subList }" var="subDto">
										  	<c:if test="${mainDto.main_num eq subDto.main_num }">
											<li>
												<p>- <a href="SubCategory?sub_num=${subDto.sub_num}" class="nav-link active sub_category">${subDto.sub_name}</a></p>
											</li>
												</c:if>
										 </c:forEach>
										 </ul>
										 </div>
										</c:forEach>
										
									</div>
									
							<div class="col-md-3">
								<ul>
									<li class="contact-nav-menu">
										<p><a href="">로드맵 학습</a></p>
									</li>
									<li class="contact-nav-menu">
										<p><a href="">아웃프런 소개</a></p>
									</li>
									<li class="contact-nav-menu">
										<p><a href="">라이브</a></p>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-3 col-md-offset-1 contact-info">
				<div class="contact-item">
					<h3>Contact Info</h3>
					<p><span><i class="fa fa-map-marker"></i> Address</span>4321 California St,<br>
						San Francisco, CA 12345</p>
				</div>
				<div class="contact-item">
					<p><span><i class="fa fa-phone"></i> Phone</span> +1 123 456 1234</p>
				</div>
				<div class="contact-item">
					<p><span><i class="fa fa-envelope"></i> Email</span> info@company.com</p>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="resources/js/template/jquery.1.11.1.js"></script>
	<script type="text/javascript" src="resources/js/template/bootstrap.js"></script>
	<script type="text/javascript" src="resources/js/template/jqBootstrapValidation.js"></script>
</body>

</html>