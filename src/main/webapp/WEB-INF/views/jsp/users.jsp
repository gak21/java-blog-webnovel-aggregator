<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jspf" %>

<table class="table table-bordered table-hover table-striped">
    <thead>
        <tr>
            <th>User name</th>   
            <th>Operation</th>   
        </tr>
    </thead>
    <tbody>
    	<c:forEach items="${users}" var="user">
    		<tr>
            	<td>
            	<a href='<spring:url value="/users/${user.id}.html" />'><c:out value="${user.name}" /></a>
				</td>
				<td><a href='<spring:url value="/user/remove/${user.id}.html" />' class="btn btn-danger triggerRemove">remove</a></td>
       		 </tr>
    	</c:forEach>
    </tbody>
</table>

  <!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Remove user</h4>
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