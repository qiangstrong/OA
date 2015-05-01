package qiang.action.base;

import qiang.service.face.IEmpService;

import com.opensymphony.xwork2.ActionSupport;

public class BaseEmpAction extends ActionSupport {
	// 依赖的业务逻辑组件
	protected IEmpService empService;

	// 依赖注入业务逻辑组件所必须的setter方法
	public void setEmpService(IEmpService empService) {
		this.empService = empService;
	}
}