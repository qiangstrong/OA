package qiang.action.common;

import java.sql.Date;

import qiang.action.base.BaseEmpAction;
import qiang.utility.WebConstant;

import com.opensymphony.xwork2.ActionContext;

public class PunchAction extends BaseEmpAction {
	// ��װ��������punchIsValid����
	private int punchIsValid;

	// punchIsValid���Ե�setter��getter����
	public void setPunchIsValid(int punchIsValid) {
		this.punchIsValid = punchIsValid;
	}

	public int getPunchIsValid() {
		return this.punchIsValid;
	}

	public String execute() throws Exception {
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		// ��ȡHttpSession�е�user����
		String user = (String) ctx.getSession().get(WebConstant.USER);
		Date dutyDay = new Date(System.currentTimeMillis());
		// ����ҵ���߼����������û�����
		int result = empService.validPunch(user, dutyDay);
		setPunchIsValid(result);
		return SUCCESS;
	}
}