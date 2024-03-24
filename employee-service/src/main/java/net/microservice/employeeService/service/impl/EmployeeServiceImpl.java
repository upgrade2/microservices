package net.microservice.employeeService.service.impl;

import lombok.AllArgsConstructor;
import net.microservice.employeeService.dto.APIResponseDto;
import net.microservice.employeeService.dto.DepartmentDto;
import net.microservice.employeeService.dto.EmployeeDto;
import net.microservice.employeeService.entity.Employee;
import net.microservice.employeeService.repository.EmployeeRepository;
import net.microservice.employeeService.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
   // private RestTemplate restTemplate;

    private WebClient webClient;
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
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );

        Employee savedEmployee =employeeRepository.save(employee);


        EmployeeDto savedEmployeeDto = new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail(),
                savedEmployee.getDepartmentCode()
        );



        return savedEmployeeDto;
    }

    /**
     * @param employeeId
     * @return
     */
    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();

//       ResponseEntity<DepartmentDto> responseEntity =restTemplate.getForEntity("http://localhost:8080/api/department/"+employee.getDepartmentCode(), DepartmentDto.class);
// DepartmentDto departmentDto =responseEntity.getBody();

        //call from WebClient
       DepartmentDto departmentDto = webClient.get().uri("http://localhost:8080/api/department/"+employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();



        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);

        return apiResponseDto;
    }
}
