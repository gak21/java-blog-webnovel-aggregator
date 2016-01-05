$(document).ready(function(){
	$('.nav-tabs a:first').tab('show');
	$('.triggerRemove').click(function(e){
		e.preventDefault();
		$("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
		$("#modalRemove").modal();
	});
});