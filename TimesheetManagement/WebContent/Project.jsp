<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sd" uri="/struts-dojo-tags"%>
<html>
<head>
<sd:head />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="mystyle.css" rel="stylesheet" type="text/css">
<title>Project</title>
</head>
<body style="height: 550px; border: 1px groove blue;">

	<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>

	<s:form action="CreateProject" method="POST" theme="simple">

		<div>
		
			<div id="wrapper">
			<s:label name="ProjectNumber" value="  Project Number :"></s:label>
			<s:textfield name="ProjectNumber" label="Project Number"
				id="ProjectNumber">
			</s:textfield>
			</div>
			
			<div id="wrapper">
			<s:label name="ProjectName" value="  Project Name :"></s:label>
			<s:textfield name="ProjectName" label="Project Name" id="ProjectName">
			</s:textfield>
			</div>
			
			<div id="wrapper">
			<s:label name="ProjectDescription" value="  Project Description :"></s:label>
			<s:textfield name="ProjectDesc" label="Project Description"
				id="ProjectDesc">
			</s:textfield>
			</div>
			
			<div id="wrapper">
			<sd:datetimepicker name="StartDate" label="Start Date"
				displayFormat="dd-MM-yyyy" value="%{'today'}" />
			</div>
			
			<div id="wrapper">
			<sd:datetimepicker name="EndDate" label="End Date"
				displayFormat="dd-MM-yyyy" value="%{'today'}" />
			</div>
			
			<div id="wrapper"> 
			<s:label name="CostPerHour" value="  Cost Per Hour :"></s:label>
			<s:textfield name="Cost" label="Cost Per Hour" id="Cost">
			</s:textfield>
			</div>
			
			
			<div id="wrapper">
			<s:label name="Client" value="  Client :"></s:label>
			<s:select label="Client" headerKey="-1" headerValue="Select Client"
				list="clients" name="client" value="-1" />
			</div>
		</div>
		<div id="wrapper2" align="right">
			<s:submit name="CreateProj" id="CreateProj" value="Create Project"
				cssClass="button_example" >
			</s:submit>
		</div>
	</s:form>
</body>
</html>