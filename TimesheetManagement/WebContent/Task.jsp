<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sd" uri="/struts-dojo-tags" %>
<html>
<head>
<sd:head/>
<title>Task</title>
</head>
<body>

<s:form>
<!-- drop down menu for project selection -->
<s:select label="Select a Project" 
		headerKey="-1" headerValue="Select Project"
		list="#{'1':'Proj1', '2':'Proj2', '3':'Proj3', '4':'Proj4'}" 
		name="proj" 
		value="-1" />
<!-- drop down menu for task name selection -->
<s:select label="Select a Task" 
		headerKey="-1" headerValue="Select Task"
		list="#{'1':'Requirement', '2':'Development', '3':'Testing'}" 
		name="task" 
		value="-1" />


<sd:datetimepicker name="startDate" label="Start Date" 
displayFormat="dd-MM-yyyy" value="%{'today'}"/>

<sd:datetimepicker name="EndDate" label="End Date" 
displayFormat="dd-MM-yyyy" value="%{'today'}"/>

<!--<sd:datetimepicker name="date1" 
displayFormat="yyyy-MM-dd"
value="today"
label="Select Date(yyyy-mm-dd):"/>
-->


<s:submit name="CreateTask" id="CreateTask" value="Create Task"></s:submit>
</s:form>




</body>
</html>