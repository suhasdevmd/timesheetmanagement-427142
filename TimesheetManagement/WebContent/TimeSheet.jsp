<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sd" uri="/struts-dojo-tags"%>
<s:set name="theme" value="'simple'" scope="page" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>Time Sheet</title>
<sd:head />
<%-- <style type="text/css">
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
 --%>
 <link href="mystyle.css" rel="stylesheet" type="text/css">
 </link>
 </head>

<body style="height: auto; border: 1px groove black;" marginheight="5px">
<img src="<s:url value="/images/timesheet.png"/>" />

	<s:form action="timesheet.action" method="post" style="margin-left:40px;margin-right:40px">
		<center>
			<table class="hovertable">
				<tr align="center">
					<th scope="col">Project Number</th>
					<th scope="col">Project Name</th>
					<th scope="col">Task Name</th>
					<th scope="col" width="100px">Date</th>
					<th scope="col">No. Of Hours</th>
					<th scope="col">Timesheet Status</th>
				</tr>

				<tr>
					<td align="center"><s:textfield size="10" name="won" id="won" value=" "/>
					</td>
					<td align="center"><%-- <s:textfield disabled="true" size="20"
							id="projectname" name="projectname" /> --%><s:property default="Project Name" value="projectname"/>
					</td>
					<td align="center"><%-- <s:textfield size="10" name="taskname"
							id="taskname" disabled="true" /> --%><s:property default="Task Name" value="taskname"/>
					</td>
					<td align="center"><sd:datetimepicker id="date" name="date"
							displayFormat="dd-MM-yyyy" value="today" />
					</td>
					<td align="center"><s:textfield size="10" name="hrs" id="hrs" />
					</td>
					<td align="center"><%-- <s:textfield size="15" name="status"
							id="status" disabled="true" /> --%><s:property default="Pending..." value="status"/>
					</td>
				</tr>

			</table>

		</center>

		<s:submit name="commandButton" id="refresh" value="Refresh" cssClass="button_example"/>
		<s:submit name="commandButton" id="submit" value="Submit" cssClass="button_example"/>

		<br />
		<br />
		<br />
		<br />
		<br />
		<table class="hovertable" style="margin-left:50px;">
			<tr align="center">
				<th scope="col">Project Number</th>
				<th scope="col">Project Name</th>
				<th scope="col">Task Name</th>
				<th scope="col">Date</th>
				<th scope="col">No. Of Hours</th>
				<th scope="col">Status</th>
			</tr>

			<s:iterator value="viewtimesheet">
				<tr>
					<td width="100px"><s:property value="project_num" /></td>
					<td width="100px"><s:property value="project_name" /></td>
					<td width="100px"><s:property value="task_name" /></td>
					<td width="100px"><s:property value="work_date" /></td>
					<td width="100px"><s:property value="no_of_hours" /></td>
					<td width="100px"><s:property value="status" /></td>
				</tr>
			</s:iterator>
		</table>

	</s:form>
</body>
</html>
