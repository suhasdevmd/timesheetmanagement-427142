<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrator</title>
<link rel="stylesheet" href="mystyle.css">
</head>
<body bgcolor="#4C4C4C">
<h1 align="center">Administrator</h1> 
<s:form action="admin.action" method="post">

<table>
<tr><td>
<p></p>
<input type="submit" name = "CommandButton" value="Add Employee" id="mysubmit" />
</td>
<td></td><td></td><td></td><td></td><td></td><td></td>
</tr>
<tr> 
    <th><h2>First Name</h2></th>
    <th><h2>Last Name</h2></th>
    <th><h2>Email Address</h2></th>
    <th><h2>Phone Number</h2></th>
    <th><h2>Joining Date</h2></th>
    <th><h2>Role Name</h2></th>
</tr>
<s:iterator value="employees">
  <tr>
    <td><h3> <s:property value = "firstname" /> </h3></td>
    <td><h3> <s:property value = "lastname" /> </h3></td>
    <td><h3> <s:property value = "email" /> </h3></td>
    <td><h3> <s:property value = "phone_num" /> </h3></td>
    <td><h3> <s:property value = "join_date" /> </h3></td>
    <td><h3> <s:property value = "role_name" /> </h3></td>
    <td><h3> <a href="get_employee.action?emp_id=<s:property value = "emp_id" />" >Update</a></h3> </td>
  </tr>
</s:iterator>
</table>
</s:form>
</body>
</html>