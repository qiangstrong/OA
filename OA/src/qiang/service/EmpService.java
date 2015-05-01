package qiang.service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import qiang.bean.AttendBean;
import qiang.bean.PaymentBean;
import qiang.bean.TaskBean;
import qiang.domain.Application;
import qiang.domain.Attend;
import qiang.domain.AttendType;
import qiang.domain.Employee;
import qiang.domain.Manager;
import qiang.domain.Payment;
import qiang.domain.Task;
import qiang.exception.OAException;
import qiang.service.base.BaseService;
import qiang.service.face.IEmpService;

public class EmpService extends BaseService implements IEmpService {

	/**
	 * 以经理身份来验证登录
	 * @param mgr 登录的经理身份
	 * @return 登录后的身份确认:0为登录失败，1为登录emp 2为登录mgr
	 */
	public int validLogin(Manager mgr) {
		// 如果找到一个经理，以经理登录
		if (mgrDao.findByNameAndPass(mgr).size() >= 1) {
			return LOGIN_MGR;
		}
		// 如果找到普通员工，以普通员工登录
		else if (empDao.findByNameAndPass(mgr).size() >= 1) {
			return LOGIN_EMP;
		} else {
			return LOGIN_FAIL;
		}
	}

	/**
	 * 验证某个员工是否可打卡
	 * @param user 员工名
	 * @param dutyDay 日期
	 * @return 可打卡的类别
	 */
	public int validPunch(String user, Date dutyDay) {
		// 不能查找到对应用户，返回无法打卡
		Employee emp = empDao.findByName(user);
		if (emp == null) {
			return NO_PUNCH;
		}
		// 找到员工当前的出勤记录
		List<Attend> attends = attendDao.findByEmpAndDutyDay(emp, dutyDay);
		// 系统没有为用户在当天插入空打卡记录，无法打卡
		if (attends == null || attends.size() <= 0) {
			return NO_PUNCH;
		} else if (attends.size() == 1 && attends.get(0).getPunchTime() == null) {
			if(attends.get(0).getIsCome()){
				return COME_PUNCH;		// 开始上班打卡
			}else{
				return LEAVE_PUNCH;		//可能上午由于服务器故障，上班自动打卡没有进行。
			}
		} else if (attends.size() == 2 && attends.get(1).getPunchTime() == null) {
			return LEAVE_PUNCH;		// 可以下班打卡
		}
		return NO_PUNCH;
	}

	/**
	 * 打卡
	 * @param user 员工名
	 * @param dutyDay 打卡日期
	 * @param isCome 是否是上班打卡
	 * @return 打卡结果
	 */
	public int punch(String user, Date dutyDay, boolean isCome) {
		Employee emp = empDao.findByName(user);
		if (emp == null) {
			return PUNCH_FAIL;
		}
		// 找到员工本次打卡对应的出勤记录
		Attend attend = attendDao.findByEmpAndDutyDayAndCome(emp, dutyDay, isCome);
		if (attend == null) {
			return PUNCH_FAIL;
		}
		// 已经打卡
		if (attend.getPunchTime() != null) {
			return PUNCHED;
		}
		// 获取打卡时间
		int punchHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		attend.setPunchTime(new Time(System.currentTimeMillis()));
		// 上班打卡
		if (isCome) {
			// 9点之前算正常
			if (punchHour < COME_LIMIT) {
				attend.setType(typeDao.get(1));
			}
			// 9～11点之间算迟到
			else if (punchHour < LATE_LIMIT) {
				attend.setType(typeDao.get(4));
			}
			// 11点之后算旷工,无需理会
		}
		// 下班打卡
		else {
			// 18点之后算正常
			if (punchHour > LEAVE_LIMIT) {
				attend.setType(typeDao.get(1));
			}
			// 16~18点之间算早退
			else if (punchHour < EARLY_LIMIT) {
				attend.setType(typeDao.get(5));
			}
		}
		attendDao.update(attend);
		return PUNCH_SUCC;
	}

	/**
	 * 根据员工浏览自己的工资
	 * @param empName 员工名
	 * @return 该员工的工资列表
	 */
	public List<PaymentBean> empSalary(String empName) {
		// 获取当前员工
		Employee emp = empDao.findByName(empName);
		// 获取该员工的全部工资列表
		List<Payment> pays = payDao.findByEmp(emp);
		List<PaymentBean> result = new ArrayList<PaymentBean>();
		// 封装VO集合
		for (Payment p : pays) {
			result.add(new PaymentBean(p.getPayMonth(), p.getAmount()));
		}
		return result;
	}

	/**
	 * 员工查看自己的最近三天非正常打卡
	 * @param empName 员工名
	 * @return 该员工的最近三天的非正常打卡
	 */
	public List<AttendBean> unAttend(String empName) {
		// 找出正常上班
		AttendType type = typeDao.get(1);
		Employee emp = empDao.findByName(empName);
		// 找出非正常上班的出勤记录
		List<Attend> attends = attendDao.findByEmpUnAttend(emp, type);
		List<AttendBean> result = new ArrayList<AttendBean>();
		// 封装VO集合
		for (Attend att : attends) {
			result.add(new AttendBean(att.getId(), att.getDutyDay(), att.getType().getName(), att
					.getPunchTime()));
		}
		return result;
	}

	/**
	 * 返回全部的出勤类别
	 * @return 全部的出勤类别
	 */
	public List<AttendType> getAllType() {
		return typeDao.findAll();
	}

	/**
	 * 添加申请
	 * @param attId 申请的出勤ID
	 * @param typeId 申请的类型ID
	 * @param reason 申请的理由
	 * @return 添加的结果
	 */
	public boolean addApplication(int attId, int typeId, String reason) {
		// 创建一个申请
		Application app = new Application();
		// 获取申请需要改变的出勤记录
		Attend attend = attendDao.get(attId);
		AttendType type = typeDao.get(typeId);
		app.setAttend(attend);
		app.setType(type);
		if (reason != null) {
			app.setReason(reason);
		}
		appDao.save(app);
		return true;
	}

	@Override
	public void changePass(String name, String pass) throws OAException {
		Employee emp = empDao.findByName(name);
		if (emp == null) {
			throw new OAException("修改密码的业务异常");
		}
		emp.setPass(pass);
		empDao.update(emp);
	}

	@Override
	public List<TaskBean> getTasks(String empName) throws OAException {
		Employee emp = empDao.findByName(empName);
		if (emp == null) {
			throw new OAException("查看任务的业务异常");
		}
		List<Task> tasks = taskDao.findByMgr(emp.getManager());
		// 没有任务
		if (tasks == null) {
			throw new OAException("您的部门没有员工");
		}
		// 封装VO集
		List<TaskBean> result = new ArrayList<TaskBean>();
		for (Task t : tasks) {
			result.add(new TaskBean(t.getName(), t.isFinish(), t.getDatetime(), t.getDetail()));
		}
		return result;
	}
}