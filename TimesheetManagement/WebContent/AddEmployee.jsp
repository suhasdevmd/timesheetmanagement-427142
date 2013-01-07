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
<title>ADD EMPLOYEE</title>
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
<body style="height: 550px; border: 1px groove black;"
	marginheight="5px">
	<div>
		<img src="<s:url value="/images/timesheet.png"/>" />
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
						<td><s:label name="firstname" value="First Name"></s:label></td>
						<td><s:textfield name="firstname" label="FIRST NAME"
								id="myinput" required="true" />
						</td>
					</tr>
					<tr>
						<td><s:label name="lastname" value="Last Name"></s:label></td>
						<td><s:textfield name="lastname" label="LAST NAME"
								id="myinput" required="true" />
						</td>
					</tr>
					<tr>
						<td><s:label name="email" value="Email Address"></s:label></td>
						<td><s:textfield name="email" label="EMAIL ADDRESS"
								id="myinput" required="true" />
						</td>
					</tr>
					<tr>
						<td><s:label name="phone" value="Phone Number"></s:label></td>
						<td><s:textfield name="phone_num" label="PHONE NUMBER"
								id="myinput" required="true" />
						</td>
					</tr>
					<tr>
						<td><s:label name="joiningdate" value="Joining Date"></s:label>
						</td>
						<td><sd:datetimepicker name="join_date"
								displayFormat="dd-MM-yyyy" value="today" />
						</td>
					</tr>
					<tr>
						<td><s:label name="role" value="Role"></s:label></td>
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
</body>
</html>