package qiang.service.face;

public interface IAutoService {
	// ������11��Ϊ����ʱ��
	public static final int AM_LIMIT = 11;
	
	/**
	 * �Զ��򿨣���һ�����壬����7��00Ϊÿ��Ա�����������¼
	 */
	void autoPunch();
	
	/**
	 * �Զ����㹤�ʣ�ÿ��1�ţ������ϸ��¹���
	 */
	void autoPay();
	
	/**
	 * �Զ������һ��򿨼�¼�͹��ʼ�¼��ÿ��3��1��0ʱ����
	 */
	void autoClear();
}
