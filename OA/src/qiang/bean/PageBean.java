package qiang.bean;

import java.io.Serializable;

public class PageBean implements Serializable {
	private static final long serialVersionUID = 48L;
	//��������
	private int type;
	//ҳ��
	private int pageNo=0;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		if(pageNo<0) pageNo=0;
		this.pageNo = pageNo;
	}

	public PageBean() {
	}

	public PageBean(int type, int pageNo) {
		this.type = type;
		this.pageNo = pageNo;
	}
}
