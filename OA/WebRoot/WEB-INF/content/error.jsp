<%@ page contentType="text/html; charset=gb2312" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" /> 
   <title>������ʾҳ</title>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<body>
<%@include file="header.jsp"%> 
<table width=780 align="center"
	background="${pageContext.request.contextPath}/images/bodybg.jpg">
<tr> 
<td height="39"><br>
<div align="center"><font color="#FF0000" size="+1"><b>ϵͳ��������з�����һ��������Ϣ���£�</b></font></div>
</td>
</tr>
<tr>
<td height="315">
<a href="http://www.crazyit.org">
<s:property value="exception.message"/>
</a>
</td>
</tr>
<tr>
<td><div align="center" style="font:large;color:#333333">
�����Ⱥ˶����룬����ٴγ��ָô�������ϵ<a href="mailto:1625025370@qq.com">1625025370@qq.com</a>��лл��
</div><br></td>
</tr>
</table>
<%@include file="footer.jsp"%> 
</body>
</html>

