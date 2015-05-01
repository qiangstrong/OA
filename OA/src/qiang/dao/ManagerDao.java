package qiang.dao;

import java.util.*;

import qiang.dao.base.*;
import qiang.dao.face.*;
import qiang.domain.*;

public class ManagerDao extends BaseDao implements IManagerDao {
	/**
	 * ���ݱ�ʶ����������Managerʵ��
	 * @param id ��Ҫ���ص�Managerʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��Managerʵ��
	 */
	public Manager get(Integer id) {
		return getHibernateTemplate().get(Manager.class, id);
	}

	/**
	 * �־û�ָ����Managerʵ��
	 * @param manager ��Ҫ���־û���Managerʵ��
	 * @return Managerʵ�����־û���ı�ʶ����ֵ
	 */
	public String save(Manager manager) {
		return (String) getHibernateTemplate().save(manager);
	}

	/**
	 * �޸�ָ����Managerʵ��
	 * @param manager ��Ҫ���޸ĵ�Managerʵ��
	 */
	public void update(Manager manager) {
		getHibernateTemplate().update(manager);
	}

	/**
	 * ɾ��ָ����Managerʵ��
	 * @param manager ��Ҫ��ɾ����Managerʵ��
	 */
	public void delete(Manager manager) {
		getHibernateTemplate().delete(manager);
	}

	/**
	 * ���ݱ�ʶ����ɾ��Managerʵ��
	 * @param id ��Ҫ��ɾ����Managerʵ���ı�ʶ����ֵ
	 */
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}

	/**
	 * ��ѯȫ����Managerʵ��
	 * @return ���ݿ���ȫ����Managerʵ��
	 */
	public List<Manager> findAll() {
		return (List<Manager>) getHibernateTemplate().find("from Manager");
	}

	/**
	 * �����û����������ѯ����
	 * @param emp ����ָ���û���������ľ���
	 * @return ����ָ���û���������ľ���
	 */
	public List<Manager> findByNameAndPass(Manager mgr) {
		List<Manager> list = (List<Manager>) getHibernateTemplate().find(
				"from Manager m where m.name = ? and m.pass=?", mgr.getName(), mgr.getPass());
		return list;
	}

	/**
	 * �����û������Ҿ���
	 * @param name ���������
	 * @return ���ֶ�Ӧ�ľ���
	 */
	public Manager findByName(String name) {
		List<Manager> ml = (List<Manager>) getHibernateTemplate().find(
				"from Manager m where m.name=?", name);
		if (ml != null && ml.size() > 0) {
			return ml.get(0);
		}
		return null;
	}
}
