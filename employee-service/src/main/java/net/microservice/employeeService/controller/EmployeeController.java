package net.microservice.employeeService.controller;

import lombok.AllArgsConstructor;
import net.microservice.employeeService.dto.APIResponseDto;
import net.microservice.employeeService.dto.EmployeeDto;
import net.microservice.employeeService.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employee")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    //Build save employee rest-api
    @PostMapping
    public ResponseEntity<EmployeeDto> saveDepartment(@RequestBody EmployeeDto employeeDto){
        EmployeeDto saveEmployee =  employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }

    //Build Get Employee rest-api
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long employeeId){
        APIResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
    }


}
