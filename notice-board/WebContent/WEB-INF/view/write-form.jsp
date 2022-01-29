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
		<h2>Write Board</h2>
		
		<form:form action="saveBoard" modelAttribute="board" method="POST">
			
			<form:hidden path="id"/>
			<form:hidden path="visitcount" value="0"/>
			
			<table>
				<tbody>
					<tr>
						<td>Title: </td>
						<td><form:input path="title"/></td>
					</tr>
					
					<tr>
						<td>Content: </td>
						<td><form:textarea path="content"/></td>
					</tr>
					
					<tr>
						<td></td>
						<td><input type="submit" value="Save"/></td>
					</tr>

					</tr>
				</tbody>
			</table>
			
		</form:form>
		
		<p>
			<a href="${ pageContext.request.contextPath }/board/list">Back to the List!</a>
		</p>
	</div>

</body>

</html>