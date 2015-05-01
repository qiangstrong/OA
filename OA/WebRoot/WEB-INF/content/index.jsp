<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
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
		<script>
			$(document).ready(function(){ 
				$('.bxslider').bxSlider({ auto: true, autoControls: true, autoHover:true,speed:500});
			});		
		</script>
	</head>
	<body>
	<center>
		<ul class="bxslider"> 
			<li><img src="image/01.jpg" /></li>
			<li><img src="image/02.jpg" /></li> 
			<li><img src="image/03.jpg" /></li> 
			<li><img src="image/04.jpg" /></li>
			<li><img src="image/05.jpg" /></li>
		</ul>
	</center>
	</body>
</html>
