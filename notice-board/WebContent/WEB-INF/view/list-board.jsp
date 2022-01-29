<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>

<head>
	<title>Notice Board</title>
</head>

<body>
	<div>
	
		<table>
			<tr>
				<td>Number</td>
				<td>Title</td>
				<td>Visit Count</td>
				<td>Post Date</td>
				<td>Modify</td>
			</tr>
			
			<c:forEach var="tempBoard" items="${boards}">
			
			<c:url var="contentLink" value="/board/content">
				<c:param name="contentId" value="${ tempBoard.id }"></c:param>
			</c:url>
			
			<c:url var="updateLink" value="/board/update">
				<c:param name="contentId" value="${ tempBoard.id }"></c:param>
			</c:url>
			
			<c:url var="deleteLink" value="/board/delete">
				<c:param name="contentId" value="${ tempBoard.id }"></c:param>
			</c:url>
			
				<tr>
					<td>${ tempBoard.id }</td>
					<td><a href="${contentLink}">${ tempBoard.title }</a></td>
					<td>${ tempBoard.visitcount }</td>
					<td>${ tempBoard.postdate }</td>
					<td>
						<a href="${ updateLink }">Update</a>
						|
						<a href="${ deleteLink }">Delete</a>
					</td>
				</tr>
			</c:forEach>
			
		</table>
		
		<input type="button" value="Write Board"
			onclick="window.location.href='write'; return false;"/>
	</div>

</body>

</html>