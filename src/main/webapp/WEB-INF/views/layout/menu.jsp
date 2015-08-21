<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ include file="../layout/taglib.jspf" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<jsp:useBean id="current" type="java.lang.String" scope="request"/>
<c:url value="/logout" var="logoutUrl" />

 	<nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<spring:url value="/" />">Web Novel Crossroads</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="${current == 'index' ? 'active' : ''}"><a href="<spring:url value="/" />">Home</a></li>
              <security:authorize access="hasRole('ROLE_ADMIN')">
              <li class="${current == 'users' ? 'active' : ''}"><a href="<spring:url value="/users.html" />">Users</a></li>
              </security:authorize>
              <li class="${current == 'register' ? 'active' : ''}"><a href="<spring:url value="/register.html" />">Register</a></li>
              <security:authorize access="! isAuthenticated()">
              	<li class="${current == 'login' ? 'active' : ''}"><a href="<spring:url value="/login.html" />">Login</a></li>
              </security:authorize>
              <security:authorize access="isAuthenticated()">
              <li class="${current == 'account' ? 'active' : ''}" ><a href="<spring:url value="/account.html" />">My account</a></li>
              <li><a href="#" onclick="document.forms[0].submit();">Logout</a></li>
              	<!-- spring security log out for csrf  -->
			  <form method="post" action="${logoutUrl}" id="form-logout">  	
    	 		<security:csrfInput/>       
			  </form>
              </security:authorize>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
	</nav>