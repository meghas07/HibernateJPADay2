package com.zycus.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.zycus.dao.CustomerDao;
import com.zycus.dao.GenericDao;
import com.zycus.entity.Address;
import com.zycus.entity.Customer;
import com.zycus.entity.Employee;

public class GenericDaoTest {

	@Test
	public void testAddCustomerWithAddress() {

		/*Employee employee = new Employee();
		employee.setEmpId(3503);
		employee.setEmpName("amar pawar");
		employee.setSalary(1000000);*/
		

		Address address=new Address();
		address.setCity("mumbai");
		address.setPincode(400614);
		address.setState("maharashtra");
		GenericDao dao = new GenericDao();
		//dao.add(address);
		Customer customer = new Customer();
		customer.setName("suyog gadhve");
		customer.setEmail("sonali.gupta@zycus.com");
		customer.setCity("mumbai");
		customer.setAddress(address);

		
		/*dao.add(employee);*/
		
		dao.add(customer);
	}

	@Test
	public void testFetchById() {

		GenericDao dao = new GenericDao();
		Customer customer = dao.fetchById(Customer.class, 2);
		Customer customer1 = dao.fetchById(Customer.class, 1);
		Employee employee = dao.fetchById(Employee.class, 3501);

		assertNotNull(customer);
		System.out.println(customer);

		assertNotNull(employee);
		System.out.println(employee);

		assertNotNull("Expecting not null here", customer1);
		System.out.println(customer1);

	}

	@Test
	public void GenericUpdate() {
		GenericDao dao = new GenericDao();

		Customer customer = dao.fetchById(Customer.class, 2);
		customer.setCity("delhi");

		Employee employee = dao.fetchById(Employee.class, 3501);
		employee.setEmpName("sonali");

		dao.update(customer);
		dao.update(employee);

	}

	@Test
	public void delete() {

		GenericDao dao = new GenericDao();
		dao.delete(Customer.class, 3);
		dao.delete(Employee.class, 3502);
	}

	@Test
	public void fetchAllTest() {

		GenericDao dao = new GenericDao();
		List<Employee> tList = dao.fetchAll(Employee.class);
		for (Employee t : tList)
			System.out.println(t);
		List<Customer> cList = dao.fetchAll(Customer.class);
		for (Customer t : cList)
			System.out.println(t);

	}
}
