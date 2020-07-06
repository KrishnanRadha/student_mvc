package com.dxc.service;

import java.util.List;

import com.dxc.dao.StudentDao;
import com.dxc.pojo.Student;

public class StudentService{
	
	StudentDao sd=new StudentDao();
	
	public String addStudent(int rollNo, String name, double perc) {
		return sd.addStudent(rollNo,name,perc);
	}

	public List<Student> showStudent() {
		return sd.showStudent();
	}

	public String updateStudent(int rollNo, String name, double perc) {
		return sd.updateStudent(rollNo,name,perc);
	}
	
	public String deleteStudent(int rollNo) {
		return sd.deleteStudent(rollNo);
	}

	public boolean findStudent(int rollNo) {
		return sd.findStudent(rollNo);
	}
}
