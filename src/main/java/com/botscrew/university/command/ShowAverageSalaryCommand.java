package com.botscrew.university.command;

import com.botscrew.university.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ShowAverageSalaryCommand implements ConsoleCommand {

    private static final String NAME = "3";

    private final DepartmentService departmentService;

    @Autowired
    public ShowAverageSalaryCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter department name: ");
        String departmentName = scanner.next();

        Double averageSalary = departmentService.getAverageSalary(departmentName);

        String result = String.format("The average salary of %s is %s\n",
                departmentName, averageSalary);
        System.out.println(result);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
