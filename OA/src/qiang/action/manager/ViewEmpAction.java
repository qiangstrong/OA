package qiang.action.manager;

import java.util.List;

import qiang.action.base.BaseMgrAction;
import qiang.bean.PageBean;
import qiang.utility.WebConstant;

import com.opensymphony.xwork2.ActionContext;

public class ViewEmpAction extends BaseMgrAction {
	// ��װ��ǰ��������Ա����List
	private List emps;
	// ���ŵ�Ա����
	private long empNum;
	// ���ݷ�ҳ��ʾ������
	private PageBean pageBean;
	private String tip;

	// emps���Ե�setter��getter����
	public void setEmps(List emps) {
		this.emps = emps;
	}

	public List getEmps() {
		return this.emps;
	}

	public long getEmpNum() {
		return empNum;
	}

	public void setEmpNum(long empNum) {
		this.empNum = empNum;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String execute() throws Exception {
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		// ��ȡHttpSession�е�user����
		String mgrName = (String) ctx.getSession().get(WebConstant.USER);
		// ��ѯԱ����
		setEmpNum(mgrService.countEmpByMgr(mgrName));
		// ��session��ȡ����ǰҳ��
		Integer pageNo = (Integer) ctx.getSession().get(WebConstant.EMP_PAGENO);
		if (pageNo == null)
			pageNo = 1;
		// ��һҳ����
		if (pageBean.getType() == WebConstant.PREV) {
			pageNo--;
			if (pageNo < 1) {
				pageNo = 1;
			}
		} else if (pageBean.getType() == WebConstant.CUR) {	// ��ת��ָ����ҳ��
			int tempPageNo = pageBean.getPageNo();
			// ��ָ����ҳ�ţ�����ת��ָ��ҳ�ţ���û��ָ��ҳ�ţ���ʹ��session�е�ҳ��
			if (tempPageNo != 0) {
				pageNo = tempPageNo;
			}
		} else {		// ��һҳ����
			pageNo++;
		}
		// ����session�е�ҳ��
		ctx.getSession().put(WebConstant.EMP_PAGENO, pageNo);
		setEmps(mgrService.getEmpsByMgr(mgrName, pageNo));

		// ��session��ȡ������action��tip
		String tempTip = (String) ctx.getSession().get(WebConstant.EMP_TIP);
		if (tempTip != null) {
			ctx.getSession().put(WebConstant.EMP_TIP, null);
			setTip(tempTip);
		}
		return SUCCESS;
	}
}