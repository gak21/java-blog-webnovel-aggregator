<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ include file="../layout/taglib.jspf" %>

<tilesx:useAttribute name="current" scope="request" />
<!DOCTYPE html>
<html>
<head>
	<title><tiles:getAsString name="title" /></title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	<meta name="description" content="<tiles:getAsString name="description" />" >
	<meta name="keywords" content="<tiles:getAsString name="keywords" />">
	<!-- Bootstrap core CSS and optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://bootswatch.com/slate/bootstrap.min.css">
	<link rel="stylesheet" href='<spring:theme code="styleSheet" />'>
</head>
<body>
<h1 id="h01"></h1>
	<div class="container">
		<tiles:insertAttribute name="menu" />
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer" />
	</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<c:if test="${ current == 'register' || current == 'account' }">
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>
</c:if>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<!-- For production all script files below will be added to a single file -->
<script src="<spring:theme code="index-js" />"></script>
<script src="<spring:theme code="register-js" />"></script>
<script src="<spring:theme code="detail-js" />"></script>
<script src="<spring:theme code="users-js" />"></script>
<script src="<spring:theme code="account-js" />"></script>
<script src="<spring:theme code="home2-js" />"></script>
</body>
</html>