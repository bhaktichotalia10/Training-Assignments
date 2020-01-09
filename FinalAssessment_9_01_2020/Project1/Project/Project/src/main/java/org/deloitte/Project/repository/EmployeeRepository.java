package org.deloitte.Project.repository;

import org.deloitte.Project.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("employeeRepository")
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> 
{
	
}
