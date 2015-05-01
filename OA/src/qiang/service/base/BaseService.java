package qiang.service.base;

import qiang.dao.face.IApplicationDao;
import qiang.dao.face.IAttendDao;
import qiang.dao.face.IAttendTypeDao;
import qiang.dao.face.ICheckBackDao;
import qiang.dao.face.IEmployeeDao;
import qiang.dao.face.IManagerDao;
import qiang.dao.face.IPaymentDao;
import qiang.dao.face.ITaskDao;

public class BaseService {
	protected IApplicationDao appDao;
	protected IAttendDao attendDao;
	protected IAttendTypeDao typeDao;
	protected ICheckBackDao checkDao;
	protected IEmployeeDao empDao;
	protected IManagerDao mgrDao;
	protected IPaymentDao payDao;
	protected ITaskDao taskDao;

	public void setAppDao(IApplicationDao appDao) {
		this.appDao = appDao;
	}

	public void setAttendDao(IAttendDao attendDao) {
		this.attendDao = attendDao;
	}

	public void setTypeDao(IAttendTypeDao typeDao) {
		this.typeDao = typeDao;
	}

	public void setCheckDao(ICheckBackDao checkDao) {
		this.checkDao = checkDao;
	}

	public void setEmpDao(IEmployeeDao empDao) {
		this.empDao = empDao;
	}

	public void setMgrDao(IManagerDao mgrDao) {
		this.mgrDao = mgrDao;
	}

	public void setPayDao(IPaymentDao payDao) {
		this.payDao = payDao;
	}

	public ITaskDao getTaskDao() {
		return taskDao;
	}

	public void setTaskDao(ITaskDao taskDao) {
		this.taskDao = taskDao;
	}
	
}
