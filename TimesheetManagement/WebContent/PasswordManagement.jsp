<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="mystyle.css">
<title>Password Management</title>
</head>
<body style="height: 100%; border: 1px groove black;" marginheight="20px">
<img src="<s:url value="/images/timesheet.png"/>" />


	<div id="wrapper1" style="margin-left:40px;margin-right:40px">
	
	<s:form action="checkpass.action" method="post">
		<center>
			<s:password name="oldpass" key="label.oldpass" size="32" />
			<br>
			<s:password name="newpass" key="label.newpass" size="32" />
			<br>
			<s:password name="newpassre" key="label.newpassre" size="32" />
			<br>
		</center>
		<s:submit method="execute" key="label.submit" align="center" cssClass="button_example" />
	</s:form>
	</div>
	<s:actionerror name="password"/>
	
	
	<br><br><br><br><br><br><br><br><br>
</body>
</html>