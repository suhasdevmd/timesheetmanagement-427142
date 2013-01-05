<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sd" uri="/struts-dojo-tags"%>
<!--<jsp:include page="Header.jsp" />-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="mystyle.css">
<title>Manager</title>
</head>
<body style="height: auto; border: 1px groove black;"
	marginheight="5px">
	<img src="<s:url value="/images/timesheet.png"/>" />
	<div id="wrappermenu">
		<s:label value="Timesheet"></s:label>
	</div>
	<s:div cssClass="divalign">
		<img src="<s:url value="/images/arrow.png"/>" />
		<s:url var="SubmitTimesheet" action="Manager">
			<s:param name="function" value="'SubmitTimesheet'"></s:param>
		</s:url>
		<s:a href="%{#SubmitTimesheet}">Submit Timesheet</s:a>
	</s:div>

	<s:div cssClass="divalign">
		<img src="<s:url value="/images/arrow.png"/>" />
		<s:url var="ApproveTimesheet" action="Manager">
			<s:param name="function" value="'ApproveTimesheet'"></s:param>
		</s:url>
		<s:a href="%{#ApproveTimesheet}">Approve Timesheet</s:a>
	</s:div>

	<div id="wrappermenu">
		<s:label value="Project"></s:label>
	</div>
	<s:div cssClass="divalign">
		<img src="<s:url value="/images/arrow.png"/>" />
		<s:url var="CreateProject" action="Manager">
			<s:param name="function" value="'CreateProject'"></s:param>
		</s:url>
		<s:a href="%{#CreateProject}">Create Project</s:a>
	</s:div>

	<s:div cssClass="divalign">
		<img src="<s:url value="/images/arrow.png"/>" />
		<s:url var="AssignEmp" action="Manager">
			<s:param name="function" value="'AssignEmp'"></s:param>
		</s:url>
		<s:a href="%{#AssignEmp}">Assign Employees</s:a>
	</s:div>

	<s:div cssClass="divalign">
		<img src="<s:url value="/images/arrow.png"/>" />
		<s:url var="AddClient" action="Manager">
			<s:param name="function" value="'AddClient'"></s:param>
		</s:url>
		<s:a href="%{#AddClient}">Add Client</s:a>
	</s:div>


	<div id="wrappermenu">
		<s:label value="Report"></s:label>
	</div>
	<s:div cssClass="divalign">
		<img src="<s:url value="/images/arrow.png"/>" />
		<s:url var="ViewReport" action="Manager">
			<s:param name="function" value="'ViewReport'"></s:param>
		</s:url>
		<s:a href="%{#ViewReport}">View Report</s:a>
	</s:div>










</body>
</html>