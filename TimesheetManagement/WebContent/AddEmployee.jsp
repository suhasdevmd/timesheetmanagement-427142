<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sd" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<sd:head />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="mystyle.css" rel="stylesheet" type="text/css">
<title>Add Employee</title>
<link rel="stylesheet" href="mystyle.css">
<script>
function validateForm()
{
var val=true;
var x=document.forms["myForm"]["email"].value;

var atpos=x.indexOf("@");
var dotpos=x.lastIndexOf(".");
if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length)
  {
  alert("Not a valid e-mail address");
  val=false;
  }
var y=document.forms["myForm"]["phone_num"].value;
if(y.length<10 || y.length>10)
{
	  alert("Not a valid phone number");
	  val=false;
	  }
	  
	  return val;
	  }
</script>

</head>
<body style="height: auto;">





	<%-- <s:form action="logout.action" method="POST">
	<s:submit name="logout" value="Logout"></s:submit>
	</s:form> --%>

	<div id="boundary">
	<br/>

		<img src="<s:url value="bk_in.jpg"/>" width="930px" style=" box-shadow: 0px 0px 20px rgba(0, 0, 0, .4);"/>




		<div
			style="height: 80px; width: 300px; box-shadow: 0px 0px 20px rgba(0, 0, 0, .4); margin: 30px; padding: 20px; float: left;">

			<s:if test="#session.EmployeeDetails != null">
				<s:iterator value="#session.EmployeeDetails">
					<div align="left">

						<b><s:label name="empName" value="Employee Name : "></s:label></b>
						<s:property value="firstname" />
						&nbsp;
						<s:property value="lastname" />
					</div>
					<br />
					<div align="left">
						<b><s:label name="role" value="Role : "></s:label></b>
						<s:property value="role_name" />
					</div>
				</s:iterator>
			</s:if>
			<br />
			<s:if test="#session.todayDate != null">
				<div align="left">
					<b><s:label name="date" value="Login Date : "></s:label></b>
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





		<div
			style="margin: 170px 30px 30px; box-shadow: 0px 0px 20px rgba(0, 0, 0, .4); padding: 20px; min-height: 400px;">



			<s:form name="myForm" action="add_employee.action" method="post"
				onsubmit="return validateForm();" theme="simple">

				<s:if test="hasActionErrors()">
					<div class="error">
						<s:actionerror />
					</div>
				</s:if>

				<br />


				<div id="CrtProj" align="left">
					<table>
						<tr>
							<td><s:label name="firstname" value="First Name"></s:label>
							</td>
							<td><s:textfield name="firstname" label="FIRST NAME"
									id="myinput" required="true" /></td>
						</tr>
						<tr>
							<td><s:label name="lastname" value="Last Name"></s:label>
							</td>
							<td><s:textfield name="lastname" label="LAST NAME"
									id="myinput" required="true" /></td>
						</tr>
						<tr>
							<td><s:label name="email" value="Email Address"></s:label>
							</td>
							<td><s:textfield name="email" label="EMAIL ADDRESS"
									id="myinput" required="true" /></td>
						</tr>
						<tr>
							<td><s:label name="phone" value="Phone Number"></s:label>
							</td>
							<td><s:textfield name="phone_num" label="PHONE NUMBER"
									id="myinput" required="true" /></td>
						</tr>
						<tr>
							<td><s:label name="joiningdate" value="Joining Date"></s:label>
							</td>
							<td><sd:datetimepicker name="join_date"
									displayFormat="dd-MM-yyyy" value="today" /></td>
						</tr>
						<tr>
							<td><s:label name="role" value="Role"></s:label>
							</td>
							<td><s:select label="ROLE NAME" headerKey="Select role"
									headerValue="Select role"
									list="{'admin', 'manager', 'team_member'}" name="role_name" />
							</td>
						</tr>
					</table>
				</div>
				<h2 align="right">
					<s:submit value=" Add Employee " id="mysubmit"
						cssClass="button_example" style="margin-right:40px" />
				</h2>

			</s:form>
		</div>
	</div>
	
	
	<h4 align="center">Copyright © 2013 TMS@IIITB. All rights reserved.</h4>
</body>
</html>