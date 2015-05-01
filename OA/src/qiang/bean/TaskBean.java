package qiang.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import qiang.utility.WebConstant;

public class TaskBean implements Serializable {
	private static final long serialVersionUID = 48L;
	// 标志任务
	private String name;
	// 任务是否完成
	private boolean finish;
	// 下达任务的日期时间
	private Date datetime;
	// 任务的具体内容
	private String detail;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFinish() {
		if(finish){
			return "已完成";
		}
		return "进行中";
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}

	public String getDatetime() {
		SimpleDateFormat sdf = new SimpleDateFormat(WebConstant.DATETIME);
		return sdf.format(datetime);		
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public TaskBean() {
	}

	public TaskBean(String name, boolean finish, Date datetime, String detail) {
		super();
		this.name = name;
		this.finish = finish;
		this.datetime = datetime;
		this.detail = detail;
	}
}
