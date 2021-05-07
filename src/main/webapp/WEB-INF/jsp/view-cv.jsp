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
<title>Cv</title>
</head>
<body>
	<h2>View Cv</h2>
	<javatime:format value="${cv.dateOfBirth}" pattern="dd-MM-yyy" var="formattedDate"/>
	<table class="bordered">
		<tr>
			<td>Full Name:</td>
			<td>${cv.fullName}</td>
		</tr>
		<tr>
			<td>Date of Birth:</td>
			<td>${formattedDate}</td>
		</tr>
		<tr>
			<td>Cv Language:</td>
			<td>${cv.cvLanguage}</td>
		</tr>
		<tr>
			<td>Gender</td>
			<td>${cv.gender}</td>
		</tr>
		<tr>
			<td>Email:</td>
			<td>${cv.eMail}</td>
		</tr>
		<tr>
			<td>Address:</td>
			<td>${cv.address}</td>
		</tr>
		<tr>
			<td>Nationality:</td>
			<td>${cv.nationality}</td>
		</tr>
		<tr>
			<td>School:</td>
			<td>${cv.schoolName}</td>
		</tr>
		<tr>
			<td>Gpa:</td>
			<td>${cv.gpa} gpa</td>
		</tr>
		<tr>
			<td>Skills:</td>
			<td>${cv.skills}</td>
		</tr>
		<tr>
			<td>Projects and Certificates:</td>
			<td>${cv.projects}</td>
		</tr>
	</table>
</body>
</html>