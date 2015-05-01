package qiang.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import qiang.domain.Attend;
import qiang.domain.AttendType;
import qiang.domain.Employee;
import qiang.domain.Payment;
import qiang.service.base.BaseService;
import qiang.service.face.IAutoService;

public class AutoService extends BaseService implements IAutoService {

	@Override
	public void autoPunch() {
		System.out.println("�Զ����������¼");
		List<Employee> emps = empDao.findAll();
		// ��ȡ��ǰʱ��
		Date dutyDay = new Date(System.currentTimeMillis());
		for (Employee e : emps) {
			// ��ȡ������Ӧ�ĳ�������
			AttendType atype = typeDao.get(6);
			Attend a = new Attend();
			a.setDutyDay(dutyDay);
			a.setType(atype);
			// �����ǰʱ���������ϣ���Ӧ���ϰ��
			if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) < AM_LIMIT) {
				// �ϰ��
				a.setIsCome(true);
			} else {
				// �°��
				a.setIsCome(false);
			}
			a.setEmployee(e);
			attendDao.save(a);
		}
	}

	@Override
	public void autoPay() {
		System.out.println("�Զ����빤�ʽ���");
		List<Employee> emps = empDao.findAll();
		// ��ȡ�ϸ���ʱ��
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -15);
		c.set(Calendar.DAY_OF_MONTH, 1);
		Date payMonth = new Date(c.getTimeInMillis());
		// Ϊÿ��Ա�������ϸ��¹���
		for (Employee e : emps) {
			Payment pay = new Payment();
			// ��ȡ��Ա���Ĺ���
			double amount = e.getSalary();
			// ��ȡ��Ա���ϸ��µĳ��ڼ�¼
			List<Attend> attends = attendDao.findByEmp(e);
			// �ù����ۻ�����ڼ�¼�Ĺ���
			for (Attend a : attends) {
				amount += a.getType().getAmerce();
			}
			// ��ӹ��ʽ���
			pay.setPayMonth(payMonth);
			pay.setEmployee(e);
			pay.setAmount(amount);
			payDao.save(pay);
		}
	}

	@Override
	public void autoClear() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -1);
		Date firstDate = getFirstDay(calendar.get(calendar.YEAR));
		Date lastDate = getLastDay(calendar.get(calendar.YEAR));
		payDao.delete(firstDate, lastDate);
		attendDao.delete(firstDate, lastDate);
	}

	/**
	 * ��ȡָ����ݵ�һ�������
	 * @param year
	 * @return
	 */
	private Date getFirstDay(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		return new Date(calendar.getTimeInMillis());
	}

	/**
	 * ��ȡָ��������һ�������
	 * @param year
	 * @return
	 */
	private Date getLastDay(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.roll(Calendar.DAY_OF_YEAR, -1);
		return new Date(calendar.getTimeInMillis());
	}
}
