<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/style.css">
<meta charset="UTF-8">
<title>Admin View PAGE</title>
</head>
<body>
	<c:choose>
		<c:when test="${fn:length(applicants) > 0 }">
			<table class="box">
				<tr>
					<th>ID</th>
					<th>User Name</th>
					<th>Email</th>
					<th></th>
				</tr>
				
			<c:forEach items="${applicants}" var="a">
				<tr>
					<td>${a.id}</td>
					<td>${a.userName}</td>
					<td>${a.email}</td>
					<td><a href="/applicant/${a.id}">More</a></td>
				</tr>
			</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<p class="small-italic">No applicants found</p>
		</c:otherwise>
	</c:choose>
</body>
</html>