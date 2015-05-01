package qiang.action.manager;

import com.opensymphony.xwork2.ActionContext;

import qiang.action.base.BaseMgrAction;
import qiang.domain.Task;
import qiang.utility.WebConstant;

public class AddTaskAction extends BaseMgrAction{
	private Task task;
	private String tip;
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String execute() throws Exception {
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		// ��ȡHttpSession�е�user����
		String mgrName = (String) ctx.getSession().get(WebConstant.USER);
		// ���������
		if(mgrService.addTask(task, mgrName)){
			setTip("��������ɹ���");
			return SUCCESS;
		}else {
			setTip("�����������е�������������������ʧ�ܡ�");
			return ERROR;
		}	
	}
}
