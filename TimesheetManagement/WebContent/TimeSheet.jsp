<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sd" uri="/struts-dojo-tags" %>
<s:set name="theme" value="'simple'" scope="page"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>Time Sheet</title>
<sd:head/>
<style type="text/css">
<!--
.timesheetheader {
	font-family: "Palatino Linotype", "Book Antiqua", Palatino, serif;
	font-size: 16px;
	font-style: italic;
	line-height: normal;
	font-weight: bold;
	font-variant: small-caps;
	text-transform: capitalize;
	background-color: #DDD;
	text-align: left;
	white-space: normal;
	display: table;
}
-->
</style>
</head>
	
<body>
<s:form action="timesheet.action" method="post">
<center>
<table width="100%" border="5" align="center" cellpadding="10" cellspacing="5" class="timesheetheader">
  <tr align="center">
    <th width="51" scope="col">Project Number</th>
    <th width="170" scope="col">Project Name</th>
    <th width="188" scope="col">Task Name</th>
    <th width="200" scope="col"> Date </th>
    <th width="188" scope="col">No. Of Hours</th>
    <th width="113" scope="col">Timesheet Status</th>
  </tr>
  
  <tr>
    <td align="center"> <s:textfield size="10" name="won" id="won"/> </td>
    <td align="center"> <s:textfield disabled="true" size="20" id="projectname" name="projectname"/> </td>
    <td align="center"> <s:textfield size="10" name="taskname" id="taskname" disabled="true"/> </td>
    <td align="center"> <sd:datetimepicker id="date" name="date" displayFormat="dd-MM-yyyy" value="today"/> </td>
    <td align="center"> <s:textfield size="10" name="hrs" id="hrs"/> </td>
    <td align="center"> <s:textfield size="15" name="status" id="status" disabled="true"/> </td>
  </tr>
  
</table>
</center>
<s:submit name="CommandButton" id="refresh" value="Refresh" />
<s:submit name="CommandButton" id="submit" value="Submit" />
</s:form>
</body>
</html>
