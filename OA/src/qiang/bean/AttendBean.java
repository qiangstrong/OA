package qiang.bean;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

import qiang.utility.WebConstant;

public class AttendBean implements Serializable {
	private static final long serialVersionUID = 48L;
	private int id;
	private Date dutyDay;
	private String unType;
	private Time time;

	// �޲����Ĺ�����
	public AttendBean() {
	}

	// ��ʼ��ȫ�����ԵĹ�����
	public AttendBean(int id, Date dutyDay, String unType, Time time) {
		this.id = id;
		this.dutyDay = dutyDay;
		this.unType = unType;
		this.time = time;
	}

	// id���Ե�setter��getter����
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	// dutyDay���Ե�setter��getter����
	public void setDutyDay(Date dutyDay) {
		this.dutyDay = dutyDay;
	}

	public String getDutyDay() {
		SimpleDateFormat sdf = new SimpleDateFormat(WebConstant.DATE);
		return sdf.format(dutyDay);
	}

	// unType���Ե�setter��getter����
	public void setUnType(String unType) {
		this.unType = unType;
	}

	public String getUnType() {
		return this.unType;
	}

	// time���Ե�setter��getter����
	public void setTime(Time time) {
		this.time = time;
	}

	public String getTime() {
		if(time==null) return "";
		SimpleDateFormat sdf = new SimpleDateFormat(WebConstant.TIME);
		return sdf.format(time);
	}
}