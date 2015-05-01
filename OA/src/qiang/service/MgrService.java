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
			throw new OAException("��ѯԱ������ҵ���쳣");
		}
		return empDao.countByMgr(mgr);
	}

	public boolean addEmp(Employee emp, String mgrName) throws OAException {
		Manager mgr = mgrDao.findByName(mgrName);
		if (mgr == null) {
			throw new OAException("����Ա����ҵ���쳣");
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
			throw new OAException("ɾ��Ա����ҵ���쳣");
		}
		empDao.delete(emp);
	}

	public boolean changeEmp(String oldName, Employee newEmp) throws OAException {
		Employee oldEmp = empDao.findByName(oldName);
		if (oldEmp == null) {
			throw new OAException("����Ա����Ϣ��ҵ���쳣");
		}
		Employee emp = empDao.findByName(newEmp.getName());
		//������������޸�ʧ��
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
			throw new OAException("��ѯԱ����Ϣ��ҵ���쳣");
		}
		return emp;
	}

	public long countTaskByMgr(String mgrName) throws OAException {
		Manager mgr = mgrDao.findByName(mgrName);
		if (mgr == null) {
			throw new OAException("��ѯ��������ҵ���쳣");
		}
		return taskDao.countByMgr(mgr);
	}

	@Override
	public boolean addTask(Task task, String mgrName) throws OAException {
		Manager mgr = mgrDao.findByName(mgrName);
		if (mgr == null) {
			throw new OAException("���������ҵ���쳣");
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
			throw new OAException("ɾ��Ա����ҵ���쳣");
		}
		taskDao.delete(task);
	}

	@Override
	public boolean changeTask(String oldName, Task newTask) throws OAException {
		Task oldTask = taskDao.findByName(oldName);
		if (oldTask == null) {
			throw new OAException("����Ա����Ϣ��ҵ���쳣");
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
			throw new OAException("��ѯԱ����Ϣ��ҵ���쳣");
		}
		return task;
	}

	/**
	 * ���ݾ��������еĲ����ϸ��¹���
	 * @param mgrName ������Ա����
	 * @return �����ϸ��¹���
	 */
	public List<SalaryBean> getSalaryByMgr(String mgrName) throws OAException {
		Manager mgr = mgrDao.findByName(mgrName);
		if (mgr == null) {
			throw new OAException("���Ǿ����𣿻��㻹δ��¼��");
		}
		// ��ѯ�þ����Ӧ��ȫ��Ա��
		List<Employee> emps = empDao.findByMgr(mgr);
		// ������Ȼû��Ա��
		if (emps == null || emps.size() < 1) {
			throw new OAException("���Ĳ���û��Ա��");
		}
		Calendar payMonth = Calendar.getInstance();
		payMonth.add(Calendar.MONTH, -1);
		List<SalaryBean> result = new ArrayList<SalaryBean>();
		// ����������ÿ��Ա��
		for (Employee e : emps) {
			Payment p = payDao.findByMonthAndEmp(payMonth, e);
			if (p != null) {
				result.add(new SalaryBean(e.getName(), p.getAmount()));
			}
		}
		return result;

	}

	/**
	 * ���ݾ����ظò��ŵ�ȫ��Ա��
	 * @param mgrName ������
	 * @return �����ȫ������
	 */
	public List<EmpBean> getEmpsByMgr(String mgrName) throws OAException {
		Manager mgr = mgrDao.findByName(mgrName);
		if (mgr == null) {
			throw new OAException("���Ǿ����𣿻��㻹δ��¼��");
		}
		// ��ѯ�þ����Ӧ��ȫ��Ա��
		List<Employee> emps = empDao.findByMgr(mgr);
		// ������Ȼû��Ա��
		if (emps == null) {
			throw new OAException("���Ĳ���û��Ա��");
		}
		// ��װVO��
		List<EmpBean> result = new ArrayList<EmpBean>();
		for (Employee e : emps) {
			result.add(new EmpBean(e.getName(), e.getPass(), e.getSalary()));
		}
		return result;
	}

	public List<EmpBean> getEmpsByMgr(String mgrName, int pageNo) throws OAException {
		Manager mgr = mgrDao.findByName(mgrName);
		if (mgr == null) {
			throw new OAException("���Ǿ����𣿻��㻹δ��¼��");
		}
		// ��ѯ�þ����Ӧ��ȫ��Ա��
		List<Employee> emps = empDao.findByMgr(mgr, pageNo);
		// ������Ȼû��Ա��
		if (emps == null) {
			throw new OAException("���Ĳ���û��Ա��");
		}
		// ��װVO��
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
			throw new OAException("���Ǿ����𣿻��㻹δ��¼��");
		}
		// ��ѯ�þ����Ӧ��ȫ������
		List<Task> tasks = taskDao.findByMgr(mgr);
		// ������Ȼû������
		if (tasks == null) {
			throw new OAException("���Ĳ���û��Ա��");
		}
		// ��װVO��
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
			throw new OAException("���Ǿ����𣿻��㻹δ��¼��");
		}
		// ��ѯ�þ����Ӧ��ȫ������
		List<Task> tasks = taskDao.findByMgr(mgr,pageNo);
		// ������Ȼû������
		if (tasks == null) {
			throw new OAException("���Ĳ���û��Ա��");
		}
		// ��װVO��
		List<TaskBean> result = new ArrayList<TaskBean>();
		for (Task t : tasks) {
			result.add(new TaskBean(t.getName(), t.isFinish(),t.getDatetime(),t.getDetail()));
		}
		return result;
	}
	
	/**
	 * ���ݾ����ظò��ŵ�û������������
	 * @param mgrName ������
	 * @return �ò��ŵ�ȫ������
	 */
	public List<AppBean> getAppsByMgr(String mgrName) throws OAException {
		Manager mgr = mgrDao.findByName(mgrName);
		if (mgr == null) {
			throw new OAException("���Ǿ����𣿻��㻹δ��¼��");
		}
		// ��ѯ�þ����Ӧ��ȫ��Ա��
		List<Employee> emps = empDao.findByMgr(mgr);
		// ������Ȼû��Ա��
		if (emps == null || emps.size() < 1) {
			throw new OAException("���Ĳ���û��Ա��");
		}
		// ��װVO��
		List<AppBean> result = new ArrayList<AppBean>();
		for (Employee e : emps) {
			// �鿴��Ա����ȫ������
			List<Application> apps = appDao.findByEmp(e);
			if (apps != null && apps.size() > 0) {
				for (Application app : apps) {
					// ֻѡ��δ���������
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
	 * ��������
	 * @param appid ����ID
	 * @param mgrName ��������
	 * @param result �Ƿ�ͨ��
	 */
	public void check(int appid, String mgrName, boolean result) {
		Application app = appDao.get(appid);
		Manager mgr = mgrDao.findByName(mgrName);
		CheckBack check = new CheckBack();
		check.setApp(app);
		check.setManager(mgr);
		// ͬ��ͨ������
		if (result) {
			// ����ͨ������
			check.setResult(true);
			// �޸�����Ϊ�Ѿ�����
			app.setResult(true);
			appDao.save(app);
			// Ϊ��ʱ������Ҫ�޸ĳ��ڵ�����
			Attend attend = app.getAttend();
			attend.setType(app.getType());
			attendDao.update(attend);
		} else {
			// û��ͨ������
			check.setResult(false);
			app.setResult(true);
			appDao.save(app);
		}
		// ������������
		checkDao.save(check);
	}	
}
