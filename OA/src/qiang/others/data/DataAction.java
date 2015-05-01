package qiang.others.data;

import com.opensymphony.xwork2.ActionSupport;

public class DataAction extends ActionSupport {
	private DataService dataService;

	public DataService getDataService() {
		return dataService;
	}

	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		dataService.work();
		return SUCCESS;
	}

}
