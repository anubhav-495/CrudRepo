package com.aj.JDBConectCRUD.service;

import java.util.List;

import com.aj.JDBConectCRUD.employee.EmployeeBean;

public interface EmployeeService {
	public int addEmp(EmployeeBean eb)throws Exception;
	public int modifyEmp(EmployeeBean eb)throws Exception;
	public int removeEmp(int eb)throws Exception;
	public  List<EmployeeBean> viewEmp()throws Exception;
	
}
