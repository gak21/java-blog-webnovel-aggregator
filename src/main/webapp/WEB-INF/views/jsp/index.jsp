<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jspf" %>

<h1>Latest news</h1>

<table class="table table-bordered table-hover table-striped">
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
					<c:out value="${item.publishedDate}" />	<br>	
					<c:out value="${item.blog.name}" />
				</td>
				<td><strong> <a href="<c:out value="${item.link}" />"
						target="_blank"> <c:out value="${item.title}" />
					</a>
				</strong> <br /> <c:out value="${item.description}" escapeXml="false" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>