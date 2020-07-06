<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="student.html"><button>Add Student</button></a><br></br>
	<a href="update.jsp"><button>Update Student</button></a><br></br>
	<a href="delete.jsp"><button> Delete Student</button></a><br></br>
	<form action="stu">
	<input type="submit" name="op" value="show_students_details">
	</form><br>
	<jsp:include page="update.jsp"></jsp:include>
	
</body>
</html>