package com.soft.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.soft.beans.Student;

public class StudentService {
	
	Connection con =null;
	Statement st = null;
	ResultSet rs = null;

	public StudentService() {
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","durga");
			st = con.createStatement();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public Student getStudent(String sid) {
		Student std = null;
		try {
			rs = st.executeQuery("select *  from student where SID='"+sid+"'");
			boolean b = rs.next();
			if (b == true) {
				std = new Student();
				std.setSid(rs.getString("SID"));
				std.setSname(rs.getString("SNAME"));
				std.setSaddr(rs.getString("SADDR"));
			}else {
				std = null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return std;
	}
	
	public String updateStudent() {
		return "";
	}

}
