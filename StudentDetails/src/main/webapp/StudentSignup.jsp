<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="javax.swing.text.StyledEditorKit.ForegroundAction"%>
<%@page import="com.slokam.stumgt.pojo.StudentPojo"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">

function saveorupdate()
{
	document.forms[0].action="signup";
	document.forms[0].submit();

}

function deleteStu()
{
	document.forms[0].action="Delete";
	document.forms[0].submit();

}

function getAll()
{
	document.forms[0].action="GetAll";
	document.forms[0].submit();

}


</script>
</head>
<body>
<h2>${nameAttr }</h2> <center><a href="logout">Logout</a></center>
count:: ${count }
${message}

<form >
<fieldset>
<legend><b>Registration</b></legend>
<table>
<tr>
<td>ID: </td><td><input type="text" name="Id" value="${StudentAtt.id }"> </td></tr>
<tr><td>Name:</td> <td><input type="text" name="Name" value="${StudentAtt.name }"></td></tr>
<tr><td>Qualification:</td><td> <input type="text" name="Qualification" value="${StudentAtt.qual }"></td></tr>
<tr><td>Age:</td> <td><input type="text" name="Age" value="${StudentAtt.age }"></td></tr>
<tr><td>Phone Number: </td><td><input type="text" name="Phonenumber" value="${StudentAtt.phone }"> </td></tr>
<tr><td><input type="button" value="Register" onclick="saveorupdate()"></td>
<td><input type="button" value="Delete" onclick="deleteStu()"></td>
<td><input type="button" value="GetAll" onclick="getAll()"></td>
</tr>
</table>
</fieldset>
</form>

<ol>
	<% List<String> list=(List<String>)application.getAttribute("userList"); 
	
		for(String name:list) { 
	%>
	<li><%=name %></li>
	<%} %>
</ol>

</body>
</html>