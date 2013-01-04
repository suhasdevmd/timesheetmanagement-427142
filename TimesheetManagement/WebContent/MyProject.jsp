<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set name="theme" value="'simple'" scope="page"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Projects</title>
</head>
<body>
	<center>
		<s:iterator value="projectlist">
			<s:label>Project Number : </s:label>
			<s:property value="projectnumber" />
			<br>
			<s:label>Project Name   : </s:label>
			<s:property value="projectname" />
			<br>
			<s:label>Start Date     : </s:label>
			<s:property value="startdate" />
			<br>
			<s:label>End Date       : </s:label>
			<s:property value="enddate" />
			<br>
			<s:label>Other Members  : </s:label><br> 
			<table>
				<tr>
					<th>Employee ID</th>
					<th>Employee Name</th>
				</tr>
				
				<s:iterator value="otheremp">
					<tr>
						<td> <s:property value="emp_id"/> </td>
						<td> <s:property value="emp_name"/> </td>
					</tr>
				</s:iterator>
			</table>
			<br>
		</s:iterator>
	</center>
</body>
</html>