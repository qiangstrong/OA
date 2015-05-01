<%@ page contentType="text/html; charset=gb2312" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">	
	<title>员工首页</title>
</head>
<body>
	<%@include file="../header.jsp"%>
	<%@include file="empheader.jsp"%>
	<center>
		<s:property value="#session.user" />，欢迎您使用办公自动化系统，您是普通员工。		
	</center>
	<%@include file="../index.jsp"%>
	<%@include file="../footer.jsp"%>
</body>
</html>
