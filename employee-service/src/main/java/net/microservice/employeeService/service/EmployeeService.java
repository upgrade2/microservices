package net.microservice.employeeService.service;

import net.microservice.employeeService.dto.APIResponseDto;
import net.microservice.employeeService.dto.EmployeeDto;

public interface EmployeeService {

   public EmployeeDto saveEmployee(EmployeeDto employeeDto);
   public APIResponseDto getEmployeeById(Long employeeId);
}
