<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrator</title>
<link rel="stylesheet" href="mystyle.css">
</head>
<body style="height: auto;">

	<div id="boundary">
		<br /> <img src="<s:url value="bk_in.jpg"/>" width="930px"
			style="box-shadow: 0px 0px 20px rgba(0, 0, 0, .4);" />

		<s:if test="#session.login != 'true'">
			<jsp:forward page="Login.jsp" />
		</s:if>



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


		<%-- 
		<s:form action="logout.action" method="POST">
			<s:submit name="logout" value="Logout"></s:submit>
		</s:form> --%>



		<div
			style="margin: 170px 30px 30px; box-shadow: 0px 0px 20px rgba(0, 0, 0, .4); padding: 20px; min-height: 400px;">


			<s:form action="admin.action" method="POST">


				<input type="submit" name="CommandButton" value="Add Employee"
					id="mysubmit" class="button_example" />

				<br />
				<br />

				<table class="hovertable"
					style="margin-left: 30px; margin-right: 20px;">
					<!-- <tr>
					<td>
						<p></p> <input type="submit" name="CommandButton"
						value="Add Employee" id="mysubmit" class="button_example" /></td>
					<td style="background-color: white"></td>
					<td style="background-color: white"></td>
					<td style="background-color: white"></td>
					<td style="background-color: white"></td>
					<td style="background-color: white"></td>
					<td style="background-color: white"></td>
				</tr> -->
					<tr>
						<th colspan="8" style="font-size: 20px">Employee Details</th>
					</tr>
					<tr>
						<th style="border-top-left-radius: 0px;"><h3>First Name</h3>
						</th>
						<th><h3>Last Name</h3></th>
						<th><h3>Email Address</h3></th>
						<th><h3>Phone Number</h3></th>
						<th><h3>Joining Date</h3></th>
						<th><h3>Role Name</h3></th>
						<th style="border-top-right-radius: 0px;"><h3>Update
								Details</h3>
					</tr>
					<s:iterator value="employees">
						<tr>
							<td><h4>
									<s:property value="firstname" />
								</h4></td>
							<td><h4>
									<s:property value="lastname" />
								</h4></td>
							<td><h4>
									<s:property value="email" />
								</h4></td>
							<td><h4>
									<s:property value="phone_num" />
								</h4></td>
							<td width="100px"><h4>
									<s:property value="join_date" />
								</h4></td>
							<td><h4>
									<s:property value="role_name" />
								</h4></td>
							<td><h4>
									<a
										href="get_employee.action?emp_id=<s:property value = "emp_id" />">Update</a>
								</h4>
							</td>
							<!-- <td><h4><s:url var="updateEmp" action="get_employee">
    <s:param name="emp_id" value="emp_id"></s:param>
	</s:url>
	<s:a href="%{#updateEmp}">Update</s:a></h4></td>-->
						</tr>
					</s:iterator>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</table>
			</s:form>
		</div>
	</div>

	<h4 align="center">Copyright © 2013 TMS@IIITB. All rights
		reserved.</h4>
</body>
</html>