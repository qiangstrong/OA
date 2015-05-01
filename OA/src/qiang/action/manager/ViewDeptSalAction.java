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
	// ��װ��н�б��List����
	private List sals;

	// sals���Ե�setter��getter����
	public void setSals(List sals) {
		this.sals = sals;
	}

	public List getSals() {
		return this.sals;
	}

	public String execute() throws Exception {
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		// ��ȡHttpSession�е�user����
		String mgrName = (String) ctx.getSession().get(WebConstant.USER);
		// ����ҵ���߼�����ȡ�õ�ǰԱ����ȫ����н�б�
		List<SalaryBean> result = mgrService.getSalaryByMgr(mgrName);
		System.out.println("--------------" + result);
		setSals(result);
		return SUCCESS;
	}
}