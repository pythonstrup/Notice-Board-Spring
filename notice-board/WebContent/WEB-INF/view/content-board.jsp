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
			
			<tr>
				<td>${board.id}</td>
				<td>${ board.title }</td>
				<td>${ board.visitcount }</td>
				<td>${ board.postdate }</td>
			</tr>
			
			<tr>
				<td>${ board.content }</td>
			</tr>
		</table>
		
	</div>
	<br>
	<hr>
	<a href="${ pageContext.request.contextPath }/board/list">목록으로 돌아가기</a>
	

</body>

</html>