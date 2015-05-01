<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<link href="css/jquery.bxslider.css" rel="stylesheet" />
		<script src="javascript/jquery.js"></script> 
		<script src="javascript/jquery.bxslider.min.js"></script> 		 		
		<title>图片</title>
		<script>
			$(document).ready(function(){ 
				$('.bxslider').bxSlider({ auto: true, autoControls: true, autoHover:true,speed:500});
			});		
		</script>
	</head>
	<body>
	<center>
		<s:form action="managerLeave">
			<s:submit type="image" value="确定" src="image/01.jpg"/>
		</s:form>
	</center>
	</body>
</html>
