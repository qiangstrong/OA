<%@ page contentType="text/html; charset=gb2312" language="java"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" /> 
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>������Ա��</title>
</head>
<body>
	<%@include file="../header.jsp"%>
	<%@include file="mgrheader.jsp"%>
	<table width=300 align="center">
		<tr>
			<td>
				<br/><center><h4>����������Ա�������ϣ�</h4></center><br /> 
				<s:if test="tip!=null">
					<div class="error">
						<s:property value="tip" />
					</div>
				</s:if>
				<div align="center">
					<s:form action="addEmp" namespace="/">
						<s:textfield name="emp.name" label="Ա���û���" />
						<s:textfield name="emp.pass" label="Ա������" />
						<s:textfield name="emp.salary" label="Ա����н" />
						<s:token />
						<tr>
							<td colspan="2">
								<s:submit value="�����Ա��" theme="simple" />
							 	<s:reset theme="simple" value="��������" />
							 </td>
						</tr>
					</s:form>
				</div></td>
		</tr>
	</table>
	<%@include file="../footer.jsp"%>
</body>
</html>
