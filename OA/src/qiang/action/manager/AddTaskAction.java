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
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		// 获取HttpSession中的user属性
		String mgrName = (String) ctx.getSession().get(WebConstant.USER);
		// 添加新任务
		if(mgrService.addTask(task, mgrName)){
			setTip("新增任务成功。");
			return SUCCESS;
		}else {
			setTip("该任务与现有的任务重名。新增任务失败。");
			return ERROR;
		}	
	}
}
