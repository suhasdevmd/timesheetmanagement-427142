<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Password Management</title>
</head>
<body>
	<s:form action="checkpass.action" method="post">
		<center>
			<s:password name="oldpass" key="label.oldpass" size="32" />
			<br>
			<s:password name="newpass" key="label.newpass" size="32" />
			<br>
			<s:password name="newpassre" key="label.newpassre" size="32" />
			<br>
		</center>
		<s:submit method="execute" key="label.submit" align="center" />
	</s:form>
	<s:actionerror name="password"/>
</body>
</html>