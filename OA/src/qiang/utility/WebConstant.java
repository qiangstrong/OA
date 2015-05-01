package qiang.utility;

public interface WebConstant {
	// HttpSession��������levelֵ
	String MGR_LEVEL = "mgr";
	// HttpSession�����Ա����levelֵ
	String EMP_LEVEL = "emp";
	// HttpSession������û������������
	String LEVEL = "level";
	// HttpSession������û�����������
	String USER = "user";

	// Ա����ҳ��ʾ��ҳ��
	String EMP_PAGENO = "empPageNo";
	// ɾ��Ա��ʱ����ʾ��Ϣ
	String EMP_TIP = "empTip";
	// �����ҳ��ʾ��ҳ��
	String TASK_PAGRNO = "taskPageNo";
	// ɾ������ʱ����ʾ��Ϣ
	String TASK_TIP = "taskTip";
	// ��ʾԱ��ʱÿҳ��ʾ�ļ�¼��
	int EMP_PAGESIZE = 10;
	// ��ʾ����ʱÿҳ��ʾ��������
	int TASK_PAGESIZE = 10;
	// ��ʾҪ�鿴��һҳҳ
	int PREV = 0;
	// ��ʾҪ�鿴��ǰҳ
	int CUR = 1;
	// ��ʾҪ�鿴��һҳҳ
	int NEXT = 2;

	//������ʾ���ڵ��ַ���ģʽ
	String MONTH="yyyy-MM";
	String DATE = "yyyy-MM-dd";
	String TIME = "HH:mm:ss";
	String DATETIME = "yyyy-MM-dd HH:mm:ss";
}
