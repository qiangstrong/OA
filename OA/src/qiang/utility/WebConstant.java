package qiang.utility;

public interface WebConstant {
	// HttpSession里代表经理的level值
	String MGR_LEVEL = "mgr";
	// HttpSession里代表员工的level值
	String EMP_LEVEL = "emp";
	// HttpSession里代表用户级别的属性名
	String LEVEL = "level";
	// HttpSession里代表用户名的属性名
	String USER = "user";

	// 员工分页显示的页号
	String EMP_PAGENO = "empPageNo";
	// 删除员工时的提示信息
	String EMP_TIP = "empTip";
	// 任务分页显示的页号
	String TASK_PAGRNO = "taskPageNo";
	// 删除任务时的提示信息
	String TASK_TIP = "taskTip";
	// 显示员工时每页显示的记录数
	int EMP_PAGESIZE = 10;
	// 显示任务时每页显示的任务数
	int TASK_PAGESIZE = 10;
	// 表示要查看上一页页
	int PREV = 0;
	// 表示要查看当前页
	int CUR = 1;
	// 表示要查看下一页页
	int NEXT = 2;

	//用于显示日期的字符串模式
	String MONTH="yyyy-MM";
	String DATE = "yyyy-MM-dd";
	String TIME = "HH:mm:ss";
	String DATETIME = "yyyy-MM-dd HH:mm:ss";
}
