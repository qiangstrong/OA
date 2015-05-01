package qiang.job.base;

import org.springframework.scheduling.quartz.QuartzJobBean;

import qiang.service.face.IAutoService;

public abstract class BaseJob extends QuartzJobBean {
	// �ж���ҵ�Ƿ�ִ�е����
	protected boolean isRunning = false;
	// ����ҵ����������ҵ���߼����
	protected IAutoService autoService;

	public void setAutoService(IAutoService autoService) {
		this.autoService = autoService;
	}

}
