package net.microservice.employeeService.service;

import net.microservice.employeeService.dto.EmployeeDto;

public interface EmployeeService {

   public EmployeeDto saveEmployee(EmployeeDto employeeDto);
   public EmployeeDto getEmployeeById(Long employeeId);
}
