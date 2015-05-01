<%@ page contentType="text/html; charset=gb2312" language="java"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" /> 
	<link href="css/button.css" rel="stylesheet" />
	<title>登录系统</title>  
</head>
<body style="margin: 0; padding: 0px; background-color: #F2F2F2">	
    <form name="form1" method="post" action="login">	
	    <br /><br /><br />
	    <div style="width: 100%; height: 567px; background-image: url('image/dengluBg.png');text-align: center; margin: 0px; padding: 0">
	        <div style="width: 1024px; height: 486px; background-image: url('image/dengluMain.png');margin: auto">
	            <table style="width: 100%; height: 100%" border="0" cellpadding="0" cellspacing="0">
	                <tr>
	                    <td style="width: 420px; height: 100px">
	                    </td>
	                    <td>
	                    </td>
	                </tr>
					<tr>
	                    <td style="height: 30px" align="right">
	                        <span style="font-size: 13px; font-style: normal; color: #ffffff"></span>
	                    </td>
	                    <td align="left">
	                        &nbsp;&nbsp;
	                        <s:fielderror/>
	                        <s:if test="tip!=null"><div class="error"><s:property value="tip" /></div></s:if>
	                    </td>
	                </tr>
	                <tr>
	                    <td style="height: 30px" align="right">
	                        <span style="font-size: 13px; font-style: normal; color: #ffffff">用户账号</span>
	                    </td>
	                    <td align="left">
	                        &nbsp;
	                        <input name="manager.name" type="text" class="text" maxlength="20" style="width:150px;height:16px;" />
	                    </td>
	                </tr>
	                <tr>
	                    <td style="height: 30px" align="right">
	                        <span style="font-size: 13px; font-style: normal; color: #ffffff">用户密码</span>
	                    </td>
	                    <td align="left">
	                        &nbsp;&nbsp;<input name="manager.pass" type="password" class="text" style="width:150px;height:16px;" />
	                    </td>
	                </tr>
	                <tr>
	                    <td style="height: 30px" align="right">
	                        <span style="font-size: 13px; font-style: normal; color: #ffffff">验证码</span>
	                    </td>
	                    <td align="left">
	                        &nbsp;&nbsp;<input name="vercode" type="text" class="text" style="width:150px;height:16px;" />
	                    </td>
	                </tr>
	                <tr>
	                    <td style="height: 30px" align="right">
	                        <span style="font-size: 13px; font-style: normal; color: #ffffff"></span>
	                    </td>
	                    <td align="left">
	                        &nbsp;&nbsp;<img name="d" src="authImg">
	                    </td>
	                </tr>
	                <tr>
	                    <td>
	                    </td>
	                    <td align="left"> 
	                        <input type="submit"  value="登录" class="button" style="height:35px;width:70px;border-width:0px;"/>
	                        <input type="reset" value="重置"  class="button" style="height:35px;width:70px;border-width:0px;" />
	                    </td>
	                </tr>
	                <tr style="height: 200px;">
	                    <td>
	                    </td>
	                    <td>
	                    </td>
	                </tr>
	            </table>
	        </div>
	    </div>
    </form>
</body>
</html>
