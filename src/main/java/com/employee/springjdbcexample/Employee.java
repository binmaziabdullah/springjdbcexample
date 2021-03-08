package com.employee.springjdbcexample;


public class Employee {

	private Integer id;
	private String name;
	private Integer rollno;

	public Employee() {
	}

	public Employee(int id, String name, int rollno) {
	}

	public Employee(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRollno() {
		return rollno;
	}

	public void setRollno(Integer rollno) {
		this.rollno = rollno;
	}
}
