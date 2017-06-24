<%@page import="com.slokam.stumgt.pojo.StudentPojo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>${nameAttr }</h2>
<% List<StudentPojo> students= (List<StudentPojo>) request.getAttribute("students"); %>

<table style='background-color: cyan'>
<tr>
<th> ID</th>
<th> NAME</th>

<th> AGE</th>
<th> NUMBER</th>
<th> QUALIFICATION</th></tr>

<% for(StudentPojo student:students) {  %>

<tr>
<td> <%=student.getId() %> </td>
<td><a href="getstudent?id=<%=student.getId() %>"><%=student.getName() %></a></td>
<td> <%=student.getAge() %> </td>
<td><%=student.getPhone() %></td>
<td> <%=student.getQual() %> </td>
</tr>
<%} %>

</table>

</body>
</html>