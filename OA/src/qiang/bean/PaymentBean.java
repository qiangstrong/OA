package qiang.bean;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

import qiang.utility.WebConstant;

public class PaymentBean implements Serializable {
	private static final long serialVersionUID = 48L;
	private Date payMonth;
	private double amount;

	// �޲����Ĺ�����
	public PaymentBean() {
	}

	// ��ʼ��ȫ�����ԵĹ�����
	public PaymentBean(Date payMonth, double amount) {
		this.payMonth = payMonth;
		this.amount = amount;
	}

	// payMonth���Ե�setter��getter����
	public void setPayMonth(Date payMonth) {
		this.payMonth = payMonth;
	}

	public String getPayMonth() {
		SimpleDateFormat sdf = new SimpleDateFormat(WebConstant.MONTH);
		return sdf.format(payMonth);		
	}

	// amount���Ե�setter��getter����
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return this.amount;
	}

}