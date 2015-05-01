package qiang.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import qiang.job.base.BaseJob;
import qiang.service.face.IAutoService;
import qiang.service.face.IEmpService;

public class PunchJob extends BaseJob {

	// 定义任务执行体
	public void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
		if (!isRunning) {
			System.out.println("开始调度自动打卡");
			isRunning = true;
			// 调用业务逻辑方法
			autoService.autoPunch();
			isRunning = false;
		}
	}
}