package qiang.action.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.*;
import org.apache.struts2.interceptor.*;

import qiang.action.base.BaseMgrAction;
import qiang.domain.*;
import qiang.exception.OAException;
import qiang.utility.WebConstant;

public class AddEmpAction extends BaseMgrAction {
	// 新增的员工
	private Employee emp;
	// 封装提示信息的tip属性
	private String tip;

	// emp属性的setter和getter方法
	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public Employee getEmp() {
		return this.emp;
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
		// 添加新用户
		if(mgrService.addEmp(emp, mgrName)){
			setTip("新增员工成功");
			return SUCCESS;
		}else {
			setTip("该员工与现有的员工重名。新增员工失败");
			return ERROR;
		}		
	}

}