package qiang.service.face;

import java.sql.Date;
import java.util.List;

import qiang.bean.AttendBean;
import qiang.bean.PaymentBean;
import qiang.bean.TaskBean;
import qiang.domain.AttendType;
import qiang.domain.Employee;
import qiang.domain.Manager;
import qiang.domain.Task;
import qiang.exception.OAException;

public interface IEmpService {
	// ��¼ʧ��
	public static final int LOGIN_FAIL = 0;
	// ����ͨԱ����¼
	public static final int LOGIN_EMP = 1;
	// �Ծ����¼
	public static final int LOGIN_MGR = 2;

	// ���ܴ�
	public static final int NO_PUNCH = 0;
	// ֻ���ϰ��
	public static final int COME_PUNCH = 1;
	// ֻ���°��
	public static final int LEAVE_PUNCH = 2;
	// �ȿ����ϰ࣬Ҳ�����°��
	public static final int BOTH_PUNCH = 3;

	// ��ʧ��
	public static final int PUNCH_FAIL = 0;
	// �Ѿ���
	public static final int PUNCHED = 1;
	// �򿨳ɹ�
	public static final int PUNCH_SUCC = 2;

	// ������9��֮ǰΪ�����ϰ�
	public static final int COME_LIMIT = 9;
	// ������9~11��֮����ٵ�
	public static final int LATE_LIMIT = 11;
	// ������18��֮���������°�
	public static final int LEAVE_LIMIT = 18;
	// ������16~18��֮����ٵ�
	public static final int EARLY_LIMIT = 16;

	/**
	 * �Ծ����������֤��¼
	 * @param mgr ��¼�ľ������
	 * @return ��¼������ȷ��:0Ϊ��¼ʧ�ܣ�1Ϊ��¼emp 2Ϊ��¼mgr
	 */
	int validLogin(Manager mgr);

	/**
	 * ��֤ĳ��Ա���Ƿ�ɴ�
	 * @param user Ա����
	 * @param dutyDay ����
	 * @return �ɴ򿨵����
	 */
	int validPunch(String user, Date dutyDay);

	/**
	 * ��
	 * @param user Ա����
	 * @param dutyDay ������
	 * @param isCome �Ƿ����ϰ��
	 * @return �򿨽��
	 */
	public int punch(String user, Date dutyDay, boolean isCome);

	/**
	 * ����Ա������Լ��Ĺ���
	 * @param empName Ա����
	 * @return ��Ա���Ĺ����б�
	 */
	List<PaymentBean> empSalary(String empName);

	/**
	 * Ա���鿴�Լ�����������������
	 * @param empName Ա����
	 * @return ��Ա�����������ķ�������
	 */
	List<AttendBean> unAttend(String empName);

	/**
	 * ����ȫ���ĳ������
	 * @return ȫ���ĳ������
	 */
	List<AttendType> getAllType();

	/**
	 * �������
	 * @param attId ����ĳ���ID
	 * @param typeId ���������ID
	 * @param reason ���������
	 * @return ��ӵĽ��
	 */
	boolean addApplication(int attId, int typeId, String reason);
	
	/**
	 * �޸�ָ��Ա��������
	 * @param name ���޸������Ա���û���
	 * @param pass �����룬�������Ѿ���У��
	 */
	void changePass(String name,String pass) throws OAException;
	
	/**
	 * ��ȡ�����´������
	 * @param empName Ա���û���
	 * @return
	 * @throws OAException
	 */
	List<TaskBean> getTasks(String empName) throws OAException;
}