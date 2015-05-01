package qiang.action.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.*;
import org.apache.struts2.interceptor.*;

import qiang.action.base.BaseMgrAction;
import qiang.domain.*;
import qiang.exception.OAException;
import qiang.utility.WebConstant;

public class AddEmpAction extends BaseMgrAction {
	// ������Ա��
	private Employee emp;
	// ��װ��ʾ��Ϣ��tip����
	private String tip;

	// emp���Ե�setter��getter����
	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public Employee getEmp() {
		return this.emp;
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
		String mgrName = (String) ctx.getSession().get(WebConstant.USER);
		// ������û�
		if(mgrService.addEmp(emp, mgrName)){
			setTip("����Ա���ɹ�");
			return SUCCESS;
		}else {
			setTip("��Ա�������е�Ա������������Ա��ʧ��");
			return ERROR;
		}		
	}

}