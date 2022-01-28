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
				<td>num</td>
				<td>title</td>
				<td>visitcount</td>
				<td>postdate</td>
			</tr>
			
			<c:forEach var="tempBoard" items="${boards}">
			
			<c:url var="contentLink" value="/board/content">
				<c:param name="contentId" value="${ tempBoard.id }"></c:param>
			</c:url>
				<tr>
					<td>${ tempBoard.id }</td>
					<td><a href="${contentLink}">${ tempBoard.title }</a></td>
					<td>${ tempBoard.visitcount }</td>
					<td>${ tempBoard.postdate }</td>
				</tr>
			</c:forEach>
			
		</table>
	
	</div>

</body>

</html>