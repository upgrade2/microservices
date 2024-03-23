package net.microservice.departmentService.service.impl;

import lombok.AllArgsConstructor;
import net.microservice.departmentService.dto.DepartmentDto;
import net.microservice.departmentService.entity.Department;
import net.microservice.departmentService.repository.DepartmentRepository;
import net.microservice.departmentService.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    /**
     *
     * @param departmentDto
     * @return
     */
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        //convert department dto to department JPA entity

        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );

       Department savedDepartment =departmentRepository.save(department);


       DepartmentDto savedDepartmentDto = new DepartmentDto(
               savedDepartment.getId(),
               savedDepartment.getDepartmentName(),
               savedDepartment.getDepartmentDescription(),
               savedDepartment.getDepartmentCode()
       );



        return savedDepartmentDto;
    }

    /**
     * @param departmentCode
     * @return
     */
    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        DepartmentDto departmentDto = new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );

        return departmentDto;
    }
}
