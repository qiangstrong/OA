package qiang.action.manager;

import qiang.action.base.BaseMgrAction;
import qiang.domain.Task;

public class ShowTaskAction extends BaseMgrAction{
	
	private String taskName;
	private Task task;
	
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public Task getTask() {
		return task;
	}
	
	@Override
	public String execute() throws Exception {
		task=mgrService.queryTask(taskName);
		return SUCCESS;
	}
}
