<%@ page contentType="text/html; charset=gb2312" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" /> 
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>修改密码</title>
</head>
<body>
	<s:if test="tip!=null">
		<script>
			alert('${tip}');
		</script>
	</s:if>
	<%@include file="../header.jsp"%>
	<%@include file="mgrheader.jsp"%>
	<table width=300 align="center">
		<tr>
			<td><h4>请输入新密码</h4><br />
				<s:form action="managerChangePass" namespace="/">
					<s:password name="pass1" label="密码" />
					<s:password name="pass2" label="确认密码" />
					<tr>
						<td colspan="2">
							<s:submit value="确定" theme="simple" />
							<s:reset theme="simple" value="重填" />
						</td>
					</tr>
				</s:form>
			</td>
		</tr>
	</table>
	<%@include file="../footer.jsp"%>
</body>
</html>