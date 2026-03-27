package com.aj.JDBConectCRUD;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.aj.JDBConectCRUD.controller.EmployeeController;
import com.aj.JDBConectCRUD.employee.EmployeeBean;

@SpringBootApplication
public class JdbConectCrudApplication {

	public static void main(String[] args) throws Exception {
	ApplicationContext ctx=	SpringApplication.run(JdbConectCrudApplication.class, args);
	EmployeeController empcontrol=ctx.getBean(EmployeeController.class);
	EmployeeBean eb=new EmployeeBean(114,"jk","IT",79500.0,50816);
	empcontrol.addNewEmp(eb);
	System.out.println("info of Employeee"+empcontrol.getEmpInfo());
	Scanner reader=new Scanner(System.in);
	EmployeeBean ebup=new EmployeeBean();
	System.out.println("Enter EMPLOYEE ID FOR update :");
	int upID=reader.nextInt();
	System.out.println("Enter EMPLOYEE updated Salary :");
	double upsal=reader.nextDouble();
	ebup.setEmpNo(upID);
	ebup.setEmpSal(upsal);
	empcontrol.updateEmployee(ebup);
	System.out.println("Enter the id to delete the EMPLOYEE");
	empcontrol.deleteEmployee(reader.nextInt());
	System.out.println("info of Employeee"+empcontrol.getEmpInfo());
	reader.close();
	}

}

