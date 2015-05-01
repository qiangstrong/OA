<%@ page contentType="text/html; charset=gb2312" language="java"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" /> 
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<link href="css/button.css" rel="stylesheet" />
	<title>修改任务信息</title>
</head>
<body>
	<%@include file="../header.jsp"%>
	<%@include file="mgrheader.jsp"%>
	<table width=300 align="center">
		<tr>
			<td><h4>请输入新任务的资料：</h4>
				<s:if test="tip!=null">
					<div class="error">
						<s:property value="tip" />
					</div>
				</s:if>
				<s:fielderror/>
				<s:form action="addTask" namespace="/" theme="simple">
					<s:hidden name="taskName" value="%{taskName}"/>
					<b>任务名称</b>&nbsp;&nbsp;<s:textfield name="task.name" value="%{task.name}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<b>是否完成</b>&nbsp;&nbsp;<s:checkbox name="task.finish" value="%{task.finish}" fieldValue="true"/><br/><br/>
					<b>任务详情</b><br/>
					<s:textarea name="task.detail" value="%{task.detail}" rows="12" cols="50"/>
					<s:token />
					<tr>
						<td colspan="2" height="50px">
						<s:submit value="添加任务" theme="simple" cssClass="button"/> 
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
