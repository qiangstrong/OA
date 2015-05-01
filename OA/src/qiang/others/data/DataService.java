package qiang.others.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import qiang.dao.EmployeeDao;
import qiang.dao.ManagerDao;
import qiang.dao.face.IEmployeeDao;
import qiang.dao.face.IManagerDao;
import qiang.domain.Employee;
import qiang.domain.Manager;
import qiang.service.base.BaseService;

public class DataService extends BaseService{
	private final int DIV_NUM = 8;
	private final int EMP_NUM = 30;
	private String femalepath = "D:\\MY\\生产实习\\临时\\femalename.txt";
	private String malepath = "D:\\MY\\生产实习\\临时\\malename.txt";

	private String[] divs = { "IEB", "MBS", "MOD", "OSD", "STD", "SKY", "WLD", "WPD" };
	private String[] names=new String[EMP_NUM];
	private List<Manager> mgrList;
	
	public void work() {
		loadName();
		mgrList = mgrDao.findAll();
		Employee emp = new Employee();
		emp.setSalary(6000);
		for (int i = 0; i < DIV_NUM; i++) {
			emp.setManager(mgrList.get(i));
			for (int j = 0; j < EMP_NUM; j++) {
				emp.setName(divs[i] + "_" + names[j]);
				emp.setPass(divs[i] + "_" + names[j]);
				empDao.save(emp);
			}
		}
	}

	private void loadName() {
		File ffile = new File(femalepath);
		File mfile = new File(malepath);
		try {
			BufferedReader fbw = new BufferedReader(new FileReader(ffile));
			BufferedReader mbw = new BufferedReader(new FileReader(mfile));
			for (int i = 0; i < EMP_NUM; i++) {
				if (i % 2 == 0) {
					names[i] = fbw.readLine();
				} else {
					names[i] = mbw.readLine();
				}
			}
			fbw.close();
			mbw.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
