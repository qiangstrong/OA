package qiang.domain;

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable {
	private static final long serialVersionUID = 48L;
	private Integer id;
	// 标志任务
	private String name;
	// 任务是否完成
	private boolean finish;
	// 创建任务的日期时间
	private Date datetime;
	// 任务的具体内容
	private String detail;
	// 任务下达者
	private Manager manager;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isFinish() {
		return finish;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}

	public Date getDatetime() {
		return datetime;
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

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Task() {
	}

	public Task(String name, boolean finish, Date datetime, String detail, Manager manager) {
		this.name = name;
		this.finish = finish;
		this.datetime = datetime;
		this.detail = detail;
		this.manager = manager;
	}

}
