package qiang.action.manager;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import qiang.action.base.BaseMgrAction;
import qiang.bean.PageBean;
import qiang.utility.WebConstant;

public class AdminTaskAction extends BaseMgrAction {
	// ��װ��ǰ�������������List
	private List tasks;
	// ������
	private long taskNum;
	// ���ݷ�ҳ��ʾ������
	private PageBean pageBean;
	private String tip;

	// emps���Ե�setter��getter����
	public void setTasks(List tasks) {
		this.tasks = tasks;
	}

	public List getTasks() {
		return this.tasks;
	}

	public long getTaskNum() {
		return taskNum;
	}

	public void setTaskNum(long taskNum) {
		this.taskNum = taskNum;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
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
		// ��ѯ������
		setTaskNum(mgrService.countTaskByMgr(mgrName));
		// ��session��ȡ����ǰҳ��
		Integer pageNo = (Integer) ctx.getSession().get(WebConstant.TASK_PAGRNO);
		if (pageNo == null)
			pageNo = 1;
		// ��һҳ����
		if (pageBean.getType() == WebConstant.PREV) {
			pageNo--;
			if (pageNo < 1) {
				pageNo = 1;
			}
		} else if (pageBean.getType() == WebConstant.CUR) {	// ��ת��ָ����ҳ��
			int tempPageNo = pageBean.getPageNo();
			// ��ָ����ҳ�ţ�����ת��ָ��ҳ�ţ���û��ָ��ҳ�ţ���ʹ��session�е�ҳ��
			if (tempPageNo != 0) {
				pageNo = tempPageNo;
			}
		} else {		// ��һҳ����
			pageNo++;
		}
		// ����session�е�ҳ��
		ctx.getSession().put(WebConstant.TASK_PAGRNO, pageNo);
		// ��ѯ
		setTasks(mgrService.getTasksByMgr(mgrName, pageNo));

		// ��session��ȡ������action��tip
		String tempTip = (String) ctx.getSession().get(WebConstant.TASK_TIP);
		if (tempTip != null) {
			//���session�е�tip
			ctx.getSession().put(WebConstant.TASK_TIP, null);
			setTip(tempTip);
		}
		return SUCCESS;
	}
}
