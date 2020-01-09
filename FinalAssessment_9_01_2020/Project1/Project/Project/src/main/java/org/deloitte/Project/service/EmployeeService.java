package org.deloitte.Project.service;

import java.util.List;

import org.deloitte.Project.entity.EmployeeEntity;
import org.springframework.stereotype.Service;

@Service("employeeService")
public interface EmployeeService 
{
	public List<EmployeeEntity> listEmployees();
	public EmployeeEntity addEmployee(EmployeeEntity employee);
	public String deleteEmployee(EmployeeEntity emp);
	public EmployeeEntity findByEmployeeId(Long id,EmployeeEntity employee);

}
