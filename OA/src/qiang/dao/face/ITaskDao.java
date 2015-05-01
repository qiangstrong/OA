package qiang.dao.face;

import java.util.List;

import qiang.domain.Employee;
import qiang.domain.Manager;
import qiang.domain.Task;

public interface ITaskDao {
	Task get(Integer id);

	Integer save(Task task);

	void update(Task task);

	void delete(Task task);

	void delete(Integer id);

	List<Task> findAll();
	
	Task findByName(String taskName);
	
	List<Task> findByMgr(Manager mgr);
	
	List<Task> findByMgr(Manager mgr,int pageNo);
	
	long countByMgr(Manager mgr);
}
