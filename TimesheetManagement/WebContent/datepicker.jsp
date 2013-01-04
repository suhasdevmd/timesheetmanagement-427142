<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sd" uri="/struts-dojo-tags" %>
<html>
<head>
<sd:head/>
<title>Struts2.2.1 Date Picker Example</title>
</head>
<body>

<h4>Example of Struts date picker in struts2.2.1</h4>

<s:form action="resultAction.action" method="post">
<sd:datetimepicker name="date1" 
displayFormat="yyyy-MM-dd"
value="today"
label="Select Date(yyyy-mm-dd):"/>
<s:submit></s:submit>
</s:form>
</body>
</html>