<%@ page contentType="text/html; charset=gb2312" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" /> 
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>�鿴������ȫ��Ա��</title>
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
							�����ڲ鿴���ŵ�ȫ��������������<s:property value="taskNum"/>
							</div>
						</td>
					</tr>
					<tr class="pt9" height="30">
						<td><b>��������</b></td>
						<td><b>״̬</b></td>
						<td><b>����</b></td>
						<td><b>�޸�</b></td>
						<td><b>ɾ��</b></td>
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
						<td><a href="showTask.action?taskName=<s:property value="name" />">�޸�</a></td>
						<td><a href="delTask.action?taskName=<s:property value="name" />">ɾ��</a></td>
						</tr>
						<s:if test="#index.odd == true">
							<tr style="background-color:#dddddd" class="pt9" height="24">
						</s:if>
						<s:else>
							<tr class="pt9" height="24">
						</s:else>
						<td><b>����</b></td>
						<td colspan="4"><s:property value="detail" /></td>				
						</tr>
					</s:iterator>
				</table>
			</td>
		</tr>
		<tr>
			<table width="30%" align="center" >
				<tr>
				<td><a href="adminTask.action?pageBean.type=0">��һҳ</a></td>
				<td><s:form action="adminTask" namespace="/">
						<s:hidden name="pageBean.type" value="1"/>
						<s:textfield name="pageBean.pageNo" value="%{#session.taskPageNo}" size="5"></s:textfield>
					</s:form>
				</td>
				<td><a href="adminTask.action?pageBean.type=2">��һҳ</a></td>
				<tr>
			</table>
		</tr>
	</table>
	<%@include file="../footer.jsp"%>
</body>
</html>