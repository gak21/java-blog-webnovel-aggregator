<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jspf" %>

<details>
	<c:if test="${success == true}">
		<div class="alert alert-success" role="alert">
 		<span class="glyphicon glyphicon-ok-circle" aria-hidden="true"></span>
 		  Added blog success
	</div>
	</c:if>	
	<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  Add blog
</button>
<form:form commandName="blog" cssClass="form-horizontal blogForm">

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">New blog</h4>
      </div>
      <div class="modal-body">
        <div class="form-group">
			<label for="name" class="col-sm-2 control-label">Name:</label>
    		<div class="col-sm-10">
      			<form:input path="name" cssClass="form-control" />
      			<form:errors path="name" />
    		</div>
		</div>
		
        <div class="form-group">
			<label for="url" class="col-sm-2 control-label">URL:</label>
    		<div class="col-sm-10">
      			<form:input path="url" cssClass="form-control" />
      			<form:errors path="url" />
    		</div>
		</div>
		
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Save</button>
      </div>
    </div>
  </div>
</div>
</form:form>
<br>


  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
  <c:forEach items="${user.blogs}" var="blog">
 	 <li><a href="#blog_${blog.id}" data-toggle="tab"><c:out value="${blog.name}" /></a></li>
  </c:forEach>
  </ul>



  <!-- Tab panes -->
  <div class="tab-content">
  <c:forEach items="${user.blogs}" var="blog">
    <div class="tab-pane" id="blog_${blog.id}">
    <h1><c:out value="${blog.name}" /></h1>
		<p>
		<a href='<spring:url value="/blog/remove/${blog.id}.html" />' class="btn btn-danger triggerRemove">remove</a>
		<c:out value="${blog.url}" /></p>
		<table class="table table-bordered table-hover table-striped">
		    <thead>
				<tr>
           		  <th>date</th>   
         		  <th>item</th>   
				</tr>
  			</thead>
			<tbody>
    			<c:forEach items="${blog.items}" var="item">
    				<tr>
    					<td><c:out value="${item.publishedDate}" /></td>
    					<td>
    					<strong>
    						<a href="<c:out value="${item.link}" />" target="_blank">
    							<c:out value="${item.title}" />
    						</a>
    					</strong>
    					<br />
    					<c:out value="${item.description}" />
    					</td>
    				</tr>
    			</c:forEach>
   			</tbody>
		</table>
    </div>
  </c:forEach>
  </div>
  
  <!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Remove blog</h4>
      </div>
      <div class="modal-body">
        Are u sure?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <a href="" class="btn btn-danger removeBtn" >Remove</a>
      </div>
    </div>
  </div>
</div>
  <script>
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
</script>
</details>