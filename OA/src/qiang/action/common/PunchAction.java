package qiang.action.common;

import java.sql.Date;

import qiang.action.base.BaseEmpAction;
import qiang.utility.WebConstant;

import com.opensymphony.xwork2.ActionContext;

public class PunchAction extends BaseEmpAction {
	// 封装处理结果的punchIsValid属性
	private int punchIsValid;

	// punchIsValid属性的setter和getter方法
	public void setPunchIsValid(int punchIsValid) {
		this.punchIsValid = punchIsValid;
	}

	public int getPunchIsValid() {
		return this.punchIsValid;
	}

	public String execute() throws Exception {
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		// 获取HttpSession中的user属性
		String user = (String) ctx.getSession().get(WebConstant.USER);
		Date dutyDay = new Date(System.currentTimeMillis());
		// 调用业务逻辑方法处理用户请求
		int result = empService.validPunch(user, dutyDay);
		setPunchIsValid(result);
		return SUCCESS;
	}
}