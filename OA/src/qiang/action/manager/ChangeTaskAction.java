package qiang.action.manager;

import qiang.action.base.BaseMgrAction;
import qiang.domain.Task;

public class ChangeTaskAction extends BaseMgrAction {
	//要修改任务原来的名称
	private String taskName;
	//携带新信息的任务对象
	private Task task;
	private String tip;

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

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
	@Override
	public String execute() throws Exception {
		if (!mgrService.changeTask(taskName, task)) {
			setTip("该任务与现有的任务重名。修改任务信息失败。");
			return INPUT;
		}
		return SUCCESS;
	}
}
