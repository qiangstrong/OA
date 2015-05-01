package qiang.others.test;

import com.opensymphony.xwork2.ActionSupport;

public class DBAction extends ActionSupport {
	private DBService dbService;

	public DBService getDbService() {
		return dbService;
	}

	public void setDbService(DBService dbService) {
		this.dbService = dbService;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		dbService.work();
		return SUCCESS;
	}

}
