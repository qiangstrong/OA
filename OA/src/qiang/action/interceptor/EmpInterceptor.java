package qiang.action.interceptor;

import qiang.utility.WebConstant;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class EmpInterceptor extends AbstractInterceptor {
	public String intercept(ActionInvocation invocation) throws Exception {
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		// ��ȡHttpSession�е�level����
		String level = (String) ctx.getSession().get(WebConstant.LEVEL);
		// ���level��Ϊnull����levelΪemp��mgr
		if (level != null
				&& (level.equals(WebConstant.EMP_LEVEL) || level.equals(WebConstant.MGR_LEVEL))) {
			return invocation.invoke();
		} else {
			return Action.LOGIN;
		}
	}
}