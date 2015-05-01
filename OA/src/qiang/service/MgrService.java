package qiang.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import qiang.bean.AppBean;
import qiang.bean.EmpBean;
import qiang.bean.SalaryBean;
import qiang.bean.TaskBean;
import qiang.domain.Application;
import qiang.domain.Attend;
import qiang.domain.CheckBack;
import qiang.domain.Employee;
import qiang.domain.Manager;
import qiang.domain.Payment;
import qiang.domain.Task;
import qiang.exception.OAException;
import qiang.service.base.BaseService;
import qiang.service.face.IMgrService;

public class MgrService extends BaseService implements IMgrService {

	public long countEmpByMgr(String mgrName) throws OAException {
		Manager mgr = mgrDao.findByName(mgrName);
		if (mgr == null) {
			throw new OAException("查询员工数的业务异常");
		}
		return empDao.countByMgr(mgr);
	}

	public boolean addEmp(Employee emp, String mgrName) throws OAException {
		Manager mgr = mgrDao.findByName(mgrName);
		if (mgr == null) {
			throw new OAException("新增员工的业务异常");
		}
		emp.setManager(mgr);
		if (empDao.findByName(emp.getName()) != null) {
			return false;
		}
		empDao.save(emp);
		return true;
	}

	public void delEmp(String empName) throws OAException {
		Employee emp = empDao.findByName(empName);
		if (emp == null) {
			throw new OAException("删除员工的业务异常");
		}
		empDao.delete(emp);
	}

	public boolean changeEmp(String oldName, Employee newEmp) throws OAException {
		Employee oldEmp = empDao.findByName(oldName);
		if (oldEmp == null) {
			throw new OAException("更改员工信息的业务异常");
		}
		Employee emp = empDao.findByName(newEmp.getName());
		//如果重名，则修改失败
		if (emp != null && oldEmp.getId() != emp.getId()) {
			return false;
		}
		oldEmp.setName(newEmp.getName());
		oldEmp.setPass(newEmp.getPass());
		oldEmp.setSalary(newEmp.getSalary());
		empDao.update(oldEmp);
		return true;
	}

	public Employee queryEmp(String empName) throws OAException {
		Employee emp = empDao.findByName(empName);
		if (emp == null) {
			throw new OAException("查询员工信息的业务异常");
		}
		return emp;
	}

	public long countTaskByMgr(String mgrName) throws OAException {
		Manager mgr = mgrDao.findByName(mgrName);
		if (mgr == null) {
			throw new OAException("查询任务数的业务异常");
		}
		return taskDao.countByMgr(mgr);
	}

	@Override
	public boolean addTask(Task task, String mgrName) throws OAException {
		Manager mgr = mgrDao.findByName(mgrName);
		if (mgr == null) {
			throw new OAException("新增任务的业务异常");
		}		
		if (taskDao.findByName(task.getName()) != null) {
			return false;
		}
		task.setManager(mgr);
		task.setDatetime(new Date());
		taskDao.save(task);
		return true;
	}

	@Override
	public void delTask(String taskName) throws OAException {
		Task task = taskDao.findByName(taskName);
		if (task == null) {
			throw new OAException("删除员工的业务异常");
		}
		taskDao.delete(task);
	}

	@Override
	public boolean changeTask(String oldName, Task newTask) throws OAException {
		Task oldTask = taskDao.findByName(oldName);
		if (oldTask == null) {
			throw new OAException("更改员工信息的业务异常");
		}
		Task task = taskDao.findByName(newTask.getName());
		if (task != null && oldTask.getId() != task.getId()) {
			return false;
		}
		oldTask.setName(newTask.getName());
		oldTask.setFinish(newTask.isFinish());
		oldTask.setDetail(newTask.getDetail());
		taskDao.update(oldTask);
		return true;
	}

	@Override
	public Task queryTask(String taskName) throws OAException {
		Task task = taskDao.findByName(taskName);
		if (task == null) {
			throw new OAException("查询员工信息的业务异常");
		}
		return task;
	}

	/**
	 * 根据经理返回所有的部门上个月工资
	 * @param mgrName 新增的员工名
	 * @return 部门上个月工资
	 */
	public List<SalaryBean> getSalaryByMgr(String mgrName) throws OAException {
		Manager mgr = mgrDao.findByName(mgrName);
		if (mgr == null) {
			throw new OAException("您是经理吗？或你还未登录？");
		}
		// 查询该经理对应的全部员工
		List<Employee> emps = empDao.findByMgr(mgr);
		// 部门依然没有员工
		if (emps == null || emps.size() < 1) {
			throw new OAException("您的部门没有员工");
		}
		Calendar payMonth = Calendar.getInstance();
		payMonth.add(Calendar.MONTH, -1);
		List<SalaryBean> result = new ArrayList<SalaryBean>();
		// 遍历本部门每个员工
		for (Employee e : emps) {
			Payment p = payDao.findByMonthAndEmp(payMonth, e);
			if (p != null) {
				result.add(new SalaryBean(e.getName(), p.getAmount()));
			}
		}
		return result;

	}

