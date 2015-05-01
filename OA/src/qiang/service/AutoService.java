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
		System.out.println("自动插入旷工记录");
		List<Employee> emps = empDao.findAll();
		// 获取当前时间
		Date dutyDay = new Date(System.currentTimeMillis());
		for (Employee e : emps) {
			// 获取旷工对应的出勤类型
			AttendType atype = typeDao.get(6);
			Attend a = new Attend();
			a.setDutyDay(dutyDay);
			a.setType(atype);
			// 如果当前时间是是早上，对应于上班打卡
			if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) < AM_LIMIT) {
				// 上班打卡
				a.setIsCome(true);
			} else {
				// 下班打卡
				a.setIsCome(false);
			}
			a.setEmployee(e);
			attendDao.save(a);
		}
	}

	@Override
	public void autoPay() {
		System.out.println("自动插入工资结算");
		List<Employee> emps = empDao.findAll();
		// 获取上个月时间
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -15);
		c.set(Calendar.DAY_OF_MONTH, 1);
		Date payMonth = new Date(c.getTimeInMillis());
		// 为每个员工计算上个月工资
		for (Employee e : emps) {
			Payment pay = new Payment();
			// 获取该员工的工资
			double amount = e.getSalary();
			// 获取该员工上个月的出勤记录
			List<Attend> attends = attendDao.findByEmp(e);
			// 用工资累积其出勤记录的工资
			for (Attend a : attends) {
				amount += a.getType().getAmerce();
			}
			// 添加工资结算
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
	 * 获取指定年份第一天的日期
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
	 * 获取指定年份最后一天的日期
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
