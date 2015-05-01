package qiang.action.manager;

import com.opensymphony.xwork2.ActionContext;

import qiang.action.base.BaseMgrAction;
import qiang.utility.WebConstant;

public class DelEmpAction extends BaseMgrAction{
	//��ɾ����Ա�����û���
	private String empName;
	private String tip;
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	
	@Override
	public String execute() throws Exception {
		mgrService.delEmp(empName);
		setTip("�û���Ϊ"+empName+"��Ա���ѱ�ɾ����");
		ActionContext ctx=ActionContext.getContext();
		ctx.getSession().put(WebConstant.EMP_TIP, tip);
		return SUCCESS;
	}
}
