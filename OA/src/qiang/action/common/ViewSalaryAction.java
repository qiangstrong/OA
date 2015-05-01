package qiang.action.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.*;
import org.apache.struts2.interceptor.*;

import qiang.action.base.BaseEmpAction;
import qiang.bean.*;
import qiang.exception.OAException;
import qiang.service.face.IEmpService;
import qiang.utility.WebConstant;

import java.util.*;

public class ViewSalaryAction extends BaseEmpAction {
	// ��װ���з�н��Ϣ��List
	private List salarys;

	// salarys���Ե�setter��getter����
	public void setSalarys(List salarys) {
		this.salarys = salarys;
	}

	public List getSalarys() {
		return this.salarys;
	}

	// �����û�����ķ���
	public String execute() throws Exception {
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		// ��ȡHttpSession�е�user����
		String user = (String) ctx.getSession().get(WebConstant.USER);
		List<PaymentBean> salarys = empService.empSalary(user);
		setSalarys(salarys);
		return SUCCESS;
	}
}