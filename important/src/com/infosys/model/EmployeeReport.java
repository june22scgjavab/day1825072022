package com.infosys.model;

public class EmployeeReport {
	private int id;
	private String name;
	private long basic;

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

	public long getBasic() {
		return basic;
	}

	public void setBasic(long basic) {
		this.basic = basic;
	}

	@Override
	public String toString() {
		return "EmployeeReport [id=" + id + ", name=" + name + ", basic=" + basic + "]";
	}

}
