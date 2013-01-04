<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sd" uri="/struts-dojo-tags" %>
<html>
<head>
<sd:head/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Report</title>
</head>
<body>

<s:label value="Reports"></s:label>
<s:div>
<s:url var="Timesheet" action="Report">
    <s:param name="reportname" value="'Timesheet'"></s:param>
</s:url>
<s:a href="%{#Timesheet}">Timesheet Report</s:a>
</s:div>

<s:div>
<s:url var="Employee" action="Report">
    <s:param name="reportname" value="'Employee'"></s:param>
</s:url>
<s:a href="%{#Employee}">Employee Report</s:a>
</s:div>

<s:div>
<s:url var="Project" action="Report">
    <s:param name="reportname" value="'Project'"></s:param>
</s:url>
<s:a href="%{#Project}">Project Report</s:a>
</s:div>



</body>
</html>