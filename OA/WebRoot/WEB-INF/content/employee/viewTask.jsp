<%@ page contentType="text/html; charset=gb2312" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" /> 
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>查看任务</title>
</head>
<body>
	<%@include file="../header.jsp"%>
	<%@include file="empheader.jsp"%>
	<table width="780" align="center" background="${pageContext.request.contextPath}/images/bodybg.jpg">
		<tr>
			<td>
				<table width="80%" border="0" align="center" bgcolor="#cccccc">
					<tr bgcolor="#e1e1e1">
						<td colspan="4"><div class="mytitle">
								当前用户：
								<s:property value="#session.user" />
							</div>
						</td>
					</tr>
					<tr bgcolor="#e1e1e1">
						<td colspan="4">您需要完成的任务</td>
					</tr>
					<tr class="pt9" height="30">
						<td><b>任务名</b></td>
						<td><b>状态</b></td>
						<td><b>日期</b></td>
					</tr>
					<s:iterator value="tasks" status="index">
						<s:if test="#index.odd == true">
							<tr style="background-color:#dddddd" class="pt9" height="24">
						</s:if>
						<s:else>
							<tr class="pt9" height="24">
						</s:else>
						<td><s:property value="name" /></td>
						<td><s:property value="finish" /></td>
						<td><s:property value="datetime" /></td>
						</tr>
						<s:if test="#index.odd == true">
							<tr style="background-color:#dddddd" class="pt9" height="24">
						</s:if>
						<s:else>
							<tr class="pt9" height="24">
						</s:else>
						<td><b>详情</b></td>
						<td colspan="2"><s:property value="detail" /></td>				
						</tr>
					</s:iterator>
				</table>
			</td>
		</tr>
	</table>
	<%@include file="../footer.jsp"%>
</body>
</html>