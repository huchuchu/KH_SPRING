<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Outflearn</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">

    <!-- reference your copy Font Awesome here (from our Kits or by hosting yourself) -->
    <script src="https://kit.fontawesome.com/27cb20e940.js"></script>

    <!-- css -->
    <link rel="stylesheet" href="resources/css/LectureDetailView.css">

</head>

<body>

    <div class="row">
        <aside id="view_sidebar">
            <div id="side_header_container" class="container">
                <h5>TEST</h5>
                <p>THIS IS TEST</p>
<!--                 <div> -->
<!--                     <label>진도율 : | 총 ?? 강좌중 ?개 완료</label> -->
<!--                     <div class="progress"> -->
<!--                         <div class="progress-bar" role="progressbar" aria-valuenow="50" aria-valuemin="0" -->
<!--                             aria-valuemax="100" style="width: 0%;"> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->
            </div>
            <div id="side_content_container" class="container">
                <ul id="sidebar" class="list-group list-unstyled">
                </ul>
            </div>
        </aside>
        <div id="main" class="container">
            <nav id="header" class="nav nav-bar">
                <div class="container text-center pull-right">
                    <div class="pull-left">
                        <span><i class="fas fa-bars"></i></span>
                    </div>
                    	제목입니다. 
                    </div>
                    <div class="pull-right">
                        <span><i class="far fa-star"></i></span>
                        <span><i class="far fa-times-circle"></i></span>
                        <span><i class="far fa-question-circle"></i></span>
                    </div>
            </nav>
            <div id="content">
            	<p align="center" id="content-media">
            		<input type="hidden" id="video_id" value="${DATA_DATA }">
            	</p>
            </div>
            <div id="bookmark_group" class="text-center">
            	<button onclick="bookmark()" style="position: relative">책갈피</button>
            	<div id="bookmark" style="width: 100%; height: 200px; overflow-y: scroll;"></div>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="resources/js/template/jquery.1.11.1.js"></script>
    <script type="text/javascript" src="resources/js/template/LectureDetailView.js"></script>
    <script type="text/javascript" src="resources/js/template/bootstrap.js"></script>
</body>

</html>