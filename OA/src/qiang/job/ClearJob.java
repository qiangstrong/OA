package qiang.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import qiang.job.base.BaseJob;

public class ClearJob extends BaseJob {
	// ��������ִ����
	public void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
		if (!isRunning) {
			System.out.println("��ʼ�����Զ������������");
			isRunning = true;
			// ����ҵ���߼�����
			autoService.autoClear();
			isRunning = false;
		}
	}
}
