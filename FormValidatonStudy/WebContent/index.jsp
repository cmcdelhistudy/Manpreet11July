<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Form Validation Study</h1>
		<form action="FormValidationServlet">
			Enter User Name <input type="text" name="username"><br>
			Enter User Age <input type="text" name="userage"><br> <input
				type="submit">
		</form>
		<br>
		<font color="red">
		<%
			ArrayList<String> obtainedErrors = (ArrayList<String>) request
					.getAttribute("ERROR_LIST");

			if (obtainedErrors != null) {
				for (String er : obtainedErrors) {
					out.println("<br>" + er);
				}
			}
		%>
	</font>

	</center>
</body>
</html>