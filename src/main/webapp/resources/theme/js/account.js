$(document).ready(function(){
	$(".blogForm").validate({
		rules: {
					name: {
						required: true,
						minlength:1
					},
					url: {
						required: true,
						url: true
					}
				},
				highlight: function(element){
					$(element).closest(".form-group").removeClass("has-success").addClass('has-error');
				},
				unhighlight: function(element){
					$(element).closest(".form-group").removeClass("has-error").addClass('has-success');
				}
	});
});