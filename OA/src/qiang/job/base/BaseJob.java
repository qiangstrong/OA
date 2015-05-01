package qiang.job.base;

import org.springframework.scheduling.quartz.QuartzJobBean;

import qiang.service.face.IAutoService;

public abstract class BaseJob extends QuartzJobBean {
	// 判断作业是否执行的旗标
	protected boolean isRunning = false;
	// 该作业类所依赖的业务逻辑组件
	protected IAutoService autoService;

	public void setAutoService(IAutoService autoService) {
		this.autoService = autoService;
	}

}
