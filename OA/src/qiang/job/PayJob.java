package qiang.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import qiang.job.base.BaseJob;
import qiang.service.face.IAutoService;
import qiang.service.face.IEmpService;

public class PayJob extends BaseJob {

	// ��������ִ����
	public void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
		if (!isRunning) {
			System.out.println("��ʼ�����Զ����㹤��");
			isRunning = true;
			// ����ҵ���߼�����
			autoService.autoPay();
			isRunning = false;
		}
	}
}