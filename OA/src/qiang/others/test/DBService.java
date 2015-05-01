package qiang.others.test;

import qiang.domain.Employee;
import qiang.domain.Manager;
import qiang.service.base.BaseService;

public class DBService extends BaseService {
		
	public void work(){
		String myTag="qiang:\n\t";
		int id=1;
		Manager mgr=mgrDao.get(id);
		long count=empDao.countByMgr(mgr);
		System.out.println(myTag+count);
	}
}
