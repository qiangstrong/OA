package qiang.service.face;

public interface IAutoService {
	// 以上午11点为上午时间
	public static final int AM_LIMIT = 11;
	
	/**
	 * 自动打卡，周一到周五，早上7：00为每个员工插入旷工记录
	 */
	void autoPunch();
	
	/**
	 * 自动结算工资，每月1号，结算上个月工资
	 */
	void autoPay();
	
	/**
	 * 自动清除上一年打卡记录和工资记录，每年3月1日0时启动
	 */
	void autoClear();
}
