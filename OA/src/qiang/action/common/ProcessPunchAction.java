package qiang.action.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.*;
import org.apache.struts2.interceptor.*;

import qiang.action.base.BaseEmpAction;
import qiang.exception.OAException;
import qiang.service.face.IEmpService;
import qiang.utility.WebConstant;
import static qiang.service.face.IEmpService.*;

import java.util.*;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class ProcessPunchAction extends BaseEmpAction {
	// ��װ��������tip����
	private String tip;

	// tip���Ե�setter��getter����
	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getTip() {
		return this.tip;
	}

	// �����ϰ�򿨵ķ���
	public String come() throws Exception {
		return process(true);
	}

	// �����°�򿨵ķ���
	public String leave() throws Exception {
		return process(false);
	}

	private String process(boolean isCome) throws Exception {
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		// ��ȡHttpSession�е�user����
		String user = (String) ctx.getSession().get(WebConstant.USER);
		System.out.println("-----��----" + user);
		Date dutyDay = new Date(System.currentTimeMillis());
		// ����ҵ���߼��������������
		int result = empService.punch(user, dutyDay, isCome);
		switch (result) {
		case PUNCH_FAIL:
			setTip("��ʧ��");
			break;
		case PUNCHED:
			setTip("���Ѿ�������ˣ���Ҫ�ظ���");
			break;
		case PUNCH_SUCC:
			setTip("�򿨳ɹ�");
			break;
		}
		return SUCCESS;
	}
}