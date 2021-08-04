package com.botscrew.university.controller;

import com.botscrew.university.domain.StatisticDto;
import com.botscrew.university.entity.Department;
import com.botscrew.university.repository.DepartmentRepository;
import com.botscrew.university.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    private final DepartmentService departmentService;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentController(DepartmentService departmentService,
                                DepartmentRepository departmentRepository) {
        this.departmentService = departmentService;
        this.departmentRepository = departmentRepository;
    }

    @GetMapping("/departments")
    public List<Department> getDepartments(){
        return departmentRepository.findAll();
    }

    @GetMapping("/department/{id}")
    public Department getDepartment(@PathVariable Long id){
        return departmentRepository.getById(id);
    }

    @PostMapping("/department")
    public void addDepartment(@RequestBody Department department){
        departmentRepository.save(department);
    }

    @PatchMapping("/department")
    public void editDepartment(@RequestBody Department department){
        departmentRepository.save(department);
    }

    @DeleteMapping("/department/{id}")
    public void deleteDepartment(@PathVariable Long id){
        departmentRepository.deleteById(id);
    }

    @GetMapping("/department/{name}/head")
    public String getHeadOfDepartmentName(@PathVariable(name = "name") String departmentName){
        return departmentService.getHeadOfDepartmentName(departmentName);
    }

    @GetMapping("/department/{name}/statistic")
    public StatisticDto getStatistics(@PathVariable(name = "name") String departmentName){
        return departmentService.getStatistics(departmentName);
    }

    @GetMapping("/department/{name}/salary")
    public Double getAverageSalary(@PathVariable(name = "name") String departmentName){
        return departmentService.getAverageSalary(departmentName);
    }

    @GetMapping("/department/{name}/employeeCount")
    public Integer getEmployeeCount(@PathVariable(name = "name") String departmentName){
        return departmentService.getCountOfEmployee(departmentName);
    }
}
