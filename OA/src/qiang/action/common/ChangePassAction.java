package qiang.action.common;

import com.opensymphony.xwork2.ActionContext;

import qiang.action.base.BaseEmpAction;
import qiang.domain.Employee;
import qiang.utility.WebConstant;

public class ChangePassAction extends BaseEmpAction {
	// ����
	private String pass1;
	// ȷ������
	private String pass2;
	// ��װ��ʾ��Ϣ��tip����
	private String tip;

	public String getPass1() {
		return this.pass1;
	}

	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}

	public String getPass2() {
		return pass2;
	}

	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}

	// tip���Ե�setter��getter����
	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getTip() {
		return this.tip;
	}

	public String execute() throws Exception {
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		// ��ȡHttpSession�е�user����
		String name = (String) ctx.getSession().get(WebConstant.USER);
		if(!pass1.equals(pass2)){
			setTip("�����������벻һ�£��޸�ʧ�ܡ�");
			return INPUT;
		}
		empService.changePass(name, pass1);
		setTip("�޸�����ɹ���");
		return SUCCESS;
	}
}
