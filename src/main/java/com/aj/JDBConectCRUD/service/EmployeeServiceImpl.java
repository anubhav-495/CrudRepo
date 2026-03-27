package com.aj.JDBConectCRUD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aj.JDBConectCRUD.dao.EmployeeDao;
import com.aj.JDBConectCRUD.employee.EmployeeBean;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	@Override
	public int addEmp(EmployeeBean eb) throws Exception {
		
		return employeeDao.insertEmp(eb);
	}

	@Override
	public int modifyEmp(EmployeeBean eb) throws Exception {
		
		return employeeDao.updateEmp(eb);
	}

	@Override
	public int removeEmp(int eb) throws Exception {
		// TODO Auto-generated method stub
		return employeeDao.DeleteEmp(eb);
	}

	@Override
	public List<EmployeeBean> viewEmp() throws Exception {
	
		return employeeDao.showEmp();
	}

}
