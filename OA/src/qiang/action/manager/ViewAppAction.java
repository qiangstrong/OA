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

	// apps���Ե�setter��getter����
	public void setApps(List apps) {
		this.apps = apps;
	}

	public List getApps() {
		return this.apps;
	}

	public String execute() throws Exception {
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		// ��ȡHttpSession�е�user����
		String mgrName = (String) ctx.getSession().get(WebConstant.USER);
		// ��ȡ��Ҫ����ǰ�������ȫ������
		setApps(mgrService.getAppsByMgr(mgrName));
		return SUCCESS;
	}
}