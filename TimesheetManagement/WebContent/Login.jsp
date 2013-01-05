<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>TIMESHEET</title>
<link rel="stylesheet" href="mystyle.css">
<style type="text/css">
#mysubmit1 {
	-moz-box-shadow: inset 0px 1px 0px 0px #0f0e0f;
	-webkit-box-shadow: inset 0px 1px 0px 0px #0f0e0f;
	box-shadow: inset 0px 1px 0px 0px #0f0e0f;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #0f010f
		), color-stop(1, #120112) );
	background: -moz-linear-gradient(center top, #0f010f 5%, #120112 100%);
	filter: progid : DXImageTransform.Microsoft.gradient ( startColorstr =
		'#0f010f', endColorstr = '#120112' );
	background-color: #0f010f;
	-moz-border-radius: 6px;
	-webkit-border-radius: 6px;
	display: inline-block;
	color: #ebddeb;
	font-family: arial;
	font-size: 15px;
	font-weight: bold;
	text-decoration: none;
	text-shadow: 1px 1px 0px #080108;
}

.classname:hover {
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #120112
		), color-stop(1, #0f010f) );
	background: -moz-linear-gradient(center top, #120112 5%, #0f010f 100%);
	filter: progid : DXImageTransform.Microsoft.gradient ( startColorstr =
		'#120112', endColorstr = '#0f010f' );
	background-color: #120112;
}

.classname:active {
	position: relative;
	top: 1px;
}

fieldset {
  padding: 1em;
  font:100%/1 sans-serif;
  width:50%;
  margin-right:30px;
  }
legend1 {
  text-color:blue;
  width:50%;
  border:1px solid green;
  margin-right:0.5em;
  padding-top:0.2em;
  text-align:left;
  font-weight:bold;
  }
</style>
</head>
<body style="height: auto; border: 1px groove black;" marginheight="5px">
	
	<img alt="Timesheet" src="<s:url value="/images/timesheet.png"/>">
	<br/><br/>
	<s:if test="hasActionErrors()">
		<div class="error">
			<s:actionerror />
		</div>
	</s:if>

	<br/><br/><br/>

	<div align="right">
    <fieldset>
	<legend>TimeSheet Login</legend>
	<s:form action="login.action" method="post">
		
			<s:textfield name="username" label="UserName" id="myinput" size="20" />
			<s:password name="password" label="Password" id="myinput" size="20" />
			<s:submit name="commandButton" id="mysubmit" value="  Login  "
				align="center" cssClass="button_example"/>
		
	</s:form>
	</fieldset>
	</div>
</body>
</html>
