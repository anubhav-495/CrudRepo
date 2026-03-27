package com.aj.JDBConectCRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aj.JDBConectCRUD.employee.EmployeeBean;
import com.aj.JDBConectCRUD.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	public int addNewEmp(EmployeeBean eb) throws Exception {	
		return employeeService.addEmp(eb);
	}

	public int updateEmployee(EmployeeBean eb) throws Exception {
		
		return employeeService.modifyEmp(eb);
	}

	public int deleteEmployee(int eb) throws Exception {
		return employeeService.removeEmp(eb);
	}

	public  List<EmployeeBean> getEmpInfo() throws Exception {
	
		return employeeService.viewEmp();
	}

}
