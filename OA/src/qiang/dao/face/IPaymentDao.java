package qiang.dao.face;

import java.sql.Date;
import java.util.*;

import qiang.domain.*;

public interface IPaymentDao {
	/**
	 * 根据标识属性来加载Payment实例
	 * @param id 需要加载的Payment实例的标识属性值
	 * @return 指定标识属性对应的Payment实例
	 */
	Payment get(Integer id);

	/**
	 * 持久化指定的Payment实例
	 * @param payment 需要被持久化的Payment实例
	 * @return Payment实例被持久化后的标识属性值
	 */
	Integer save(Payment payment);

	/**
	 * 修改指定的Payment实例
	 * @param payment 需要被修改的Payment实例
	 */
	void update(Payment payment);

	/**
	 * 删除指定的Payment实例
	 * @param payment 需要被删除的Payment实例
	 */
	void delete(Payment payment);

	/**
	 * 根据标识属性删除Payment实例
	 * @param id 需要被删除的Payment实例的标识属性值
	 */
	void delete(Integer id);

	/**
	 * 删除指定时间段内的数据
	 * @param firstDate 起始日期
	 * @param lastDate 截止日期
	 */
	void delete(Date firstDate, Date lastDate);

	/**
	 * 查询全部的Payment实例
	 * @return 数据库中全部的Payment实例
	 */
	List<Payment> findAll();

	/**
	 * 根据员工查询月结薪水
	 * @return 该员工对应的月结薪水集合
	 */
	List<Payment> findByEmp(Employee emp);

	/**
	 * 根据员工和发薪月份来查询月结薪水
	 * @param payMonth 发薪月份
	 * @param emp 领薪的员工
	 * @return 指定员工、指定月份的月结薪水
	 */
	Payment findByMonthAndEmp(Calendar payMonth, Employee emp);
}