	/**
	 * 根据经理返回该部门的全部员工
	 * @param mgrName 经理名
	 * @return 经理的全部下属
	 */
	public List<EmpBean> getEmpsByMgr(String mgrName) throws OAException {
		Manager mgr = mgrDao.findByName(mgrName);
		if (mgr == null) {
			throw new OAException("您是经理吗？或你还未登录？");
		}
		// 查询该经理对应的全部员工
		List<Employee> emps = empDao.findByMgr(mgr);
		// 部门依然没有员工
		if (emps == null) {
			throw new OAException("您的部门没有员工");
		}
		// 封装VO集
		List<EmpBean> result = new ArrayList<EmpBean>();
		for (Employee e : emps) {
			result.add(new EmpBean(e.getName(), e.getPass(), e.getSalary()));
		}
		return result;
	}

	public List<EmpBean> getEmpsByMgr(String mgrName, int pageNo) throws OAException {
		Manager mgr = mgrDao.findByName(mgrName);
		if (mgr == null) {
			throw new OAException("您是经理吗？或你还未登录？");
		}
		// 查询该经理对应的全部员工
		List<Employee> emps = empDao.findByMgr(mgr, pageNo);
		// 部门依然没有员工
		if (emps == null) {
			throw new OAException("您的部门没有员工");
		}
		// 封装VO集
		List<EmpBean> result = new ArrayList<EmpBean>();
		for (Employee e : emps) {
			result.add(new EmpBean(e.getName(), e.getPass(), e.getSalary()));
		}
		return result;
	}

	@Override
	public List<TaskBean> getTasksByMgr(String mgrName) throws OAException {
		Manager mgr = mgrDao.findByName(mgrName);
		if (mgr == null) {
			throw new OAException("您是经理吗？或你还未登录？");
		}
		// 查询该经理对应的全部任务
		List<Task> tasks = taskDao.findByMgr(mgr);
		// 部门依然没有任务
		if (tasks == null) {
			throw new OAException("您的部门没有员工");
		}
		// 封装VO集
		List<TaskBean> result = new ArrayList<TaskBean>();
		for (Task t : tasks) {
			result.add(new TaskBean(t.getName(), t.isFinish(),t.getDatetime(),t.getDetail()));
		}
		return result;
	}

	@Override
	public List<TaskBean> getTasksByMgr(String mgrName, int pageNo) throws OAException {
		Manager mgr = mgrDao.findByName(mgrName);
		if (mgr == null) {
			throw new OAException("您是经理吗？或你还未登录？");
		}
		// 查询该经理对应的全部任务
		List<Task> tasks = taskDao.findByMgr(mgr,pageNo);
		// 部门依然没有任务
		if (tasks == null) {
			throw new OAException("您的部门没有员工");
		}
		// 封装VO集
		List<TaskBean> result = new ArrayList<TaskBean>();
		for (Task t : tasks) {
			result.add(new TaskBean(t.getName(), t.isFinish(),t.getDatetime(),t.getDetail()));
		}
		return result;
	}
	
	/**
	 * 根据经理返回该部门的没有批复的申请
	 * @param mgrName 经理名
	 * @return 该部门的全部申请
	 */
	public List<AppBean> getAppsByMgr(String mgrName) throws OAException {
		Manager mgr = mgrDao.findByName(mgrName);
		if (mgr == null) {
			throw new OAException("您是经理吗？或你还未登录？");
		}
		// 查询该经理对应的全部员工
		List<Employee> emps = empDao.findByMgr(mgr);
		// 部门依然没有员工
		if (emps == null || emps.size() < 1) {
			throw new OAException("您的部门没有员工");
		}
		// 封装VO集
		List<AppBean> result = new ArrayList<AppBean>();
		for (Employee e : emps) {
			// 查看该员工的全部申请
			List<Application> apps = appDao.findByEmp(e);
			if (apps != null && apps.size() > 0) {
				for (Application app : apps) {
					// 只选择还未处理的申请
					if (app.getResult() == false) {
						Attend attend = app.getAttend();
						result.add(new AppBean(app.getId(), e.getName(),
								attend.getType().getName(), app.getType().getName(), app
										.getReason()));
					}
				}
			}
		}
		return result;
	}

	/**
	 * 处理申请
	 * @param appid 申请ID
	 * @param mgrName 经理名字
	 * @param result 是否通过
	 */
	public void check(int appid, String mgrName, boolean result) {
		Application app = appDao.get(appid);
		Manager mgr = mgrDao.findByName(mgrName);
		CheckBack check = new CheckBack();
		check.setApp(app);
		check.setManager(mgr);
		// 同意通过申请
		if (result) {
			// 设置通过申请
			check.setResult(true);
			// 修改申请为已经批复
			app.setResult(true);
			appDao.save(app);
			// 为真时，还需要修改出勤的类型
			Attend attend = app.getAttend();
			attend.setType(app.getType());
			attendDao.update(attend);
		} else {
			// 没有通过申请
			check.setResult(false);
			app.setResult(true);
			appDao.save(app);
		}
		// 保存申请批复
		checkDao.save(check);
	}	
}
