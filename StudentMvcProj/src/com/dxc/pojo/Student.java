package com.dxc.pojo;

public class Student {

	private int rollNo;
	private String name;
	private double perc;
	
	public Student() {
	}

	public Student(int rollNo, String name, double perc) {
		this.rollNo = rollNo;
		this.name = name;
		this.perc = perc;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPerc() {
		return perc;
	}

	public void setPerc(double perc) {
		this.perc = perc;
	}

	@Override
	public String toString() {
		return rollNo+" "+name+" " +perc;
	}
	
	
}
