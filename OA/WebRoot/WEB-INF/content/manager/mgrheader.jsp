<%@ page contentType="text/html; charset=gb2312"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="css/mgrheader.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="javascript/mgrheader.js"></script>
</head>
<body>
	<div id="menu">
		<ul>
			<li class="m_line"><img src="image/line1.gif" /></li>
			<li id="m_1" class='m_li_a'><a href="managerIndex.action">系统首页</a></li>
			<li class="m_line"><img src="image/line1.gif" /></li>
			<li id="m_2" class='m_li' onmouseover='mover(2);' onmouseout='mout(2);'><a href="#">个人事务</a>
			</li>
			<li class="m_line"><img src="image/line1.gif" /></li>
			<li id="m_3" class='m_li' onmouseover='mover(3);' onmouseout='mout(3);'><a href="#">管理员工</a>
			</li>
			<li class="m_line"><img src="image/line1.gif" /></li>
			<li id="m_4" class='m_li' onmouseover='mover(4);' onmouseout='mout(4);'><a href="#">管理任务</a>
			</li>
			<li class="m_line"><img src="image/line1.gif" /></li>
			<li id="m_5" class='m_li' onmouseover='mover(5);' onmouseout='mout(5);'><a href="#">查看工资</a>
			</li>
			<li class="m_line"><img src="image/line1.gif" /></li>
			<li id="m_6" class='m_li' onmouseover='mover(6);' onmouseout='mout(6);'><a href="logout.action">退出系统</a>
			</li>
			<li class="m_line"><img src="image/line1.gif" /></li>
		</ul>
	</div>
	<div style="height:32px; background-color:#F1F1F1;">
		<ul class="smenu">
			<li style="padding-left:29px;" id="s_1" class='s_li_a'>
				<s:property value="#session.user"/>，欢迎您使用办公自动化系统，您是经理！
			</li>
			<li style="padding-left:141px;" id="s_2" class='s_li' onmouseover='mover(2);'onmouseout='mout(2);'>
				<a href="managerPunch.action">个人打卡</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="managerShowChangePass.action">修改密码</a>
			</li>
			<li style="padding-left:252px;" id="s_3" class='s_li' onmouseover='mover(3);'onmouseout='mout(3);'>
				<a href="viewEmp.action?pageBean.type=1&&pageBean.pageNo=1">查看员工</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="showAddEmp.action">新增员工</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="viewApp.action">审核申请</a>
			</li>
			<li style="padding-left:362px;" id="s_4" class='s_li' onmouseover='mover(4);'onmouseout='mout(4);'>
				<a href="adminTask.action?pageBean.type=1&&pageBean.pageNo=1">查看任务</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="showAddTask.action">新增任务</a>
			</li>
			<li style="padding-left:474px;" id="s_5" class='s_li' onmouseover='mover(5);'onmouseout='mout(5);'>
				<a href="managerViewSalary.action">历史工资</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="viewDeptSal.action">部门工资</a>
			</li>
			<li style="padding-left:447px;" id="s_6" class='s_li' onmouseover='mover(6);'onmouseout='mout(6);'>
				您将要退出系统。
			</li>
		</ul>
	</div>
</body>
</html>