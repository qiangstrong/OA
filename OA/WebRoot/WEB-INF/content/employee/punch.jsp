<%@ page contentType="text/html; charset=gb2312" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" /> 
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>电子打卡</title>
</head>
<body>
	<%@include file="../header.jsp"%>
	<%@include file="empheader.jsp"%>
	<table width="200" align="center">
		<tr>
			<td colspan="3">
				<br /><br /><h4>电子打卡系统</h4>
			</td>
		</tr>
		<tr>
			<td colspan="3"><br /><br /><br />
			 <s:if test="punchIsValid==1">
					<s:form action="employeeCome" theme="simple">
						<s:submit type="image" src="image/up_punch.gif"/>
					</s:form>
			 </s:if>
			 <s:if test="punchIsValid==2">
					<s:form action="employeeLeave" theme="simple">
						<s:submit type="image" src="image/down_punch.gif"/>
					</s:form>
			</s:if> <br />
			</td>
		</tr>
	</table>
	<%@include file="../footer.jsp"%>
</body>
</html>
