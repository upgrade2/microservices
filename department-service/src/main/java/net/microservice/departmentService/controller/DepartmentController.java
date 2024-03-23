package net.microservice.departmentService.controller;

import lombok.AllArgsConstructor;
import net.microservice.departmentService.dto.DepartmentDto;
import net.microservice.departmentService.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/department")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;

    //Build save department rest-api
@PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
      DepartmentDto saveDepartment =  departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
    }

}
