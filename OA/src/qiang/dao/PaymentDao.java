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
	 * ���ݱ�ʶ����������Paymentʵ��
	 * @param id ��Ҫ���ص�Paymentʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��Paymentʵ��
	 */
	public Payment get(Integer id) {
		return getHibernateTemplate().get(Payment.class, id);
	}

	/**
	 * �־û�ָ����Paymentʵ��
	 * @param payment ��Ҫ���־û���Paymentʵ��
	 * @return Paymentʵ�����־û���ı�ʶ����ֵ
	 */
	public Integer save(Payment payment) {
		return (Integer) getHibernateTemplate().save(payment);
	}

	/**
	 * �޸�ָ����Paymentʵ��
	 * @param payment ��Ҫ���޸ĵ�Paymentʵ��
	 */
	public void update(Payment payment) {
		getHibernateTemplate().update(payment);
	}

	/**
	 * ɾ��ָ����Paymentʵ��
	 * @param payment ��Ҫ��ɾ����Paymentʵ��
	 */
	public void delete(Payment payment) {
		getHibernateTemplate().delete(payment);
	}

	/**
	 * ���ݱ�ʶ����ɾ��Paymentʵ��
	 * @param id ��Ҫ��ɾ����Paymentʵ���ı�ʶ����ֵ
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
	 * ��ѯȫ����Paymentʵ��
	 * @return ���ݿ���ȫ����Paymentʵ��
	 */
	public List<Payment> findAll() {
		return (List<Payment>) getHibernateTemplate().find("from Payment");
	}

	/**
	 * ����Ա����ѯ�½�нˮ
	 * @return ��Ա����Ӧ���½�нˮ����
	 */
	public List<Payment> findByEmp(Employee emp) {
		return (List<Payment>) getHibernateTemplate().find("from Payment as p where p.employee=?",
				emp);
	}

	/**
	 * ����Ա���ͷ�н�·�����ѯ�½�нˮ
	 * @param payMonth ��н�·�
	 * @param emp ��н��Ա��
	 * @return ָ��Ա����ָ���·ݵ��½�нˮ
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
