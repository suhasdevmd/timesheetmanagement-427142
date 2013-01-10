<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sd" uri="/struts-dojo-tags"%>

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="mystyle.css" rel="stylesheet" type="text/css">
<title>Assign Employees to project</title>

</head>

<body style="height: auto;">

	<div id="boundary">
		<br /> <img src="<s:url value="bk_in.jpg"/>" width="930px"
			style="box-shadow: 0px 0px 20px rgba(0, 0, 0, .4);" />


		<div
			style="height: 80px; width: 300px; box-shadow: 0px 0px 20px rgba(0, 0, 0, .4); margin: 30px; padding: 20px; float: left;">
			<s:if test="#session.EmployeeDetails != null">
				<s:iterator value="#session.EmployeeDetails">
					<div align="left">

						<b><s:label name="empName" value="Employee Name : "></s:label>
						</b>
						<s:property value="firstname" />
						&nbsp;
						<s:property value="lastname" />
					</div>
					<br />
					<div align="left">
						<b><s:label name="role" value="Role : "></s:label> </b>
						<s:property value="role_name" />
					</div>
				</s:iterator>
			</s:if>
			<br />
			<s:if test="#session.todayDate != null">
				<div align="left">
					<b><s:label name="date1" value="Login Date : "></s:label> </b>
					<s:property value="#session.todayDate" />
				</div>
			</s:if>
		</div>

		<div align="right"
			style="margin-bottom: 20px; margin-top: 25px; float: left;">


			<s:form action="home" method="POST">
				<div
					style="overflow: hidden; left; position: relative; vertical-align: middle;">
					<s:submit name="home" value=" Home " cssClass="button_example"></s:submit>
				</div>
			</s:form>



			<s:form action="logout.action" method="POST">
				<%-- <div
					style="overflow: hidden; left; position: relative; vertical-align: middle;">
					<s:submit name="home" value=" Home " cssClass="button_example"></s:submit>
				</div> --%>
				<div
					style="overflow: hidden; right; margin-left: 10px; vertical-align: middle;">
					<s:submit name="logout" value="Logout" cssClass="button_example"></s:submit>
				</div>
			</s:form>
		</div>






		<s:if test="#session.login != 'true'">
			<jsp:forward page="Login.jsp" />
		</s:if>

		<%-- 
		<s:form action="logout.action" method="POST">
			<s:submit name="logout" value="Logout"></s:submit>
		</s:form> --%>




		<div
			style="margin: 170px 30px 30px; box-shadow: 0px 0px 20px rgba(0, 0, 0, .4); padding: 20px; min-height: 400px;">

			<s:if test="hasActionErrors()">
				<div class="error" align="center">
					<s:actionerror />
				</div>
			</s:if>

			<s:if test="hasActionMessages()">
				<div class="success" align="center">
					<s:actionmessage />
				</div>
			</s:if>
			<br/>

			<s:form action="AssignEmp" method="POST" theme="simple">
				<!-- drop down menu for project selection 

		<s:select label="Select a Project" headerKey="-1"
			headerValue="Select Project"
			list="#{'1':'Proj1', '2':'Proj2', '3':'Proj3', '4':'Proj4'}"
			name="project" value="-1" />-->



				<div align="left" id="wrapper">
					<s:label name="SelectProj" value="  Select a project :"></s:label>
					<s:select label="  Select a Project" headerKey="-1"
						headerValue="Select Project" list="project" name="project1"
						value="-1" cssClass="select" />
				</div>


				<!-- drop down menu for task name selection 
		<s:select label="Select a Task" headerKey="-1"
			headerValue="Select Task"
			list="#{'1':'Requirement', '2':'Development', '3':'Testing'}"
			name="task" value="-1" />-->

				<br />

				<div align="left" id="wrapper">
					<s:label name="SelectTask" value="  Select a task :"></s:label>
					<s:select label="  Select a Task" headerKey="-1"
						headerValue="Select Task" list="task" name="task1" value="-1"
						cssClass="select" />
				</div>
				<!-- 
		<s:checkboxlist label="Select Employees" labelposition="top"
			list="#{'1':'Suhas', '2':'Dev', '3':'Bond'}" name="employees"
			value="1" />
		 -->


				<div align="left" id="wrapper1"
					style="height: auto; margin-left: 30px;">
					<s:label name="SelectEmp" value="  Select Employees :"></s:label>
					<br />
					<hr>

					<s:checkboxlist label="  Select Employees" labelposition="top"
						list="emp" name="employees" value="1" theme="vertical-checkbox" />
				</div>
				<br />
				<div align="left" id="wrapper2">
					&nbsp; &nbsp; &nbsp;
					<s:submit name="Assign Employees" value="Assign Employees"
						cssClass="button_example"></s:submit>
				</div>
			</s:form>

		</div>
	</div>

	<center><h4 align="center">Copyright © 2013 TMS@IIITB. All rights
		reserved.</h4></center>
</body>
</html>