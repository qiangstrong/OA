package qiang.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import qiang.job.base.BaseJob;

public class ClearJob extends BaseJob {
	// 定义任务执行体
	public void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
		if (!isRunning) {
			System.out.println("开始调度自动清除上年数据");
			isRunning = true;
			// 调用业务逻辑方法
			autoService.autoClear();
			isRunning = false;
		}
	}
}
