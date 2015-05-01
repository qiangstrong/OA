package qiang.action.manager;

import qiang.action.base.BaseMgrAction;
import qiang.domain.Employee;

public class ChangeEmpAction extends BaseMgrAction{
	private String empName;
	private Employee emp;
	private String tip;
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	@Override
	public String execute() throws Exception {
		if (!mgrService.changeEmp(empName, emp)) {
			setTip("该员工与现有的员工重名。修改员工信息失败。");
			return INPUT;
		}
		return SUCCESS;
	}
	
}
