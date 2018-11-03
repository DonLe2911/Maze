<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta charset="UTF-8">
    <%@include file="/imports/imports_css.jsp"%>
    <link rel="stylesheet" type="text/css" href="resources/css/welcome.css">
    <%@include file="/imports/imports_javascript.jsp"%>
    <script type="text/javascript" src="resources/js/pages/welcome.js"></script>
    <title>Kainos Maze</title>
</head>
<body> 
	<!-- IMPORT -->
	<%@include file="/imports/imports_general.jsp"%>
    
    <!-- HEADER -->
    <%@include file="/components/header.jsp"%>
    
    <!--
    <div class="bg">
        <video autoplay muted loop class="fullscreen_bgvideo">
                <source src="https://cdn1.kainos.com/assets/Kainos-Background-Video2-010d1914328ccf4ce1c86c34537f815f8d4c332a669057e88c67848c59f4b887.mp4" type="video/mp4">
                <source src="https://cdn1.kainos.com/assets/Kainos-Background-Video2-6d99ad2e5647c9a9838fda52dbf4d374da77433fef1f79df580fb83eef821973.webm" type="video/webm">
                <source src="https://cdn1.kainos.com/assets/Kainos-Background-Video2.dream.theora-bbfe80e0f4bc729fbc9c56f5270cc2f3869235e35dc890b9fd6c988afb63f367.ogv" type="video/ogg">
        </video>
    </div>-->
    <div class="welcome_container">
        <div id="welcome">
            <div class="title"><span>Instructions</span></div>
            <div class="instructions">
                Solve the maze using the given instructions. Each instruction should be written on a different line
                as shown in the example below. Note that each instruction can only be used twice. Time will start when you click play!
            </div>
            <div class="example">
              <span><b>move left</b> (rotates arrow left 90 degrees and then move forward one step)</span><br>
              <span><b>move right</b> (rotates arrow right 90 degrees and then move forward one step)</span><br>
              <span><b>move forward</b> (arrow will move forward one step)</span><br>
              <span><b>jump left</b> (rotates arrow left 90 degrees and then jump forward two steps)</span><br>
              <span><b>jump right</b> (rotates arrow right 90 degrees and then jump forward two steps)</span><br>
              <span><b>jump forward</b> (jump forward two steps)</span><br>
              <span><b>repeat</b> (repeats previous commands in order x 3)</span><br>
            </div>
            <div class="run">
			    <c:choose>
			    	<c:when test="${not empty sessionScope.username}">
			    		<a href="<%=Tag.path_level1%>" class="btn btn-lg">Play</a> 
			    	</c:when>
			    	<c:otherwise>
		            	<input type="text" class="form-control form-control-lg" name="username" required placeholder="Please enter your username here"/>
		                <button id="play" class="btn btn-lg">Play</button>
	            	</c:otherwise> 
	            </c:choose>
            </div>
        </div>
    </div>
</body>
</html>