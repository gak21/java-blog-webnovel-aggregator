<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jspf" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<c:url var="postloginUrl" value="/login" />

<style>
body {
  padding-top: 40px;
  padding-bottom: 40px;
  background-color: #eee;
}

.form-signin {
  max-width: 330px;
  padding: 15px;
  margin: 0 auto;
}
.form-signin .form-signin-heading,
.form-signin .checkbox {
  margin-bottom: 10px;
}
.form-signin .checkbox {
  font-weight: normal;
}
.form-signin .form-control {
  position: relative;
  height: auto;
  -webkit-box-sizing: border-box;
     -moz-box-sizing: border-box;
          box-sizing: border-box;
  padding: 10px;
  font-size: 16px;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
</style>

<c:if test="${param.failed == true}">
	<div class="alert alert-danger" role="alert">
 		<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
 		 The password is incorrect. Try again
	</div>
</c:if>

 <form class="form-signin" role="form" action="${postloginUrl}" method="POST">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="name" class="sr-only">Email address</label>
        <input type="text" name="username" id="name" class="form-control" placeholder="Name" required autofocus>
        <label for="password" class="sr-only">Password</label>
        <input type="password" name="password" id="password" class="form-control" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <security:csrfInput/>        
</form>