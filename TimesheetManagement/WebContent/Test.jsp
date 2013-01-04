<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sd" uri="/struts-dojo-tags"%>
<html>
<head>
<sd:head />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Report</title>
</head>
<body>
	Test Page !!!

	<sd:tabbedpanel id="tabContainer">
		<sd:div label="Project">
			<s:form>
				<s:textfield name="ProjectNumber" label="Project Number"
					id="ProjectNumber">
				</s:textfield>
				<s:textfield name="ProjectName" label="Project Name"
					id="ProjectName">
				</s:textfield>
				<s:textfield name="ProjectDesc" label="Project Description"
					id="ProjectDesc">
				</s:textfield>

				<sd:datetimepicker name="startDate" label="Start Date"
					displayFormat="dd-MM-yyyy" value="%{'today'}" />

				<sd:datetimepicker name="EndDate" label="End Date"
					displayFormat="dd-MM-yyyy" value="%{'today'}" />

				
				<s:textfield name="Cost" label="Cost Per Hour" id="Cost">
				</s:textfield>
				<s:submit name="CreateProj" id="CreateProj" value="Create Project">
				</s:submit>
			</s:form>
		</sd:div>
		<sd:div label="Task">
			<s:form>
				<!-- drop down menu for project selection -->
				<s:select label="Select a Project" headerKey="-1"
					headerValue="Select Project"
					list="#{'1':'Proj1', '2':'Proj2', '3':'Proj3', '4':'Proj4'}"
					name="proj" value="-1" />
				<!-- drop down menu for task name selection -->
				<s:select label="Select a Task" headerKey="-1"
					headerValue="Select Task"
					list="#{'1':'Requirement', '2':'Development', '3':'Testing'}"
					name="task" value="-1" />


				<sd:datetimepicker name="startDate" label="Start Date"
					displayFormat="dd-MM-yyyy" value="%{'today'}" />

				<sd:datetimepicker name="EndDate" label="End Date"
					displayFormat="dd-MM-yyyy" value="%{'today'}" />

				<!--<sd:datetimepicker name="date1" 
displayFormat="yyyy-MM-dd"
value="today"
label="Select Date(yyyy-mm-dd):"/>
-->


				<s:submit name="CreateTask" id="CreateTask" value="Create Task"></s:submit>
			</s:form>
		</sd:div>
		<sd:div label="Timesheet">
       Timesheet
   </sd:div>
		<sd:div label="Report">
       Report
   </sd:div>
	</sd:tabbedpanel>



</body>
</html>