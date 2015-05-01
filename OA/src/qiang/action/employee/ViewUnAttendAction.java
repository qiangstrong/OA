package qiang.action.employee;

import java.util.List;

import qiang.action.base.BaseEmpAction;
import qiang.bean.AttendBean;
import qiang.utility.WebConstant;

import com.opensymphony.xwork2.ActionContext;

public class ViewUnAttendAction extends BaseEmpAction {
	private List<AttendBean> unAttend;

	// unAttend属性的setter和getter方法
	public void setUnAttend(List<AttendBean> unAttend) {
		this.unAttend = unAttend;
	}

	public List<AttendBean> getUnAttend() {
		return this.unAttend;
	}

	public String execute() throws Exception {
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		// 获取HttpSession中的user属性
		String user = (String) ctx.getSession().get(WebConstant.USER);
		List<AttendBean> result = empService.unAttend(user);
		setUnAttend(result);
		return SUCCESS;
	}
}