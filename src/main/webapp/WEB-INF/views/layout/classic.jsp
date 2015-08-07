<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
	<title><tiles:getAsString name="title" /></title>
	<meta charset="UTF-8">
	<meta name="description" content="<tiles:getAsString name="description" />" >
	<meta name="keywords" content="<tiles:getAsString name="keywords" />" >
</head>
<body>
	<tiles:insertAttribute name="menu" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />
</body>
</html>