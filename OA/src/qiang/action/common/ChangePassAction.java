package qiang.action.common;

import com.opensymphony.xwork2.ActionContext;

import qiang.action.base.BaseEmpAction;
import qiang.domain.Employee;
import qiang.utility.WebConstant;

public class ChangePassAction extends BaseEmpAction {
	// 密码
	private String pass1;
	// 确认密码
	private String pass2;
	// 封装提示信息的tip属性
	private String tip;

	public String getPass1() {
		return this.pass1;
	}

	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}

	public String getPass2() {
		return pass2;
	}

	public void setPass2(String pass2) {
		this.pass2 = pass2;
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
		String name = (String) ctx.getSession().get(WebConstant.USER);
		if(!pass1.equals(pass2)){
			setTip("两次输入密码不一致！修改失败。");
			return INPUT;
		}
		empService.changePass(name, pass1);
		setTip("修改密码成功。");
		return SUCCESS;
	}
}
