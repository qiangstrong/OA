package qiang.action.manager;

import qiang.action.base.BaseMgrAction;
import qiang.domain.Task;

public class ChangeTaskAction extends BaseMgrAction {
	//Ҫ�޸�����ԭ��������
	private String taskName;
	//Я������Ϣ���������
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
			setTip("�����������е������������޸�������Ϣʧ�ܡ�");
			return INPUT;
		}
		return SUCCESS;
	}
}
