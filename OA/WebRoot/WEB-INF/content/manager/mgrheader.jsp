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
			<li id="m_1" class='m_li_a'><a href="managerIndex.action">ϵͳ��ҳ</a></li>
			<li class="m_line"><img src="image/line1.gif" /></li>
			<li id="m_2" class='m_li' onmouseover='mover(2);' onmouseout='mout(2);'><a href="#">��������</a>
			</li>
			<li class="m_line"><img src="image/line1.gif" /></li>
			<li id="m_3" class='m_li' onmouseover='mover(3);' onmouseout='mout(3);'><a href="#">����Ա��</a>
			</li>
			<li class="m_line"><img src="image/line1.gif" /></li>
			<li id="m_4" class='m_li' onmouseover='mover(4);' onmouseout='mout(4);'><a href="#">��������</a>
			</li>
			<li class="m_line"><img src="image/line1.gif" /></li>
			<li id="m_5" class='m_li' onmouseover='mover(5);' onmouseout='mout(5);'><a href="#">�鿴����</a>
			</li>
			<li class="m_line"><img src="image/line1.gif" /></li>
			<li id="m_6" class='m_li' onmouseover='mover(6);' onmouseout='mout(6);'><a href="logout.action">�˳�ϵͳ</a>
			</li>
			<li class="m_line"><img src="image/line1.gif" /></li>
		</ul>
	</div>
	<div style="height:32px; background-color:#F1F1F1;">
		<ul class="smenu">
			<li style="padding-left:29px;" id="s_1" class='s_li_a'>
				<s:property value="#session.user"/>����ӭ��ʹ�ð칫�Զ���ϵͳ�����Ǿ���
			</li>
			<li style="padding-left:141px;" id="s_2" class='s_li' onmouseover='mover(2);'onmouseout='mout(2);'>
				<a href="managerPunch.action">���˴�</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="managerShowChangePass.action">�޸�����</a>
			</li>
			<li style="padding-left:252px;" id="s_3" class='s_li' onmouseover='mover(3);'onmouseout='mout(3);'>
				<a href="viewEmp.action?pageBean.type=1&&pageBean.pageNo=1">�鿴Ա��</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="showAddEmp.action">����Ա��</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="viewApp.action">�������</a>
			</li>
			<li style="padding-left:362px;" id="s_4" class='s_li' onmouseover='mover(4);'onmouseout='mout(4);'>
				<a href="adminTask.action?pageBean.type=1&&pageBean.pageNo=1">�鿴����</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="showAddTask.action">��������</a>
			</li>
			<li style="padding-left:474px;" id="s_5" class='s_li' onmouseover='mover(5);'onmouseout='mout(5);'>
				<a href="managerViewSalary.action">��ʷ����</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="viewDeptSal.action">���Ź���</a>
			</li>
			<li style="padding-left:447px;" id="s_6" class='s_li' onmouseover='mover(6);'onmouseout='mout(6);'>
				����Ҫ�˳�ϵͳ��
			</li>
		</ul>
	</div>
</body>
</html>