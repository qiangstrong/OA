package qiang.action.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.*;
import org.apache.struts2.interceptor.*;

import qiang.action.base.BaseMgrAction;
import qiang.exception.OAException;
import qiang.service.face.IMgrService;
import qiang.utility.WebConstant;

import java.util.List;

public class ViewAppAction extends BaseMgrAction {
	private List apps;

	// apps属性的setter和getter方法
	public void setApps(List apps) {
		this.apps = apps;
	}

	public List getApps() {
		return this.apps;
	}

	public String execute() throws Exception {
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		// 获取HttpSession中的user属性
		String mgrName = (String) ctx.getSession().get(WebConstant.USER);
		// 获取需要被当前经理处理的全部申请
		setApps(mgrService.getAppsByMgr(mgrName));
		return SUCCESS;
	}
}