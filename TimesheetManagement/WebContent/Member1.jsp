<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sd" uri="/struts-dojo-tags"%>
<html>
<head>
<style>
ul
{
list-style-type:none;
margin:0;
padding:0;
}
li
{
display:inline;
text-decoration:none; 
background-color:#99CCFF;
}
a:link {
color: #CC0000;
font-weight: normal;
text-decoration: none;
}
a:link:hover {
color: #400000;
font-weight: bold;
text-decoration: none;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="mystyle.css">
<title>Manager</title>
</head>
<body style="height: auto;" marginheight="0px">
	<div id="boundary">


		<img src="<s:url value="bkg.png"/>" />

		<div>
			<s:label name="empName" value="Employee Name : "></s:label>
			<s:label name="role" value="Role : "></s:label>
			<s:label name="date" value="Login Date"></s:label>
		</div>




		<s:if test="#session.login != 'true'">
			<jsp:forward page="Login.jsp" />
		</s:if>

		<div align="right" style="margin-right:100px;">
			<s:form action="logout.action" method="POST">
				<s:submit name="logout" value="Logout" cssClass="button_example"
					align="right"></s:submit>
			</s:form>
		</div>

		
		<ul>
		<li>
			<s:url var="SubmitTimesheet" action="member">
				<s:param name="function" value="'SubmitTimsheet'"></s:param>
			</s:url>
			<s:a href="%{#SubmitTimesheet}">Submit Timesheet</s:a>
		</li>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<li>
			<s:url var="MyProject" action="member">
				<s:param name="function" value="'MyProject'"></s:param>
			</s:url>
			<s:a href="%{#MyProject}">My Project</s:a>
		</li>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<li>

		
			<s:url var="PasswordManagement" action="member">
				<s:param name="function" value="'PasswordManagement'"></s:param>
			</s:url>
			<s:a href="%{#PasswordManagement}">Password Management</s:a>
		</li>
		</ul>
		<br /> <br />
		<br />
		<br />

	</div>
</body>
</html>