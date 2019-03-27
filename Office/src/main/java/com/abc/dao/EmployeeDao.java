package com.abc.dao;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.abc.model.Employee;

@Repository
public class EmployeeDao {
	private static Map<Integer, Employee> employees;
	
	static {
		employees = new HashMap<>();
		Employee e1 = new Employee();
		e1.setEmpId(1001);
		e1.setFirstname("Huining");
		e1.setLastname("Zhang");
		e1.setEmail("huining@gmail.com");
		e1.setDesignation("Developer");
//		e1.setJoiningDate(02-25-2019);
		employees.put(1001, e1);
	}
	
	private static int id = 1002;
	public void save(Employee employee) {
		if(employee.getEmpId() == null) {
			employee.setEmpId(id++);
		}
		employees.put(employee.getEmpId(), employee);
	}
	//return all employees
	public Collection<Employee> getAllEmployees(){
		return employees.values();
	}
	//delete employees
	public void delete(Integer empId) {
		employees.remove(empId);
	}
	//search employee by id
	public Employee getEmployeeById(Integer empId) {
		return employees.get(empId);
	}
}
