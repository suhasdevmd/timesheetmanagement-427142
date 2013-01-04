<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    <%@ taglib prefix="sd" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><sd:head/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<body>
<s:form name="myForm" action="add_employee.action" method="post" onsubmit="return validateForm();">

<h1 align="center">ADD EMPLOYEE</h1> 
<table>
<tr>
    <td><s:textfield name="firstname" label="FIRST NAME" id="myinput"/> </td>
</tr>
<tr>
    <td><s:textfield name="lastname" label="LAST NAME" id="myinput"/> </td>
</tr>
<tr>
    <td><s:textfield name="email" label="EMAIL ADDRESS" id="myinput"/> </td>
</tr>
<tr>
    <td><s:textfield name="phone_num" label="PHONE NUMBER" id="myinput"/> </td>
</tr>
<tr>
    <td><sd:datetimepicker name="join_date" displayFormat="dd-MM-yyyy" value="today" label="JOINING DATE" /> </td>
</tr>
<tr>
    <td><s:select label="ROLE NAME" headerKey="Select role" headerValue="Select role" list="{'admin', 'manager', 'team_member'}" name="role_name" /> </td>
</tr>
</table>
<h2 align="left"><s:submit value="Add" id="mysubmit" /></h2>
</s:form>

</body>
</html>