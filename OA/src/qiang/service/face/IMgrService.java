package qiang.service.face;

import java.util.List;

import qiang.bean.AppBean;
import qiang.bean.EmpBean;
import qiang.bean.SalaryBean;
import qiang.bean.TaskBean;
import qiang.domain.Employee;
import qiang.domain.Task;
import qiang.exception.OAException;

public interface IMgrService {
	/**
	 * 查询经理所管理部门的员工数
	 * @param mgrName 经理的用户名
	 * @return 员工数
	 * @throws OAException
	 */
	long countEmpByMgr(String mgrName) throws OAException;

	/**
	 * 新增员工
	 * @param emp 新增的员工
	 * @param mgrName 员工所属的经理
	 * @return true:新增员工成功；false：员工重名，操作失败
	 * @throws OAException 可能由于用户点击浏览器的回退键，引起用户界面与服务器信息的不一致，引起异常。
	 */
	boolean addEmp(Employee emp, String mgrName) throws OAException;

	/**
	 * 经理删除本部门员工
	 * @param empName
	 * @throws OAException
	 */
	void delEmp(String empName) throws OAException;

	/**
	 * 修改本部门员工的用户名、密码、薪水
	 * @param oldName 要修改的员工的原来的用户名
	 * @param newEmp 包含新信息的员工对象
	 * @return 修改是否成功。重名时，修改失败
	 * @throws OAException
	 */
	boolean changeEmp(String oldName, Employee newEmp) throws OAException;

	/**
	 * 根据员工用户名查询员工信息，正常情况下一定可以查询到。
	 * @param empName
	 * @return 除非发生异常，否则一定可以返回非空值。
	 * @throws OAException
	 */
	Employee queryEmp(String empName) throws OAException;

	/**
	 * 返回经理的任务数
	 * @param mgrName 经理的用户名
	 * @return
	 * @throws OAException
	 */
	long countTaskByMgr(String mgrName) throws OAException;

	/**
	 * 经理添加任务
	 * @param task
	 * @param mgrName
	 * @return 重名，则添加任务失败
	 * @throws OAException
	 */
	boolean addTask(Task task, String mgrName) throws OAException;

	/**
	 * 经理删除任务
	 * @param taskName
	 * @throws OAException
	 */
	void delTask(String taskName) throws OAException;

	/**
	 * 改变任务的名字、状态和详情
	 * @param oldName
	 * @param newTask
	 * @return
	 * @throws OAException
	 */
	boolean changeTask(String oldName, Task newTask) throws OAException;

	/**
	 * 查询任务
	 * @param taskName
	 * @return
	 * @throws OAException
	 */
	Task queryTask(String taskName) throws OAException;

	/**
	 * 根据经理返回所有的部门上个月工资
	 * @param mgrName 新增的员工名
	 * @return 部门上个月工资
	 */
	List<SalaryBean> getSalaryByMgr(String mgrName) throws OAException;

	/**
	 * 根据经理返回该部门的全部员工
	 * @param mgrName 经理名
	 * @return 经理的全部下属
	 */
	List<EmpBean> getEmpsByMgr(String mgrName) throws OAException;

	/**
	 * 提供分页显示功能
	 */
	List<EmpBean> getEmpsByMgr(String mgrName, int pageNo) throws OAException;

	/**
	 * 返回经理下达的所有任务
	 * @param mgrName 经理用户名
	 * @return 
	 * @throws OAException
	 */
	List<TaskBean> getTasksByMgr(String mgrName) throws OAException;

	/**
	 * 提供分页显示功能
	 */
	List<TaskBean> getTasksByMgr(String mgrName, int pageNo) throws OAException;

	/**
	 * 根据经理返回该部门的没有批复的申请
	 * @param mgrName 经理名
	 * @return 该部门的全部申请
	 */
	List<AppBean> getAppsByMgr(String mgrName) throws OAException;

	/**
	 * 处理申请
	 * @param appid 申请ID
	 * @param mgrName 经理名字
	 * @param result 是否通过
	 */
	void check(int appid, String mgrName, boolean result);
}