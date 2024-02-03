<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>View Student</h2>
	
	<a href="/">Add new Student</a>

	<table border="1">
		<thead>
		<tr>
			<th>S.NO</th>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>GENDER</th>
			<th>COURSE</th>
			<th>TIMING</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${students}" var="student" varStatus="index">
		<tr>
		
		<td>${index.count}</td>
		<td>${student.name}</td>
		<td>${student.email}</td>
		<td>${student.gender}</td>
		<td>${student.course}</td>
		<td>${student.timings}</td>
		</tr>
		
		</c:forEach>

		</tbody>

	</table>

</body>
</html>