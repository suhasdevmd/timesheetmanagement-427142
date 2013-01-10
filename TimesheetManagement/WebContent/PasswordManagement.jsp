<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="mystyle.css">
<title>Password Management</title>
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


		<%-- <s:form action="logout.action" method="POST">
			<s:submit name="logout" value="Logout"></s:submit>
		</s:form> --%>






		<div
			style="margin: 170px 30px 30px; box-shadow: 0px 0px 20px rgba(0, 0, 0, .4); padding: 20px; min-height: 400px;">

			<s:if test="hasActionMessages()">
				<div class="success">
					<s:actionmessage />
				</div>
			</s:if>

			<s:if test="hasActionErrors()">
				<div class="error">
					<s:actionerror name="password" />
				</div>
			</s:if>


			<div id="wrapper1" style="margin-left: 220px; margin-right: 40px">

				<s:form action="checkpass.action" method="post">
					<center>
						<s:password name="oldpass" key="label.oldpass" size="32" />
						<br>
						<s:password name="newpass" key="label.newpass" size="32" />
						<br>
						<s:password name="newpassre" key="label.newpassre" size="32" />
						<br>
					</center>

					<s:submit method="execute" key="label.submit" align="center"
						cssClass="button_example" />
				</s:form>
			</div>

		</div>


		<br> <br>
	</div>

	<h4 align="center">Copyright © 2013 TMS@IIITB. All rights
		reserved.</h4>

</body>
</html>