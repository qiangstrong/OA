package qiang.action.base;

import qiang.service.face.IEmpService;

import com.opensymphony.xwork2.ActionSupport;

public class BaseEmpAction extends ActionSupport {
	// ������ҵ���߼����
	protected IEmpService empService;

	// ����ע��ҵ���߼�����������setter����
	public void setEmpService(IEmpService empService) {
		this.empService = empService;
	}
}