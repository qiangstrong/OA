package qiang.action.manager;

import qiang.action.base.BaseMgrAction;
import qiang.domain.Employee;

public class ShowEmpAction extends BaseMgrAction{
	
	private String empName;
	private Employee emp;
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Employee getEmp() {
		return emp;
	}
	
	@Override
	public String execute() throws Exception {
		emp=mgrService.queryEmp(empName);
		return SUCCESS;
	}
}
