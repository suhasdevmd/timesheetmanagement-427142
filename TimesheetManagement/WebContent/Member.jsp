<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sd" uri="/struts-dojo-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="mystyle.css">
<title>Manager</title>
</head>
<body style="height: auto;" marginheight="0px">
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
					<b><s:label name="date" value="Login Date : "></s:label> </b>
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

		<%-- <div align="right" style="margin-right: 100px;">
			<s:form action="logout.action" method="POST">
				<s:submit name="logout" value="Logout" cssClass="button_example"
					align="right"></s:submit>
			</s:form>
		</div> --%>

		<s:if test="hasActionErrors()">
			<div class="error">
				<s:actionerror />
			</div>
		</s:if>



		<div
			style="margin: 170px 30px 30px; box-shadow: 0px 0px 20px rgba(0, 0, 0, .4); padding: 20px; min-height: 400px;">

			<div id="wrappermenu">
				<s:label value="Timesheet"></s:label>
			</div>
			<br />
			<s:div cssClass="divalign">
				<img src="<s:url value="/images/arrow.png"/>" />
				<s:url var="SubmitTimesheet" action="member">
					<s:param name="function" value="'SubmitTimsheet'"></s:param>
				</s:url>
				<s:a href="%{#SubmitTimesheet}">Submit Timesheet</s:a>
			</s:div>


			<br />

			<div id="wrappermenu">
				<s:label value="Project"></s:label>
			</div>
			<br />
			<s:div cssClass="divalign">
				<img src="<s:url value="/images/arrow.png"/>" />
				<s:url var="MyProject" action="member">
					<s:param name="function" value="'MyProject'"></s:param>
				</s:url>
				<s:a href="%{#MyProject}">My Project</s:a>
			</s:div>

			<br />


			<div id="wrappermenu">
				<s:label value="MyAccount"></s:label>
			</div>
			<br />
			<s:div cssClass="divalign">
				<img src="<s:url value="/images/arrow.png"/>" />
				<s:url var="PasswordManagement" action="member">
					<s:param name="function" value="'PasswordManagement'"></s:param>
				</s:url>
				<s:a href="%{#PasswordManagement}">Password Management</s:a>
			</s:div>

		</div>


		<br /> <br /> <br /> <br />

	</div>
	<h4 align="center">Copyright � 2013 TMS@IIITB. All rights
		reserved.</h4>
</body>
</html>