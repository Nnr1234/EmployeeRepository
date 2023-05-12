package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	@Override
	public String addEmployee(Employee employee) {
		Employee save = repository.save(employee);
		return "Employee is saved with id value"+save.getEmployeeID() ;
	}

	@Override
	public void fetchEmployeeTaxes() {
		List<Employee> findAll = repository.findAll();
	
		
	}

}
