<%@ page contentType="text/html; charset=gb2312" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" /> 
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<link href="css/button.css" rel="stylesheet" />
	<title>����춯����</title>
</head>
<body>
	<%@include file="../header.jsp"%>
	<%@include file="empheader.jsp"%>
	<table width="300" align="center">
		<tr>
			<td>
				<center>
					<h4>��ǰ�û���<s:property value="#session.user" /></h4>
					����д�춯����<br/><br/>
				</center>
				<s:fielderror/>
				<s:form action="processApp" namespace="/" theme="simple">			
					<input type="hidden" name="attId" value="${param.attid}" />
					�������&nbsp;&nbsp;<s:select name="typeId" list="types" listKey="id" listValue="name" />
					<br/><br/>
					��������<br/><s:textarea name="reason" rows="12" cols="50"/>
					<tr>
						<td colspan="2">
							<s:submit value="�ύ����" theme="simple" cssClass="button"/> 
							<s:reset  value="������д" theme="simple" cssClass="button"/>
						</td>
					</tr>
				</s:form>
			</td>
		</tr>
	</table>
	<%@include file="../footer.jsp"%>
</body>
</html>