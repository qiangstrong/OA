package qiang.action.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.*;
import org.apache.struts2.interceptor.*;

import qiang.action.base.BaseMgrAction;
import qiang.exception.OAException;
import qiang.service.face.IEmpService;
import qiang.utility.WebConstant;

public class CheckAppAction extends BaseMgrAction {
	// 需要被处理的申请ID
	private int appid;
	// 封装处理结果
	private String result;
	// 封装处理提示
	private String tip;

	// appid属性的setter和getter方法
	public void setAppid(int appid) {
		this.appid = appid;
	}

	public int getAppid() {
		return this.appid;
	}

	// result属性的setter和getter方法
	public void setResult(String result) {
		this.result = result;
	}

	public String getResult() {
		return this.result;
	}

	// tip属性的setter和getter方法
	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getTip() {
		return this.tip;
	}

	public String execute() throws Exception {
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		// 获取HttpSession中的user属性
		String mgrName = (String) ctx.getSession().get(WebConstant.USER);
		// 通过申请
		if (result.equals("pass")) {
			mgrService.check(appid, mgrName, true);
		}
		// 拒绝申请
		else if (result.equals("deny")) {
			mgrService.check(appid, mgrName, false);
		} else {
			throw new Exception("参数丢失");
		}
		setTip("处理员工申请成功");
		return SUCCESS;
	}
}