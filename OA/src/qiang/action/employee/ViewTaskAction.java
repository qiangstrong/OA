package qiang.action.employee;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import qiang.action.base.BaseEmpAction;
import qiang.bean.AttendBean;
import qiang.bean.TaskBean;
import qiang.utility.WebConstant;

public class ViewTaskAction extends BaseEmpAction{
	private List<TaskBean> tasks;

	public List<TaskBean> getTasks() {
		return tasks;
	}

	public void setTasks(List<TaskBean> tasks) {
		this.tasks = tasks;
	}
	
	public String execute() throws Exception {
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		// ��ȡHttpSession�е�user����
		String user = (String) ctx.getSession().get(WebConstant.USER);
		tasks = empService.getTasks(user);
		return SUCCESS;
	}
}
