$(document).ready(function(){
	$(".registrationForm").validate({
		rules: {
					name: {
						required: true,
						minlength:3,
						remote : {
							url: "/register/available.html",
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
