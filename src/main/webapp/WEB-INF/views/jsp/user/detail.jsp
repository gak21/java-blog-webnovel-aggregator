<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../layout/taglib.jspf" %>

<details>
	<c:if test="${param.success == true}">
		<div class="alert alert-success" role="alert">
 		<span class="glyphicon glyphicon-ok-circle" aria-hidden="true"></span>
 		  Added blog success
	</div>
	</c:if>
	<h1><c:out value="${user.name}" /></h1>
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
           		  <th>Title</th>   
         		  <th>Link</th>   
				</tr>
  			</thead>
			<tbody>
    			<c:forEach items="${blog.items}" var="item">
    				<tr>
    					<td><c:out value="${item.title}" /></td>
    					<td><c:out value="${item.link}" /></td>
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
  
</details>