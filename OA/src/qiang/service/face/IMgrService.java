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
	 * ��ѯ�����������ŵ�Ա����
	 * @param mgrName ������û���
	 * @return Ա����
	 * @throws OAException
	 */
	long countEmpByMgr(String mgrName) throws OAException;

	/**
	 * ����Ա��
	 * @param emp ������Ա��
	 * @param mgrName Ա�������ľ���
	 * @return true:����Ա���ɹ���false��Ա������������ʧ��
	 * @throws OAException ���������û����������Ļ��˼��������û��������������Ϣ�Ĳ�һ�£������쳣��
	 */
	boolean addEmp(Employee emp, String mgrName) throws OAException;

	/**
	 * ����ɾ��������Ա��
	 * @param empName
	 * @throws OAException
	 */
	void delEmp(String empName) throws OAException;

	/**
	 * �޸ı�����Ա�����û��������롢нˮ
	 * @param oldName Ҫ�޸ĵ�Ա����ԭ�����û���
	 * @param newEmp ��������Ϣ��Ա������
	 * @return �޸��Ƿ�ɹ�������ʱ���޸�ʧ��
	 * @throws OAException
	 */
	boolean changeEmp(String oldName, Employee newEmp) throws OAException;

	/**
	 * ����Ա���û�����ѯԱ����Ϣ�����������һ�����Բ�ѯ����
	 * @param empName
	 * @return ���Ƿ����쳣������һ�����Է��طǿ�ֵ��
	 * @throws OAException
	 */
	Employee queryEmp(String empName) throws OAException;

	/**
	 * ���ؾ����������
	 * @param mgrName ������û���
	 * @return
	 * @throws OAException
	 */
	long countTaskByMgr(String mgrName) throws OAException;

	/**
	 * �����������
	 * @param task
	 * @param mgrName
	 * @return ���������������ʧ��
	 * @throws OAException
	 */
	boolean addTask(Task task, String mgrName) throws OAException;

	/**
	 * ����ɾ������
	 * @param taskName
	 * @throws OAException
	 */
	void delTask(String taskName) throws OAException;

	/**
	 * �ı���������֡�״̬������
	 * @param oldName
	 * @param newTask
	 * @return
	 * @throws OAException
	 */
	boolean changeTask(String oldName, Task newTask) throws OAException;

	/**
	 * ��ѯ����
	 * @param taskName
	 * @return
	 * @throws OAException
	 */
	Task queryTask(String taskName) throws OAException;

	/**
	 * ���ݾ��������еĲ����ϸ��¹���
	 * @param mgrName ������Ա����
	 * @return �����ϸ��¹���
	 */
	List<SalaryBean> getSalaryByMgr(String mgrName) throws OAException;

	/**
	 * ���ݾ����ظò��ŵ�ȫ��Ա��
	 * @param mgrName ������
	 * @return �����ȫ������
	 */
	List<EmpBean> getEmpsByMgr(String mgrName) throws OAException;

	/**
	 * �ṩ��ҳ��ʾ����
	 */
	List<EmpBean> getEmpsByMgr(String mgrName, int pageNo) throws OAException;

	/**
	 * ���ؾ����´����������
	 * @param mgrName �����û���
	 * @return 
	 * @throws OAException
	 */
	List<TaskBean> getTasksByMgr(String mgrName) throws OAException;

	/**
	 * �ṩ��ҳ��ʾ����
	 */
	List<TaskBean> getTasksByMgr(String mgrName, int pageNo) throws OAException;

	/**
	 * ���ݾ����ظò��ŵ�û������������
	 * @param mgrName ������
	 * @return �ò��ŵ�ȫ������
	 */
	List<AppBean> getAppsByMgr(String mgrName) throws OAException;

	/**
	 * ��������
	 * @param appid ����ID
	 * @param mgrName ��������
	 * @param result �Ƿ�ͨ��
	 */
	void check(int appid, String mgrName, boolean result);
}