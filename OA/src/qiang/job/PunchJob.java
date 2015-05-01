package qiang.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import qiang.job.base.BaseJob;
import qiang.service.face.IAutoService;
import qiang.service.face.IEmpService;

public class PunchJob extends BaseJob {

	// ��������ִ����
	public void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
		if (!isRunning) {
			System.out.println("��ʼ�����Զ���");
			isRunning = true;
			// ����ҵ���߼�����
			autoService.autoPunch();
			isRunning = false;
		}
	}
}