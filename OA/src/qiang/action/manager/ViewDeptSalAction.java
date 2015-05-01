package qiang.action.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.*;
import org.apache.struts2.interceptor.*;

import qiang.action.base.BaseMgrAction;
import qiang.bean.*;
import qiang.exception.OAException;
import qiang.service.face.IMgrService;
import qiang.utility.WebConstant;

import java.util.List;

public class ViewDeptSalAction extends BaseMgrAction {
	// 封装发薪列表的List属性
	private List sals;

	// sals属性的setter和getter方法
	public void setSals(List sals) {
		this.sals = sals;
	}

	public List getSals() {
		return this.sals;
	}

	public String execute() throws Exception {
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		// 获取HttpSession中的user属性
		String mgrName = (String) ctx.getSession().get(WebConstant.USER);
		// 调用业务逻辑方法取得当前员工的全部发薪列表
		List<SalaryBean> result = mgrService.getSalaryByMgr(mgrName);
		System.out.println("--------------" + result);
		setSals(result);
		return SUCCESS;
	}
}