package qiang.dao;

import java.util.*;

import qiang.dao.base.*;
import qiang.dao.face.*;
import qiang.domain.*;

public class CheckBackDao extends BaseDao implements ICheckBackDao {
	/**
	 * ���ݱ�ʶ����������CheckBackʵ��
	 * @param id ��Ҫ���ص�CheckBackʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��CheckBackʵ��
	 */
	public CheckBack get(Integer id) {
		return getHibernateTemplate().get(CheckBack.class, id);
	}

	/**
	 * �־û�ָ����CheckBackʵ��
	 * @param checkBack ��Ҫ���־û���CheckBackʵ��
	 * @return CheckBackʵ�����־û���ı�ʶ����ֵ
	 */
	public Integer save(CheckBack checkBack) {
		return (Integer) getHibernateTemplate().save(checkBack);
	}

	/**
	 * �޸�ָ����CheckBackʵ��
	 * @param checkBack ��Ҫ���޸ĵ�CheckBackʵ��
	 */
	public void update(CheckBack checkBack) {
		getHibernateTemplate().update(checkBack);
	}

	/**
	 * ɾ��ָ����CheckBackʵ��
	 * @param checkBack ��Ҫ��ɾ����CheckBackʵ��
	 */
	public void delete(CheckBack checkBack) {
		getHibernateTemplate().delete(checkBack);
	}

	/**
	 * ���ݱ�ʶ����ɾ��CheckBackʵ��
	 * @param id ��Ҫ��ɾ����CheckBackʵ���ı�ʶ����ֵ
	 */
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}

	/**
	 * ��ѯȫ����CheckBackʵ��
	 * @return ���ݿ���ȫ����CheckBackʵ��
	 */
	public List<CheckBack> findAll() {
		return (List<CheckBack>) getHibernateTemplate().find("from CheckBack");
	}
}
