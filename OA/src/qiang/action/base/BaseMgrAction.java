package qiang.action.base;

import qiang.service.face.IMgrService;

import com.opensymphony.xwork2.ActionSupport;

public class BaseMgrAction extends ActionSupport {
	protected IMgrService mgrService;

	public void setMgrService(IMgrService mgrService) {
		this.mgrService = mgrService;
	}
}