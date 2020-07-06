package com.dxc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.dxc.pojo.Student;

public class StudentDao {

	public static Connection conn=null;
	
	static {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/krish","root","Krish@1001");
			System.out.println("sdjhgja<k");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String addStudent(int rollNo, String name, double perc) {
		try {
			PreparedStatement pstmt=conn.prepareStatement("insert into student values(?,?,?)");
			pstmt.setInt(1, rollNo);
			pstmt.setString(2, name);
			pstmt.setDouble(3, perc);
			pstmt.execute();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "successfully student added!!...";
	}

	public List<Student> showStudent() {
		List<Student> lst=new ArrayList<Student>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from student");
			while(rs.next())
			{
				Student stu=new Student(rs.getInt(1),rs.getString(2),rs.getDouble(3));
				lst.add(stu);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lst;
	}

	public String updateStudent(int rollNo, String name, double perc) {
		try {
			PreparedStatement pstmt=conn.prepareStatement("update student set name=?,perc=? where rollno=?");
			pstmt.setString(1, name);
			pstmt.setDouble(2, perc);
			pstmt.setInt(3, rollNo);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return "Successfully student updated";
	}

	public String deleteStudent(int rollNo) {
		try {
			PreparedStatement pstmt=conn.prepareStatement("delete from student where rollno=?");
			pstmt.setInt(1, rollNo);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return "Successfully student deleted";
	}
	public boolean findStudent(int rollno)
	{
		boolean b=false;
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select rollno from student");
			while(rs.next())
			{
				if(rollno==rs.getInt(1))
				{
					b=true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return b;
	}
}
