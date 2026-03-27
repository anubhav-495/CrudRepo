package com.aj.JDBConectCRUD.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.aj.JDBConectCRUD.employee.EmployeeBean;

@Repository
public class EmployeeMysqlDaoImpl implements EmployeeDao {

	@Autowired
	DataSource ds;
 	private static final String EMP_INSERT_QUERY="INSERT INTO EMP VALUES(?,?,?,?,?)";
 	private static final String EMP_UPDATE_QUERY="UPDATE EMP SET SAL = ? WHERE EMPNO = ?";
 	private static final String EMP_DELETE_QUERY="DELETE FROM EMP WHERE EMPNO = ?";
 	private static final String EMP_READ_QUERY="SELECT * FROM EMP";
 	
	
	@Override
	public int insertEmp(EmployeeBean emp)throws Exception {
		int count=0;
		try(Connection cn=ds.getConnection();
			PreparedStatement ps=cn.prepareStatement(EMP_INSERT_QUERY); ){
			ps.setInt(1,emp.getEmpNo());
			ps.setString(2, emp.getEmpName());
			ps.setString(3, emp.getEmpJob());
			ps.setDouble(4, emp.getEmpSal());
			ps.setInt(5, emp.getEmpDepNo());
			
			count=ps.executeUpdate();
			if(count<=0) {
				return count;
			}
		}
		System.out.println(count+"cont of insert========================");
		return count;
	}

	@Override
	public int updateEmp(EmployeeBean emp)throws Exception{
		int count=0;
		 if(emp == null || emp.getEmpNo() == null) {
		        return 0;
		 }
		try(Connection cn=ds.getConnection();
				PreparedStatement ps=cn.prepareStatement(EMP_UPDATE_QUERY)){
			ps.setDouble(1, emp.getEmpSal());
			ps.setInt(2, emp.getEmpNo());
			
			count=ps.executeUpdate();
			if(count<0) {
				return count;
			}
		}
		return count;
	}

	@Override
	public int DeleteEmp(int emp)throws Exception {
		int count=0;	
		try(Connection cn=ds.getConnection();
				PreparedStatement ps=cn.prepareStatement(EMP_DELETE_QUERY)){
			ps.setInt(1, emp);
			count=ps.executeUpdate();
			if(count<0) {
				return count;
			}
		}
		return count;
	}

	@Override
	public List<EmployeeBean> showEmp() throws Exception{
		List<EmployeeBean> list=new ArrayList<>();
		try(Connection cn=ds.getConnection();
				PreparedStatement ps=cn.prepareStatement(EMP_READ_QUERY)){
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					EmployeeBean emp = new EmployeeBean();
					emp.setEmpNo(rs.getInt("EMPNo"));
					emp.setEmpName(rs.getString("ENAME"));	
					emp.setEmpJob(rs.getString("JOB"));	
					emp.setEmpSal(rs.getDouble("SAL"));
					emp.setEmpDepNo(rs.getInt("DEPTNO"));
					list.add(emp);
				}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
