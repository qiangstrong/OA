package qiang.action.manager;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import qiang.action.base.BaseMgrAction;
import qiang.bean.PageBean;
import qiang.utility.WebConstant;

public class AdminTaskAction extends BaseMgrAction {
	// 封装当前经理所有任务的List
	private List tasks;
	// 任务数
	private long taskNum;
	// 传递分页显示的数据
	private PageBean pageBean;
	private String tip;

	// emps属性的setter和getter方法
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
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		// 获取HttpSession中的user属性
		String mgrName = (String) ctx.getSession().get(WebConstant.USER);
		// 查询任务数
		setTaskNum(mgrService.countTaskByMgr(mgrName));
		// 从session中取出当前页号
		Integer pageNo = (Integer) ctx.getSession().get(WebConstant.TASK_PAGRNO);
		if (pageNo == null)
			pageNo = 1;
		// 上一页操作
		if (pageBean.getType() == WebConstant.PREV) {
			pageNo--;
			if (pageNo < 1) {
				pageNo = 1;
			}
		} else if (pageBean.getType() == WebConstant.CUR) {	// 跳转到指定的页号
			int tempPageNo = pageBean.getPageNo();
			// 若指定了页号，则跳转到指定页号；若没有指定页号，则使用session中的页号
			if (tempPageNo != 0) {
				pageNo = tempPageNo;
			}
		} else {		// 下一页操作
			pageNo++;
		}
		// 更新session中的页号
		ctx.getSession().put(WebConstant.TASK_PAGRNO, pageNo);
		// 查询
		setTasks(mgrService.getTasksByMgr(mgrName, pageNo));

		// 从session中取出其他action的tip
		String tempTip = (String) ctx.getSession().get(WebConstant.TASK_TIP);
		if (tempTip != null) {
			//清除session中的tip
			ctx.getSession().put(WebConstant.TASK_TIP, null);
			setTip(tempTip);
		}
		return SUCCESS;
	}
}
