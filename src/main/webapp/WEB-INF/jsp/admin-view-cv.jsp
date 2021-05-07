<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/style.css">
<meta charset="UTF-8">
<title>View CV</title>
</head>
<body>
	<p><b>CVs of the applicant:</b></p>
	
	<c:choose>
		<c:when test="${fn:length(applicant.cvs) > 0 }">
			<table>
				<c:forEach items="${applicant.cvs}" var="cv">
					<tr>
						<td><a href="/view/cv/${cv.id}">Cv in ${cv.cvLanguage}</a></td>
					</tr>
					
				</c:forEach>
			</table>
		</c:when>
		
		<c:otherwise>
			<p class="small-italic">This applicant has no cv.</p>
		</c:otherwise>
	</c:choose>
	<p><a href="/display-form">Go to login page</a></p>
	
</body>
</html>