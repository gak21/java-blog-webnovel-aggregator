<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jspf" %>
<c:url value="/index/" var="pageUrl" />



<h1>Latest news</h1>
<div id="formContainer">
<table id="login" class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>date</th>
			<th>item</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${items}" var="item">
			<tr>
				<td>
					<c:out value="${item.publishedDate}" />	
					<em><c:out value="${item.blog.name}" /></em>
				</td>
				<td><strong> <a rel="nofollow" href="<c:out value="${item.link}" />"
						target="_blank"> <c:out value="${item.title}" />
					</a>
				</strong></td>
			</tr>
		</c:forEach>
	</tbody>
	
</table>

<table id="recover" class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>date</th>
			<th>item</th>
		</tr>
	</thead>
	<tbody></tbody>
</table>
	</div>


<nav id="nav-below" data-page="0">
  <ul class="pager">
  	<li class="previous flipLink hidden"><a href="#/" rel="prev"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>most recent</a></li>
    <li class="next flipLink"><a href="#formContainer" rel="next" >Older<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></a></li>
  </ul>
</nav>