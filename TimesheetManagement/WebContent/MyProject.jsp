<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set name="theme" value="'simple'" scope="page" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="mystyle.css">
<title>My Projects</title>
</head>
<body style="height: auto; border: 1px groove black;" marginheight="5px">
<img src="<s:url value="/images/timesheet.png"/>" />
	<div id="myproj2" style="margin-bottom:30px;">
		<s:iterator value="projectlist">
		
		<div id="myproj" style="margin-left:40px;margin-right:40px;">
			<s:label>Project Number : </s:label>
			<s:property value="project_num" />
			
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
			<s:label>Project Name   : </s:label>
			<s:property value="project_name" />
			<br><br/>
			<s:label>Start Date     : </s:label>
			<s:property value="startdate" />
			
			
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
			<s:label>End Date       : </s:label>
			<s:property value="enddate" />
			</div>
			<br><br/>	
			<s:label>Team Members  : </s:label>
			<br>
			<div align="center">
			<table class="hovertable">
				<tr>
					<th>Employee ID</th>
					<th>Employee Name</th>
				</tr>

			
				<s:iterator value="otheremp">
					<tr>
						<td><s:property value="emp_id" /></td>
						<td><s:property value="emp_name" /></td>
					</tr>
				</s:iterator>
				
			</table></div>
			<br>
		</s:iterator>
	</div>
</body>
</html>