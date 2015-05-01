package qiang.action.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.*;
import org.apache.struts2.interceptor.*;

import qiang.action.base.BaseEmpAction;
import qiang.exception.OAException;
import qiang.service.face.IEmpService;
import qiang.utility.WebConstant;
import static qiang.service.face.IEmpService.*;

import java.util.*;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class ProcessPunchAction extends BaseEmpAction {
	// 封装处理结果的tip属性
	private String tip;

	// tip属性的setter和getter方法
	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getTip() {
		return this.tip;
	}

	// 处理上班打卡的方法
	public String come() throws Exception {
		return process(true);
	}

	// 处理下班打卡的方法
	public String leave() throws Exception {
		return process(false);
	}

	private String process(boolean isCome) throws Exception {
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		// 获取HttpSession中的user属性
		String user = (String) ctx.getSession().get(WebConstant.USER);
		System.out.println("-----打卡----" + user);
		Date dutyDay = new Date(System.currentTimeMillis());
		// 调用业务逻辑方法处理打卡请求
		int result = empService.punch(user, dutyDay, isCome);
		switch (result) {
		case PUNCH_FAIL:
			setTip("打卡失败");
			break;
		case PUNCHED:
			setTip("您已经打过卡了，不要重复打卡");
			break;
		case PUNCH_SUCC:
			setTip("打卡成功");
			break;
		}
		return SUCCESS;
	}
}