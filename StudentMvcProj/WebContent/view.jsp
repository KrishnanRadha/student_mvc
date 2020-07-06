<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student view</title>
</head>
<body>
   <table border="2px">
   	<tr>
   		<th><h2>RollNo</h2></th>
   		<th><h2>Name</h2></th>
   		<th><h2>Percentage</h2></th>
   	</tr>
	<c:forEach var="stu" items="${lst}">
		
		<tr>
	   		<td><h3><c:out value="${stu.getRollNo()}"></c:out></h3></td>
	   		<td><h3><c:out value="${stu.getName()}"></c:out></h3></td>
	   		<td><h3><c:out value="${stu.getPerc()}"></c:out></h3></td>
   		</tr>	
	</c:forEach>
	</table>
</body>
</html>