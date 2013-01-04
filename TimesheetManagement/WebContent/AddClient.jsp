<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sd" uri="/struts-dojo-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="mystyle.css" rel="stylesheet" type="text/css">
<title>Add Client</title>
</head>
<body>
	<s:form action="addclient" method="POST" theme="simple">
		<div id="wrapper">
			<s:label name="ClientName" value="  Client Name :"></s:label>
			<s:textfield name="ClientName" label="Client Name"
				id="ClientName">
			</s:textfield>
		</div>
		
		<div id="wrapper">
			<s:label name="City" value="  City :"></s:label>
			<s:textfield name="City" label="City"
				id="City">
			</s:textfield>
		</div>

		<div id="wrapper2" align="right">
			<s:submit name="AddClient" id="AddClient" value="Add Client"
				cssClass="button_example">
			</s:submit>
		</div>


	</s:form>
</body>
</html>