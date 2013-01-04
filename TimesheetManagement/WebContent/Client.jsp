<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client</title>
</head>
<body>
Client Page
<s:form>

<s:select label="Select a Project" 
		headerKey="-1" headerValue="Select Project"
		list="#{'1':'Proj1', '2':'Proj2', '3':'Proj3', '4':'Proj4'}" 
		name="proj" 
		value="-1" />


<s:submit name="ViewReport" value="View Report" id="ViewReport"></s:submit>
</s:form>

</body>
</html>