package qiang.action.common;

import static qiang.service.face.IEmpService.LOGIN_EMP;
import static qiang.service.face.IEmpService.LOGIN_MGR;
import qiang.action.base.BaseEmpAction;
import qiang.domain.Manager;
import qiang.utility.WebConstant;

import com.opensymphony.xwork2.ActionContext;

public class LoginAction extends BaseEmpAction {
	// ����һ��������ΪԱ����¼�ɹ���Result��
	private final String EMP_RESULT = "emp";
	// ����һ��������Ϊ�����¼�ɹ���Result��
	private final String MGR_RESULT = "mgr";
	// ��װ�������
	private Manager manager;
	// ��¼����֤��
	private String vercode;
	// �����¼�����ʾ��Ϣ
	private String tip;

	// manager���Ե�setter��getter����
	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Manager getManager() {
		return this.manager;
	}

	// vercode���Ե�setter��getter����
	public void setVercode(String vercode) {
		this.vercode = vercode;
	}

	public String getVercode() {
		return this.vercode;
	}

	// tip���Ե�setter��getter����
	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getTip() {
		return this.tip;
	}

	// �����û�����
	public String execute() throws Exception {
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		// ��ȡHttpSession�е�rand����
		String ver2 = (String) ctx.getSession().get("rand");
		if (vercode.equalsIgnoreCase(ver2))
		{
			// ����ҵ���߼������������¼����
			int result = empService.validLogin(getManager());
			// ��¼���Ϊ��ͨԱ��
			if (result == LOGIN_EMP) {
				ctx.getSession().put(WebConstant.USER, manager.getName());
				ctx.getSession().put(WebConstant.LEVEL, WebConstant.EMP_LEVEL);
				return EMP_RESULT;
			}
			// ��¼���Ϊ����
			else if (result == LOGIN_MGR) {
				ctx.getSession().put(WebConstant.USER, manager.getName());
				ctx.getSession().put(WebConstant.LEVEL, WebConstant.MGR_LEVEL);
				return MGR_RESULT;
			}
			// �û��������벻ƥ��
			else {
				setTip("�û���/���벻ƥ��");
				return ERROR;
			}
		}
		// ��֤�벻ƥ��
		else {
			setTip("��֤�벻ƥ��,����������");
			return ERROR;
		}
	}
}