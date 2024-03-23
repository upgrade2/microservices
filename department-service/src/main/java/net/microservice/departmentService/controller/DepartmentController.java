package net.microservice.departmentService.controller;

import lombok.AllArgsConstructor;
import net.microservice.departmentService.dto.DepartmentDto;
import net.microservice.departmentService.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    //Build get department rest-api
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
    DepartmentDto departmentDto=departmentService.getDepartmentByCode(departmentCode);
    return new ResponseEntity<>(departmentDto,HttpStatus.OK);
    }

}
