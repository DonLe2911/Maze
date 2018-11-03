<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <%@include file="/imports/imports_css.jsp"%>
    <link rel="stylesheet" type="text/css" href="resources/css/game.css">
    <%@include file="/imports/imports_javascript.jsp"%>
    <script type="text/javascript" src="resources/js/libs/websocket.js"></script>
    <script type="text/javascript" src="resources/js/pages/level1.js"></script>
    <title>Maze</title>
</head>
<body>
	<!-- IMPORT -->
	<%@include file="/imports/imports_general.jsp"%>
	
    <!-- HEADER -->
    <%@include file="/components/header.jsp"%>

	<!-- GAME VIEW -->
	<%@include file="/components/game_view.jsp"%>
</body>
</html>