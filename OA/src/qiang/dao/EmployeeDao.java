package qiang.dao;

import java.sql.SQLException;
import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import qiang.dao.base.*;
import qiang.dao.face.*;
import qiang.domain.*;
import qiang.utility.WebConstant;

public class EmployeeDao extends BaseDao implements IEmployeeDao {
	/**
	 * ���ݱ�ʶ����������Employeeʵ��
	 * @param id ��Ҫ���ص�Employeeʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��Employeeʵ��
	 */
	public Employee get(Integer id) {
		return getHibernateTemplate().get(Employee.class, id);
	}

	/**
	 * �־û�ָ����Employeeʵ��
	 * @param employee ��Ҫ���־û���Employeeʵ��
	 * @return Employeeʵ�����־û���ı�ʶ����ֵ
	 */
	public Integer save(Employee employee) {
		return (Integer) getHibernateTemplate().save(employee);
	}

	/**
	 * �޸�ָ����Employeeʵ��
	 * @param employee ��Ҫ���޸ĵ�Employeeʵ��
	 */
	public void update(Employee employee) {
		getHibernateTemplate().update(employee);
	}

	/**
	 * ɾ��ָ����Employeeʵ��
	 * @param employee ��Ҫ��ɾ����Employeeʵ��
	 */
	public void delete(Employee employee) {
		getHibernateTemplate().delete(employee);
	}

	/**
	 * ���ݱ�ʶ����ɾ��Employeeʵ��
	 * @param id ��Ҫ��ɾ����Employeeʵ���ı�ʶ����ֵ
	 */
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}

	/**
	 * ��ѯȫ����Employeeʵ��
	 * @return ���ݿ���ȫ����Employeeʵ��
	 */
	public List<Employee> findAll() {
		return (List<Employee>) getHibernateTemplate().find("from Employee");
	}

	/**
	 * �����û����������ѯԱ��
	 * @param emp ����ָ���û����������Ա��
	 * @return ����ָ���û����������Ա������
	 */
	public List<Employee> findByNameAndPass(Employee emp) {
		List<Employee> list = (List<Employee>) getHibernateTemplate().find(
				"from Employee p where p.name = ? and p.pass=?", emp.getName(), emp.getPass());
		return list;
	}

	/**
	 * �����û�����ѯԱ��
	 * @param name Ա�����û���
	 * @return �����û�����Ա��
	 */
	public Employee findByName(String name) {
		List<Employee> emps = (List<Employee>) getHibernateTemplate().find(
				"from Employee where name = ? ", name);
		if (emps != null && emps.size() >= 1) {
			return emps.get(0);
		}
		return null;
	}

	/**
	 * ���ݾ����ѯԱ��
	 * @param mgr ����
	 * @return �þ����Ӧ������Ա��
	 */
	public List<Employee> findByMgr(Manager mgr) {
		return (List<Employee>) getHibernateTemplate().find(
				"from Employee as e where " + "e.manager = ?", mgr);
	}

	public List<Employee> findByMgr(Manager mgr, int pageNo) {
		String hql = "from Employee as e where e.manager=?";
		int offset = (pageNo - 1) * WebConstant.EMP_PAGESIZE;
		return (List<Employee>) findByPage(hql, mgr, offset, WebConstant.EMP_PAGESIZE);
	}

	public long countByMgr(Manager mgr) {
		Session session = getSession();
		String hql = "select count(*) from Employee as e where e.manager=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, mgr);
		return ((Long) query.uniqueResult());
	}
}
