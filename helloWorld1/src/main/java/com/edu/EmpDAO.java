package com.edu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO extends DAO {
	
	public int updateMember(String name, String pass, String role) {
		int r = 0;
		connection();
		try {
			String sql = "update members set member_password=?, member_role = ? where member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pass);
			pstmt.setString(2, role);
			pstmt.setString(3, name);
			
			r = pstmt.executeUpdate();
			System.out.println(r + "건 변경됨.");
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection();
		}
		return r;
	}
	// user_name, user_pass, role => 입력.
	public int insertMember(String name, String pass, String role) {
		int r = 0;
		connection();
		try {
		String sql = "insert into members values(?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, pass);
		pstmt.setString(3, role);
		
		r = pstmt.executeUpdate(); // insert, update, delete
		System.out.println(r + "건 입력됨.");
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection();
		}
		return r;
	}
	
	
	
	
	public List<Employee> getEmpInfo(String name) {
		connection(); // conn객체,
		List<Employee> list = new ArrayList<>();
		try {
			String sql = "select * from employees where first_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeid(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setSalary(rs.getInt("salary"));
				
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection();
		}
		return list;
	}
	
	public List<Employee> empList() {
		List<Employee> list = new ArrayList<>();
		try {
			connection();
			String sql = "SELECT first_name, last_name, email, hire_date, salary, job_id FROM employees";
			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Employee employee = new Employee();
				employee.setFirstName(rs.getString("first_name"));
				employee.setLastName(rs.getString("last_name"));
				employee.setEmail(rs.getString("email"));
				employee.setHireDate(rs.getString("hire_date"));
				employee.setSalary(rs.getInt("salary"));
				employee.setJobId(rs.getString("job_id"));
				
				list.add(employee);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnection();
		}
		return list;
	}
}
