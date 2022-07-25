package com.infosys.model;

public class Employee {
	private int id;
	private String name;
	private String designation;
	private String department;
	private long basic;


public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
public Employee(int id, String name, String designation, String department, long basic) {
	super();
	this.id = id;
	this.name = name;
	this.designation = designation;
	this.department = department;
	this.basic = basic;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public long getBasic() {
	return basic;
}
public void setBasic(long basic) {
	this.basic = basic;
}
@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + ", department=" + department
			+ ", basic=" + basic + "]";
}

}

