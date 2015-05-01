<%@ page contentType="text/html; charset=gb2312" language="java"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" /> 
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>修改员工信息</title>
<s:head />
</head>
<body>
	<%@include file="../header.jsp"%>
	<%@include file="mgrheader.jsp"%>
	<table width=780 align="center" background="${pageContext.request.contextPath}/images/bodybg.jpg">
		<tr>
			<td>请您输入员工的资料：<br /> <s:if test="tip!=null">
					<div class="error">
						<s:property value="tip" />
					</div>
				</s:if>
				<div align="center">
					<s:form action="changeEmp" namespace="/">
						<s:hidden name="empName" value="%{empName}"/>
						<s:textfield name="emp.name" value="%{emp.name}" label="员工用户名" />
						<s:textfield name="emp.pass" value="%{emp.pass}" label="员工密码" />
						<s:textfield name="emp.salary" value="%{emp.salary}" label="员工月薪" />
						<s:token />
						<tr>
							<td colspan="2">
							<s:submit value="修改员工信息" theme="simple" /> 
							<s:reset theme="simple" value="重新输入" />
							</td>
						</tr>
					</s:form>
				</div></td>
		</tr>
	</table>
	<%@include file="../footer.jsp"%>
</body>
</html>
