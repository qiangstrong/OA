package qiang.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import qiang.dao.base.BaseDao;
import qiang.dao.face.ITaskDao;
import qiang.domain.Manager;
import qiang.domain.Task;
import qiang.utility.WebConstant;

public class TaskDao extends BaseDao implements ITaskDao {

	@Override
	public Task get(Integer id) {
		return getHibernateTemplate().get(Task.class, id);
	}

	@Override
	public Integer save(Task task) {
		return (Integer) getHibernateTemplate().save(task);
	}

	@Override
	public void update(Task task) {
		getHibernateTemplate().update(task);
	}

	@Override
	public void delete(Task task) {
		getHibernateTemplate().delete(task);
	}

	@Override
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}

	@Override
	public List<Task> findAll() {
		return (List<Task>) getHibernateTemplate().find("from Task");
	}

	@Override
	public Task findByName(String taskName) {
		List<Task> tasks = (List<Task>) getHibernateTemplate().find("from Task where name = ? ",
				taskName);
		if (tasks != null && tasks.size() >= 1) {
			return tasks.get(0);
		}
		return null;
	}

	@Override
	public List<Task> findByMgr(Manager mgr) {
		return (List<Task>) getHibernateTemplate().find(
				"from Task as t where t.manager = ?", mgr);
	}

	@Override
	public List<Task> findByMgr(Manager mgr, int pageNo) {
		String hql="from Task as t where t.manager=?";
		int offset=(pageNo-1)*WebConstant.TASK_PAGESIZE;
		return (List<Task>)findByPage(hql, mgr, offset, WebConstant.TASK_PAGESIZE);
	}

	@Override
	public long countByMgr(Manager mgr) {
		Session session = getSession();
		String hql = "select count(*) from Task as t where t.manager=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, mgr);
		return ((Long) query.uniqueResult());
	}

}
