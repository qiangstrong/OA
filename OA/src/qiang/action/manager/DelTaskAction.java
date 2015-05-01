package qiang.action.manager;

import com.opensymphony.xwork2.ActionContext;

import qiang.action.base.BaseMgrAction;
import qiang.utility.WebConstant;

public class DelTaskAction extends BaseMgrAction {
	//待删除任务的名称
	private String taskName;
	private String tip;

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	@Override
	public String execute() throws Exception {
		mgrService.delTask(taskName);
		setTip("任务名称为"+taskName+"的任务已被删除。");
		ActionContext ctx=ActionContext.getContext();
		ctx.getSession().put(WebConstant.TASK_TIP, tip);
		return SUCCESS;
	}
}
