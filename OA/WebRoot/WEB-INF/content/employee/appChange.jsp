<%@ page contentType="text/html; charset=gb2312" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" /> 
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<link href="css/button.css" rel="stylesheet" />
	<title>提出异动申请</title>
</head>
<body>
	<%@include file="../header.jsp"%>
	<%@include file="empheader.jsp"%>
	<table width="300" align="center">
		<tr>
			<td>
				<center>
					<h4>当前用户：<s:property value="#session.user" /></h4>
					请填写异动申请<br/><br/>
				</center>
				<s:fielderror/>
				<s:form action="processApp" namespace="/" theme="simple">			
					<input type="hidden" name="attId" value="${param.attid}" />
					申请类别&nbsp;&nbsp;<s:select name="typeId" list="types" listKey="id" listValue="name" />
					<br/><br/>
					申请理由<br/><s:textarea name="reason" rows="12" cols="50"/>
					<tr>
						<td colspan="2">
							<s:submit value="提交申请" theme="simple" cssClass="button"/> 
							<s:reset  value="重新填写" theme="simple" cssClass="button"/>
						</td>
					</tr>
				</s:form>
			</td>
		</tr>
	</table>
	<%@include file="../footer.jsp"%>
</body>
</html>