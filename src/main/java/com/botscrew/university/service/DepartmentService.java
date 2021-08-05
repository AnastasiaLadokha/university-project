package com.botscrew.university.service;

import com.botscrew.university.domain.StatisticDto;
import com.botscrew.university.entity.Degree;
import com.botscrew.university.entity.Department;
import com.botscrew.university.entity.Lector;
import com.botscrew.university.exception.NoSuchDepartmentException;
import com.botscrew.university.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public String getHeadOfDepartmentName(String departmentName) {
        Department department = departmentRepository.getDepartmentByDepartmentName(departmentName)
                .orElseThrow(() -> new NoSuchDepartmentException(
                        "There is no such department with name " + departmentName
                ));
        return department.getHeadOfDepartment();
    }

    @Transactional(readOnly = true)
    public StatisticDto getStatistics(String departmentName) {
        Department department = departmentRepository.getDepartmentByDepartmentName(departmentName)
                .orElseThrow(() -> new NoSuchDepartmentException(
                        "There is no such department with name " + departmentName
                ));
        Map<Degree, Long> degreeToLectorsMap = department
                .getLectors()
                .stream()
                .collect(Collectors.groupingBy(Lector::getDegree, Collectors.counting()));

        StatisticDto statisticDto = new StatisticDto();
        statisticDto.setAssistantsCount(degreeToLectorsMap.get(Degree.ASSISTANT));
        statisticDto.setAssociateProfessorsCount(degreeToLectorsMap.get(Degree.ASSOCIATE_PROFESSOR));
        statisticDto.setProfessorsCount(degreeToLectorsMap.get(Degree.PROFESSOR));
        return statisticDto;
    }

    @Transactional(readOnly = true)
    public Double getAverageSalary(String departmentName) {
        Department department = departmentRepository.getDepartmentByDepartmentName(departmentName)
                .orElseThrow(() -> new NoSuchDepartmentException(
                        "There is no such department with name " + departmentName
                ));

        return department.getLectors()
                .stream()
                .collect(Collectors.averagingInt(Lector::getSalary));
    }

    @Transactional(readOnly = true)
    public Integer getCountOfEmployee(String departmentName) {
        Department department = departmentRepository.getDepartmentByDepartmentName(departmentName)
                .orElseThrow(() -> new NoSuchDepartmentException(
                        "There is no such department with name " + departmentName
                ));
        return department.getLectors().size();
    }
}
