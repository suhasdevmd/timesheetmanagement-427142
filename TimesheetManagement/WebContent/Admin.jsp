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
<body style="height: auto; border: 1px groove black;" marginheight="5px">
	<div>
		<img src="<s:url value="/images/timesheet.png"/>" />

		<s:form action="admin.action" method="POST">

			<table class="hovertable"
				style="margin-left: 30px; margin-right: 20px;">
				<tr>
					<td style="background-color: white">
						<p></p> <input type="submit" name="CommandButton"
						value="Add Employee" id="mysubmit" class="button_example" /></td>
					<td style="background-color: white"></td>
					<td style="background-color: white"></td>
					<td style="background-color: white"></td>
					<td style="background-color: white"></td>
					<td style="background-color: white"></td>
					<td style="background-color: white"></td>
				</tr>
				<tr>
					<th colspan="8" style="font-size: 20px">Employee Details</th>
				</tr>
				<tr>
					<th style="border-top-left-radius: 0px;"><h3>First Name</h3>
					</th>
					<th><h3>Last Name</h3>
					</th>
					<th><h3>Email Address</h3>
					</th>
					<th><h3>Phone Number</h3>
					</th>
					<th><h3>Joining Date</h3>
					</th>
					<th><h3>Role Name</h3>
					</th>
					<th style="border-top-right-radius: 0px;"><h3>Update
							Details</h3>
				</tr>
				<s:iterator value="employees">
					<tr>
						<td><h4>
								<s:property value="firstname" />
							</h4>
						</td>
						<td><h4>
								<s:property value="lastname" />
							</h4>
						</td>
						<td><h4>
								<s:property value="email" />
							</h4>
						</td>
						<td><h4>
								<s:property value="phone_num" />
							</h4>
						</td>
						<td width="100px"><h4>
								<s:property value="join_date" />
							</h4>
						</td>
						<td><h4>
								<s:property value="role_name" />
							</h4>
						</td>
						<td><h4>
								<a
									href="get_employee.action?emp_id=<s:property value = "emp_id" />">Update</a>
							</h4></td>
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
</body>
</html>