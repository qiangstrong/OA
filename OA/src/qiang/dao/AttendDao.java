package qiang.dao;

import java.util.*;
import java.sql.Date;
import java.text.*;

import org.hibernate.Query;
import org.hibernate.Session;

import qiang.dao.base.*;
import qiang.dao.face.*;
import qiang.domain.*;

public class AttendDao extends BaseDao implements IAttendDao {
	/**
	 * ���ݱ�ʶ����������Attendʵ��
	 * @param id ��Ҫ���ص�Attendʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��Attendʵ��
	 */
	public Attend get(Integer id) {
		return getHibernateTemplate().get(Attend.class, id);
	}

	/**
	 * �־û�ָ����Attendʵ��
	 * @param attend ��Ҫ���־û���Attendʵ��
	 * @return Attendʵ�����־û���ı�ʶ����ֵ
	 */
	public Integer save(Attend attend) {
		return (Integer) getHibernateTemplate().save(attend);
	}

	/**
	 * �޸�ָ����Attendʵ��
	 * @param attend ��Ҫ���޸ĵ�Attendʵ��
	 */
	public void update(Attend attend) {
		getHibernateTemplate().update(attend);
	}

	/**
	 * ɾ��ָ����Attendʵ��
	 * @param attend ��Ҫ��ɾ����Attendʵ��
	 */
	public void delete(Attend attend) {
		getHibernateTemplate().delete(attend);
	}

	/**
	 * ���ݱ�ʶ����ɾ��Attendʵ��
	 * @param id ��Ҫ��ɾ����Attendʵ���ı�ʶ����ֵ
	 */
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}
	
	public void delete(Date firstDate, Date lastDate) {
		Session session=getSession();
		String hql="delete from Attend as a where a.dutyDay between ? and ?";
		Query query=session.createQuery(hql);
		query.setDate(0, firstDate);
		query.setDate(1, lastDate);
		query.executeUpdate();
	}
	/**
	 * ��ѯȫ����Attendʵ��
	 * @return ���ݿ���ȫ����Attendʵ��
	 */
	public List<Attend> findAll() {
		return (List<Attend>) getHibernateTemplate().find("from Attend");
	}

	/**
	 * ����Ա����ѯ��Ա���Ĵ򿨼�¼
	 * @param emp Ա��
	 * @return ��Ա����ȫ�����ڼ�¼
	 */
	public List<Attend> findByEmp(Employee emp) {
		return (List<Attend>) getHibernateTemplate().find("from Attend as a where a.employee=?",
				emp);
	}

	/**
	 * ����Ա�������ڲ�ѯ��Ա���Ĵ򿨼�¼����
	 * @param emp Ա��
	 * @param dutyDay ����
	 * @return ��Ա����ĳ��Ĵ򿨼�¼����
	 */
	public List<Attend> findByEmpAndDutyDay(Employee emp, Date dutyDay) {
		return (List<Attend>) getHibernateTemplate().find(
				"from Attend as a where a.employee=? and " + "a.dutyDay=?",
				new Object[] { emp, dutyDay });
	}

	/**
	 * ����Ա�������� �����°��ѯ��Ա���Ĵ򿨼�¼����
	 * @param emp Ա��
	 * @param dutyDay ����
	 * @param isCome �Ƿ��ϰ�
	 * @return ��Ա����ĳ���ϰ���°�Ĵ򿨼�¼
	 */
	public Attend findByEmpAndDutyDayAndCome(Employee emp, Date dutyDay, boolean isCome) {
		List<Attend> al = findByEmpAndDutyDay(emp, dutyDay);
		if (al != null || al.size() > 1) {
			for (Attend attend : al) {
				if (attend.getIsCome() == isCome) {
					return attend;
				}
			}
		}
		return null;
	}

	/**
	 * �鿴Ա��ǰ����ķ�������
	 * @param emp Ա��
	 * @return ��Ա����ǰ����ķ�������
	 */
	public List<Attend> findByEmpUnAttend(Employee emp, AttendType type) {
		Calendar c = Calendar.getInstance();
		Date end = new Date(c.getTimeInMillis());
		c.add(Calendar.DAY_OF_MONTH, -3);
		Date start = new Date(c.getTimeInMillis());
		Object[] args = { emp, type, start, end };
		return (List<Attend>) getHibernateTemplate().find(
				"from Attend as a where a.employee=? and "
						+ "a.type != ? and a.dutyDay between ? and ?", args);
	}
}
