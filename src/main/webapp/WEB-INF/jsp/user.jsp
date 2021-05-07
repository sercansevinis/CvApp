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
<title>${user.userName}</title>
</head>
<body>
	<p><b>CVs:</b></p>
	
	<c:choose>
		<c:when test="${fn:length(user.cvs) > 0 }">
			<table>
				<c:forEach items="${user.cvs}" var="cv">
					<tr>
						<td><a href="/applicant/cv/delete/${user.id}/${cv.id}"><img src="/img/delete.png" width=20></a></td>
						<td><a href="/view/cv/${cv.id}">${cv.cvLanguage}</a></td>
						<td><a href="/applicant/cv/update/${user.id}/${cv.id}">Update</a></td>
					</tr>
					
				</c:forEach>
			</table>
		</c:when>
		
		<c:otherwise>
			<p class="small-italic">This applicant has no cv.</p>
		</c:otherwise>
	</c:choose>
	
	<p><a href="/applicant/cv/${user.id}">Add a new Cv</a></p>
	<p><a href="/display-form">Go to login page</a></p>

</body>
</html>