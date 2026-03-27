package com.aj.JDBConectCRUD.dao;

import java.util.List;

import com.aj.JDBConectCRUD.employee.EmployeeBean;

public interface EmployeeDao {
	public int insertEmp(EmployeeBean emp) throws Exception;
	public int updateEmp(EmployeeBean emp)throws Exception;
	public int DeleteEmp(int emp)throws Exception;
	public List<EmployeeBean> showEmp()throws Exception;

}
