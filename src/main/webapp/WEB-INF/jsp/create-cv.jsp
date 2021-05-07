<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/style.css" >
<meta charset="UTF-8">
<title>Create a new Cv</title>
</head>
<body>
<form:form method="post" action="/applicant/cv/add" modelAttribute="cv">
	<table>
		<tr>
			<td>Full Name:</td>
			<td><form:input path="fullName"/></td>
			<td><form:errors path="fullName" cssClass="error"></form:errors></td>
		</tr>
		<tr>
			<td>CV Language</td>
			<td>
					<form:select path="cvLanguage">
						<form:option value="Turkish" label="Turkish"/>
						<form:option value="English" label="English"/>
						<form:option value="Spanish" label="Spanish"/>
						<form:option value="French" label="French"/>
						<form:option value="Russian" label="Russian"/>
						<form:option value="German" label="German"/>
					</form:select></td>
				<td>&nbsp;</td>
		</tr>
		<tr>
			<td>Gender</td>
			<td>
				<form:select path="gender">
					<form:option value="Male" label="Male"/>
					<form:option value="Female" label="Female"/>
				</form:select>
			</td>
				<td>&nbsp;</td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><form:input path="eMail"/></td>
			<td><form:errors path="eMail" cssClass="error"></form:errors></td>
		</tr>
		<tr>
			<td>Address:</td>
			<td><form:input path="address"/></td>
			<td><form:errors path="address" cssClass="error"></form:errors></td>
		</tr>
		<tr>
			<td>Nationality:</td>
			<td><form:input path="nationality"/></td>
			<td><form:errors path="nationality" cssClass="error"></form:errors></td>
		</tr>
		
		<tr>
			<td>Birth Day:</td>
			<td><form:input path="dateOfBirth"/></td>
			<td><form:errors path="dateOfBirth" cssClass="error"></form:errors></td>
		</tr>
		
		<tr>
			<td>School:</td>
			<td><form:input path="schoolName"/></td>
			<td><form:errors path="schoolName" cssClass="error"></form:errors></td>
		</tr>
		
		<tr>
			<td>Gpa:</td>
			<td><form:input path="gpa"/></td>
			<td><form:errors path="gpa" cssClass="error"></form:errors></td>
		</tr>
		
		<tr>
			<td>Skills:</td>
			<td><form:input path="skills"/></td>
			<td><form:errors path="skills" cssClass="error"></form:errors></td>
		</tr>
		
		<tr>
			<td>Projects and Certificates:</td>
			<td><form:textarea path="projects" rows = "5" cols = "100" maxlength="500"/></td>
			<td><form:errors path="projects" cssClass="error"></form:errors></td>
		</tr>

     <script language="javascript"> 
         function mesaj(){ 
            <% String ileti="Please fill all the areas"; %>
          var sonuc="<%=ileti%>"; 
         alert(sonuc); 
         } 
      </script> 


		<tr>
				<td colspan=3>
					<input type=submit value="Send">
				</td>
		</tr>
		
		<form:hidden path="applicant.id" value="${applicant.id}"/>
	</table>
</form:form>

<body onload="mesaj()">
</html>