<%@ page contentType="text/html; charset=gb2312" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" /> 
   <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
   <title>��������</title>
</head>
<body>
<s:if test="tip!=null">
	<script>
		alert('${tip}');
	</script>
</s:if>
<%@include file="../header.jsp"%>
<%@include file="mgrheader.jsp"%>
<table width=780 align="center"
	background="${pageContext.request.contextPath}/images/bodybg.jpg">
<tr>
<td><br>
<table width="80%" border="0" align="center" bgcolor="#cccccc">
  <tr bgcolor="#e1e1e1" >
	<td colspan="5" ><div class="mytitle">��������</div></td> 
  </tr>
  <tr class="pt9" height="30">
	<td><b>Ա����</b></td>
	<td><b>ȱ������</b></td>
	<td><b>��������</b></td>
	<td><b>����</b></td>
	<td>&nbsp;</td>
  </tr>
<s:iterator value="apps" status="index">	
 	<s:if test="#index.odd == true"> 
		 <tr style="background-color:#cccccc" class="pt9" height="24">
	</s:if> 
	<s:else> 
		 <tr class="pt9" height="24">
	</s:else>
	<td><s:property value="emp"/></td>
	<td><s:property value="unAttend"/></td>
	<td><s:property value="toAttend"/></td>
	<td><s:property value="reason"/></td>
	<td>
	<a href='checkApp.action?result=pass&appid=<s:property value="id"/>'>ͨ��</a>&nbsp;&nbsp;
	<a href='checkApp.action?result=deny&appid=<s:property value="id"/>'>�ܾ�</a>
	</td>
  </tr>
</s:iterator>
</table>
</td>
</tr>
</table>
<%@include file="../footer.jsp"%>
</body>
</html>