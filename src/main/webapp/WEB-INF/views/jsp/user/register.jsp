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

<script>
$(document).ready(function(){
	$(".registrationForm").validate({
		rules: {
					name: {
						required: true,
						minlength:3,
						remote : {
							url: "<spring:url value='/register/available.html' />",
							type: "get",
							data: {
								username: function(){
									return $("#name").val();
								}
							}
						}
	
					},
					email: {
						required: true,
						email: true
					},
					password: {
						required: true,
						minlength: 5
					},
					confirm_password: {
						required: true,
						minlength: 5,
						equalTo: "#password"
					}
				},
				highlight: function(element){
					$(element).closest(".form-group").removeClass("has-success").addClass('has-error');
				},
				unhighlight: function(element){
					$(element).closest(".form-group").removeClass("has-error").addClass('has-success');
				},			
				messages: {
					name: { 
						required: "This field is required. (my message test)",
						remote:	"Username already exists"
					}
				}
	});
});
</script>
