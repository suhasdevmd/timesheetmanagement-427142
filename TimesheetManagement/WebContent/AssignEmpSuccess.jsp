<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sd" uri="/struts-dojo-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign Employee Success</title>
</head>
<body>


<div style="background: #CCCCCC;font-size:40px;"><s:label name="AssignSuccess" value="Project Assignment Successful"></s:label></div>
<br />
<div style="background: #CCCCCC;font-size:25px;"><s:label name="Details" value="Details :"></s:label>
<br />
<s:label name="ProjectName" value="Project Name : "></s:label>
<s:property value="project"/> 
<br />
<s:label name="TaskName" value="Task Name : "></s:label>
<s:property value="task"/> 
<br />
<s:label name="Emp" value="The following employees are assigned : "></s:label><br />
<s:iterator value="employees">
<s:property /><br />
</s:iterator>
</div>

<s:submit name="Back" value="Back"></s:submit>
</body>
</html>