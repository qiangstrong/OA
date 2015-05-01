package qiang.dao;

import java.util.*;
import java.sql.Date;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import qiang.dao.base.*;
import qiang.dao.face.*;
import qiang.domain.*;

public class PaymentDao extends BaseDao implements IPaymentDao {
	/**
	 * 根据标识属性来加载Payment实例
	 * @param id 需要加载的Payment实例的标识属性值
	 * @return 指定标识属性对应的Payment实例
	 */
	public Payment get(Integer id) {
		return getHibernateTemplate().get(Payment.class, id);
	}

	/**
	 * 持久化指定的Payment实例
	 * @param payment 需要被持久化的Payment实例
	 * @return Payment实例被持久化后的标识属性值
	 */
	public Integer save(Payment payment) {
		return (Integer) getHibernateTemplate().save(payment);
	}

	/**
	 * 修改指定的Payment实例
	 * @param payment 需要被修改的Payment实例
	 */
	public void update(Payment payment) {
		getHibernateTemplate().update(payment);
	}

	/**
	 * 删除指定的Payment实例
	 * @param payment 需要被删除的Payment实例
	 */
	public void delete(Payment payment) {
		getHibernateTemplate().delete(payment);
	}

	/**
	 * 根据标识属性删除Payment实例
	 * @param id 需要被删除的Payment实例的标识属性值
	 */
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}

	public void delete(Date firstDate, Date lastDate) {
		Session session=getSession();
		String hqlString="delete from Payment as p where p.payMonth between ? and ?";
		Query query=session.createQuery(hqlString);
		query.setDate(0, firstDate);
		query.setDate(1, lastDate);
		query.executeUpdate();
	}

	/**
	 * 查询全部的Payment实例
	 * @return 数据库中全部的Payment实例
	 */
	public List<Payment> findAll() {
		return (List<Payment>) getHibernateTemplate().find("from Payment");
	}

	/**
	 * 根据员工查询月结薪水
	 * @return 该员工对应的月结薪水集合
	 */
	public List<Payment> findByEmp(Employee emp) {
		return (List<Payment>) getHibernateTemplate().find("from Payment as p where p.employee=?",
				emp);
	}

	/**
	 * 根据员工和发薪月份来查询月结薪水
	 * @param payMonth 发薪月份
	 * @param emp 领薪的员工
	 * @return 指定员工、指定月份的月结薪水
	 */
	public Payment findByMonthAndEmp(Calendar payMonth, Employee emp) {
		payMonth.set(Calendar.DAY_OF_MONTH, 1);
		Date date = new Date(payMonth.getTimeInMillis());
		List<Payment> pays = (List<Payment>) getHibernateTemplate()
				.find("from Payment as p where p.employee=? and p.payMonth=?",
						new Object[] { emp, date });
		if (pays != null && pays.size() > 0) {
			return pays.get(0);
		}
		return null;
	}
}
