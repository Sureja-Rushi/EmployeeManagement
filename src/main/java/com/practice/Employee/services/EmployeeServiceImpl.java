package com.practice.Employee.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.practice.Employee.entity.EmployeeEntity;
import com.practice.Employee.model.Employee;
import com.practice.Employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public Employee createEmployee(Employee employee) {
		
		EmployeeEntity employeeEntity = new EmployeeEntity();
		
		BeanUtils.copyProperties(employee, employeeEntity);
		employeeRepository.save(employeeEntity);
		return employee;
	}
	
}
