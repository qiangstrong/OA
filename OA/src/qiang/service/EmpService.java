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
	 * �Ծ����������֤��¼
	 * @param mgr ��¼�ľ������
	 * @return ��¼������ȷ��:0Ϊ��¼ʧ�ܣ�1Ϊ��¼emp 2Ϊ��¼mgr
	 */
	public int validLogin(Manager mgr) {
		// ����ҵ�һ�������Ծ����¼
		if (mgrDao.findByNameAndPass(mgr).size() >= 1) {
			return LOGIN_MGR;
		}
		// ����ҵ���ͨԱ��������ͨԱ����¼
		else if (empDao.findByNameAndPass(mgr).size() >= 1) {
			return LOGIN_EMP;
		} else {
			return LOGIN_FAIL;
		}
	}

	/**
	 * ��֤ĳ��Ա���Ƿ�ɴ�
	 * @param user Ա����
	 * @param dutyDay ����
	 * @return �ɴ򿨵����
	 */
	public int validPunch(String user, Date dutyDay) {
		// ���ܲ��ҵ���Ӧ�û��������޷���
		Employee emp = empDao.findByName(user);
		if (emp == null) {
			return NO_PUNCH;
		}
		// �ҵ�Ա����ǰ�ĳ��ڼ�¼
		List<Attend> attends = attendDao.findByEmpAndDutyDay(emp, dutyDay);
		// ϵͳû��Ϊ�û��ڵ������մ򿨼�¼���޷���
		if (attends == null || attends.size() <= 0) {
			return NO_PUNCH;
		} else if (attends.size() == 1 && attends.get(0).getPunchTime() == null) {
			if(attends.get(0).getIsCome()){
				return COME_PUNCH;		// ��ʼ�ϰ��
			}else{
				return LEAVE_PUNCH;		//�����������ڷ��������ϣ��ϰ��Զ���û�н��С�
			}
		} else if (attends.size() == 2 && attends.get(1).getPunchTime() == null) {
			return LEAVE_PUNCH;		// �����°��
		}
		return NO_PUNCH;
	}

	/**
	 * ��
	 * @param user Ա����
	 * @param dutyDay ������
	 * @param isCome �Ƿ����ϰ��
	 * @return �򿨽��
	 */
	public int punch(String user, Date dutyDay, boolean isCome) {
		Employee emp = empDao.findByName(user);
		if (emp == null) {
			return PUNCH_FAIL;
		}
		// �ҵ�Ա�����δ򿨶�Ӧ�ĳ��ڼ�¼
		Attend attend = attendDao.findByEmpAndDutyDayAndCome(emp, dutyDay, isCome);
		if (attend == null) {
			return PUNCH_FAIL;
		}
		// �Ѿ���
		if (attend.getPunchTime() != null) {
			return PUNCHED;
		}
		// ��ȡ��ʱ��
		int punchHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		attend.setPunchTime(new Time(System.currentTimeMillis()));
		// �ϰ��
		if (isCome) {
			// 9��֮ǰ������
			if (punchHour < COME_LIMIT) {
				attend.setType(typeDao.get(1));
			}
			// 9��11��֮����ٵ�
			else if (punchHour < LATE_LIMIT) {
				attend.setType(typeDao.get(4));
			}
			// 11��֮�������,�������
		}
		// �°��
		else {
			// 18��֮��������
			if (punchHour > LEAVE_LIMIT) {
				attend.setType(typeDao.get(1));
			}
			// 16~18��֮��������
			else if (punchHour < EARLY_LIMIT) {
				attend.setType(typeDao.get(5));
			}
		}
		attendDao.update(attend);
		return PUNCH_SUCC;
	}

	/**
	 * ����Ա������Լ��Ĺ���
	 * @param empName Ա����
	 * @return ��Ա���Ĺ����б�
	 */
	public List<PaymentBean> empSalary(String empName) {
		// ��ȡ��ǰԱ��
		Employee emp = empDao.findByName(empName);
		// ��ȡ��Ա����ȫ�������б�
		List<Payment> pays = payDao.findByEmp(emp);
		List<PaymentBean> result = new ArrayList<PaymentBean>();
		// ��װVO����
		for (Payment p : pays) {
			result.add(new PaymentBean(p.getPayMonth(), p.getAmount()));
		}
		return result;
	}

	/**
	 * Ա���鿴�Լ�����������������
	 * @param empName Ա����
	 * @return ��Ա�����������ķ�������
	 */
	public List<AttendBean> unAttend(String empName) {
		// �ҳ������ϰ�
		AttendType type = typeDao.get(1);
		Employee emp = empDao.findByName(empName);
		// �ҳ��������ϰ�ĳ��ڼ�¼
		List<Attend> attends = attendDao.findByEmpUnAttend(emp, type);
		List<AttendBean> result = new ArrayList<AttendBean>();
		// ��װVO����
		for (Attend att : attends) {
			result.add(new AttendBean(att.getId(), att.getDutyDay(), att.getType().getName(), att
					.getPunchTime()));
		}
		return result;
	}

	/**
	 * ����ȫ���ĳ������
	 * @return ȫ���ĳ������
	 */
	public List<AttendType> getAllType() {
		return typeDao.findAll();
	}

	/**
	 * �������
	 * @param attId ����ĳ���ID
	 * @param typeId ���������ID
	 * @param reason ���������
	 * @return ��ӵĽ��
	 */
	public boolean addApplication(int attId, int typeId, String reason) {
		// ����һ������
		Application app = new Application();
		// ��ȡ������Ҫ�ı�ĳ��ڼ�¼
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
			throw new OAException("�޸������ҵ���쳣");
		}
		emp.setPass(pass);
		empDao.update(emp);
	}

	@Override
	public List<TaskBean> getTasks(String empName) throws OAException {
		Employee emp = empDao.findByName(empName);
		if (emp == null) {
			throw new OAException("�鿴�����ҵ���쳣");
		}
		List<Task> tasks = taskDao.findByMgr(emp.getManager());
		// û������
		if (tasks == null) {
			throw new OAException("���Ĳ���û��Ա��");
		}
		// ��װVO��
		List<TaskBean> result = new ArrayList<TaskBean>();
		for (Task t : tasks) {
			result.add(new TaskBean(t.getName(), t.isFinish(), t.getDatetime(), t.getDetail()));
		}
		return result;
	}
}