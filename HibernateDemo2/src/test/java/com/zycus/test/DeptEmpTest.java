package com.zycus.test;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Test;

import com.zycus.entity.Employee;
import com.zycus.entity.Department;
import com.zycus.dao.GenericDao;

public class DeptEmpTest {

	@Test
	public void addDept() {
		Department dept = new Department();
		dept.setDeptno(100);
		dept.setName("PDT");
		dept.setLocation("Mumbai");
		GenericDao dao = new GenericDao();
		dao.add(dept);

	}

	@Test
	public void addEmp() {
		GenericDao dao = new GenericDao();
		Department dept = dao.fetchById(Department.class, 100);
		// assertNotNull(dept);
		Employee emp = new Employee();
		emp.setEmpId(3511);
		emp.setEmpName("rishabh gupta");
		emp.setSalary(200000);
		// emp.setDepartment(dept);
		dept.getEmployees().add(emp);
		dao.update(dept);

	}
}
