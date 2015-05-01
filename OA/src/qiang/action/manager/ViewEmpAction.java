package qiang.action.manager;

import java.util.List;

import qiang.action.base.BaseMgrAction;
import qiang.bean.PageBean;
import qiang.utility.WebConstant;

import com.opensymphony.xwork2.ActionContext;

public class ViewEmpAction extends BaseMgrAction {
	// 封装当前经理所有员工的List
	private List emps;
	// 部门的员工数
	private long empNum;
	// 传递分页显示的数据
	private PageBean pageBean;
	private String tip;

	// emps属性的setter和getter方法
	public void setEmps(List emps) {
		this.emps = emps;
	}

	public List getEmps() {
		return this.emps;
	}

	public long getEmpNum() {
		return empNum;
	}

	public void setEmpNum(long empNum) {
		this.empNum = empNum;
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
		// 查询员工数
		setEmpNum(mgrService.countEmpByMgr(mgrName));
		// 从session中取出当前页号
		Integer pageNo = (Integer) ctx.getSession().get(WebConstant.EMP_PAGENO);
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
		ctx.getSession().put(WebConstant.EMP_PAGENO, pageNo);
		setEmps(mgrService.getEmpsByMgr(mgrName, pageNo));

		// 从session中取出其他action的tip
		String tempTip = (String) ctx.getSession().get(WebConstant.EMP_TIP);
		if (tempTip != null) {
			ctx.getSession().put(WebConstant.EMP_TIP, null);
			setTip(tempTip);
		}
		return SUCCESS;
	}
}