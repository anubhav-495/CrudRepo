package com.aj.JDBConectCRUD.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeBean {
	Integer empNo;
	String empName;
	String empJob;
	Double empSal;
	Integer empDepNo;
}
