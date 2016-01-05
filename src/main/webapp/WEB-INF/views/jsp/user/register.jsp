<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../layout/taglib.jspf" %>

<form:form commandName="user" cssClass="form-horizontal registrationForm">
	<c:if test="${success == true}">
		<div class="alert alert-success" role="alert">
 		<span class="glyphicon glyphicon-ok-circle" aria-hidden="true"></span>
 		 Registration success
	</div>
	</c:if>

	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Name:</label>
    	<div class="col-sm-10">
      		<form:input path="name" cssClass="form-control" />
      		<form:errors path="name" />
    	</div>
	</div>
	<div class="form-group">
		<label for="email" class="col-sm-2 control-label">Email:</label>
    	<div class="col-sm-10">
      		<form:input path="email" cssClass="form-control" />
      		<form:errors path="email" />
    	</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Password:</label>
    	<div class="col-sm-10">
      		<form:password path="password" cssClass="form-control" />
      		<form:errors path="password" />
    	</div>
	</div>
	<div class="form-group">
		<label for="confirm_password" class="col-sm-2 control-label">Confirm password</label>
    	<div class="col-sm-10">
      		<input type="password" name="confirm_password" id="confirm_password" class="form-control" />
    	</div>
	</div>
	<div class="form-group">
    	<div class="col-sm-2">
			<button type="submit" class="btn btn-lg btn-primary">Save</button>
    	</div>
	</div>
</form:form>