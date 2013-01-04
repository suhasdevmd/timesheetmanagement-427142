<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sd" uri="/struts-dojo-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Link</title>
</head>
<body>

<s:label value="Timesheet"></s:label>
<s:div>
<s:url var="SubmitTimesheet" action="admin_home">
    <s:param name="function" value="'SubmitTimesheet'"></s:param>
</s:url>
<s:a href="%{#SubmitTimesheet}">Submit Timesheet</s:a>
</s:div>

<s:label value="Administrator"></s:label>
<s:div>
<s:url var="AddUpdateEmployee" action="admin_home">
    <s:param name="function" value="'AddUpdateEmployee'"></s:param>
</s:url>
<s:a href="%{#AddUpdateEmployee}">Add/Update Employee</s:a>
</s:div>

</body>
</html>