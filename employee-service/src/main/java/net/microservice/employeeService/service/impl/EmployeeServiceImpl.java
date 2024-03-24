package net.microservice.employeeService.service.impl;

import lombok.AllArgsConstructor;
import net.microservice.employeeService.dto.EmployeeDto;
import net.microservice.employeeService.entity.Employee;
import net.microservice.employeeService.repository.EmployeeRepository;
import net.microservice.employeeService.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    /**
     * @param employeeDto
     * @return
     */
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        //convert EmployeeDto to Employee JPA entity

        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );

        Employee savedEmployee =employeeRepository.save(employee);


        EmployeeDto savedEmployeeDto = new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail()
        );


        return savedEmployeeDto;
    }
}
