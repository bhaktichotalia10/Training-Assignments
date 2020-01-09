package org.deloitte.Project.service;

import java.util.List;
import java.util.function.Function;

import javax.management.relation.RelationNotFoundException;
import javax.validation.Valid;

import org.deloitte.Project.entity.EmployeeEntity;
import org.deloitte.Project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<EmployeeEntity> listEmployees()
	{
		List<EmployeeEntity> employeeList = employeeRepository.findAll();
		return employeeList;
	}
	
	public EmployeeEntity addEmployee(@Valid @RequestBody EmployeeEntity employee)
	{
		return employeeRepository.save(employee);
	}
	
	public String deleteEmployee(EmployeeEntity emp)
	{
		String message="Employee Not Found";
		try {
			employeeRepository.delete(emp);
		} catch (Exception e) {
			e.printStackTrace();
			}
			return message;	
	}
	
	public EmployeeEntity findByEmployeeId(Long id, EmployeeEntity employee)
	{
		EmployeeEntity updatedemp;
		try {
			updatedemp = employeeRepository.findById(id).map(emp -> {
				emp.setName(employee.getName());
				emp.setDesg(employee.getDesg());
				emp.setDeptId(employee.getDeptId());
				emp.setEmail(employee.getEmail());
				return employeeRepository.save(emp);
			}).orElseThrow(()-> new RelationNotFoundException("Employee Id "+id+" not found"));
		} catch (RelationNotFoundException e) {
			e.printStackTrace();
			return null;
		}	
		return updatedemp;
	}

}
