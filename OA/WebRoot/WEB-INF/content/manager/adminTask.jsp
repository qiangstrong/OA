<%@ page contentType="text/html; charset=gb2312" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" /> 
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>查看本部门全部员工</title>
</head>
<body>
<s:if test="tip!=null">
	<script>
		alert('${tip}');
	</script>
</s:if>
	<%@include file="../header.jsp"%>
	<%@include file="mgrheader.jsp"%>
	<table width="780" align="center" background="${pageContext.request.contextPath}/images/bodybg.jpg">
		<tr>
			<td><br>
				<table width="80%" border="0" align="center" cellspacing="1" bgcolor="#cccccc">
					<tr bgcolor="#e1e1e1">
						<td colspan="5">
							<div class="mytitle">
							您正在查看部门的全部任务。任务数：<s:property value="taskNum"/>
							</div>
						</td>
					</tr>
					<tr class="pt9" height="30">
						<td><b>任务名称</b></td>
						<td><b>状态</b></td>
						<td><b>日期</b></td>
						<td><b>修改</b></td>
						<td><b>删除</b></td>
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
						<td><a href="showTask.action?taskName=<s:property value="name" />">修改</a></td>
						<td><a href="delTask.action?taskName=<s:property value="name" />">删除</a></td>
						</tr>
						<s:if test="#index.odd == true">
							<tr style="background-color:#dddddd" class="pt9" height="24">
						</s:if>
						<s:else>
							<tr class="pt9" height="24">
						</s:else>
						<td><b>详情</b></td>
						<td colspan="4"><s:property value="detail" /></td>				
						</tr>
					</s:iterator>
				</table>
			</td>
		</tr>
		<tr>
			<table width="30%" align="center" >
				<tr>
				<td><a href="adminTask.action?pageBean.type=0">上一页</a></td>
				<td><s:form action="adminTask" namespace="/">
						<s:hidden name="pageBean.type" value="1"/>
						<s:textfield name="pageBean.pageNo" value="%{#session.taskPageNo}" size="5"></s:textfield>
					</s:form>
				</td>
				<td><a href="adminTask.action?pageBean.type=2">下一页</a></td>
				<tr>
			</table>
		</tr>
	</table>
	<%@include file="../footer.jsp"%>
</body>
</html>