package qiang.dao.face;

import java.sql.Date;
import java.util.*;

import qiang.domain.*;

public interface IAttendDao {
	/**
	 * ���ݱ�ʶ����������Attendʵ��
	 * @param id ��Ҫ���ص�Attendʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Զ�Ӧ��Attendʵ��
	 */
	Attend get(Integer id);

	/**
	 * �־û�ָ����Attendʵ��
	 * @param attend ��Ҫ���־û���Attendʵ��
	 * @return Attendʵ�����־û���ı�ʶ����ֵ
	 */
	Integer save(Attend attend);

	/**
	 * �޸�ָ����Attendʵ��
	 * @param attend ��Ҫ���޸ĵ�Attendʵ��
	 */
	void update(Attend attend);

	/**
	 * ɾ��ָ����Attendʵ��
	 * @param attend ��Ҫ��ɾ����Attendʵ��
	 */
	void delete(Attend attend);

	/**
	 * ���ݱ�ʶ����ɾ��Attendʵ��
	 * @param id ��Ҫ��ɾ����Attendʵ���ı�ʶ����ֵ
	 */
	void delete(Integer id);
	
	/**
	 * ɾ��ָ��ʱ����ڵ�����
	 * @param firstDate ��ʼ����
	 * @param lastDate ��ֹ����
	 */
	void delete(Date firstDate, Date lastDate);

	/**
	 * ��ѯȫ����Attendʵ��
	 * @return ���ݿ���ȫ����Attendʵ��
	 */
	List<Attend> findAll();

	/**
	 * ����Ա����ѯ��Ա���Ĵ򿨼�¼
	 * @param emp Ա��
	 * @return ��Ա����ȫ�����ڼ�¼
	 */
	List<Attend> findByEmp(Employee emp);

	/**
	 * ����Ա�������ڲ�ѯ��Ա���Ĵ򿨼�¼����
	 * @param emp Ա��
	 * @param dutyDay ����
	 * @return ��Ա����ĳ��Ĵ򿨼�¼����
	 */
	List<Attend> findByEmpAndDutyDay(Employee emp, Date dutyDay);

	/**
	 * ����Ա�������� �����°��ѯ��Ա���Ĵ򿨼�¼����
	 * @param emp Ա��
	 * @param dutyDay ����
	 * @param isCome �Ƿ��ϰ�
	 * @return ��Ա����ĳ���ϰ���°�Ĵ򿨼�¼
	 */
	Attend findByEmpAndDutyDayAndCome(Employee emp, Date dutyDay, boolean isCome);

	/**
	 * �鿴Ա��ǰ����ķ�������
	 * @param emp Ա��
	 * @return ��Ա����ǰ����ķ�������
	 */
	List<Attend> findByEmpUnAttend(Employee emp, AttendType type);
}