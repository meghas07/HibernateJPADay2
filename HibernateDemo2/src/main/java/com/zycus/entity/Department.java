package com.zycus.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {

	@Id
	private int deptno;

	private String name;
	private String location;

	@OneToMany(/*mappedBy="department",*/cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="deptno")
	private Set<Employee> employees;

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", name=" + name + ", location=" + location
				+ "]";
	}

}
